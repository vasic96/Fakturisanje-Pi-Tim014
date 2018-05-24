package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tim014.pi.fakturisanje.dto.StavkaFaktureDTO;
import tim014.pi.fakturisanje.model.*;
import tim014.pi.fakturisanje.repositories.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "api/stavka_fakture")
@RestController
public class StavkaFaktureController {

    @Autowired
    private StavkaCenovnikaRepository stavkaCenovnikaRepository;

    @Autowired
    private StavkaFaktureRepository stavkaFaktureRepository;

    @Autowired
    private GrupaRobeRepository grupaRobeRepository;

    @Autowired
    private PdvRepository pdvRepository;

    @Autowired
    private StopaPdvRepository stopaPdvRepository;

    @Autowired
    private RobaRepository robaRepository;

    @Autowired
    private FakturaRepository fakturaRepository;

    @PostMapping("/add")
    public ResponseEntity<?> dodajStavku(@RequestBody StavkaFaktureDTO faktureDTO){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getPrincipal().toString();
        Faktura faktura = fakturaRepository.getOne(faktureDTO.getFakturaId());

        boolean procenatOk = faktureDTO.getProcenatPDV() >= 0 && faktureDTO.getProcenatPDV() <91;
        boolean kolicinaOk = faktureDTO.getKolicina()>0;

        if(faktura == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(!faktura.getPreduzece().getEmail().equals(email) || !procenatOk || !kolicinaOk){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        StavkaFakture stavkaFakture = new StavkaFakture();


        double jedinicnaCena = stavkaCenovnikaRepository.findStavkaCenovnikaByRobaId(faktureDTO.getRobaId()).getCena();
        double cena = jedinicnaCena * faktureDTO.getKolicina();

        PDV pdv = robaRepository.getOne(faktureDTO.getRobaId()).getGrupaRobe().getPdv();
        List<StopaPDV> stope = stopaPdvRepository.findAllStopaPDVByPdvId(pdv.getId());
        double procenat = stope.get(stope.size()-1).getProcenat();
        double osnovicaPDV = cena - ((cena / 100) * faktureDTO.getRabat());
        double iznosPDV = (osnovicaPDV / 100) * procenat;

        stavkaFakture.setRabat(faktureDTO.getRabat());
        stavkaFakture.setOsnovicaPDV(osnovicaPDV);
        stavkaFakture.setKolicina(faktureDTO.getKolicina());
        stavkaFakture.setIznosPDV(iznosPDV);
        stavkaFakture.setIznosStavka(osnovicaPDV + iznosPDV);
        stavkaFakture.setRoba(robaRepository.getOne(faktureDTO.getRobaId()));
        stavkaFakture.setFaktura(faktura);
        stavkaFakture.setProcenatPDV(procenat);
        stavkaFakture.setJedinicnaCena(jedinicnaCena);

        faktura.setOsnovica(faktura.getOsnovica() + osnovicaPDV);
        faktura.setUkupanPDV(faktura.getUkupanPDV() + iznosPDV);
        faktura.setIznosZaPlacanje(faktura.getIznosZaPlacanje() + osnovicaPDV + iznosPDV);

        stavkaFaktureRepository.save(stavkaFakture);
        fakturaRepository.save(faktura);


        return new ResponseEntity<>(HttpStatus.OK);



    }

    @GetMapping("/faktura/{id}")
    public ResponseEntity<?> svePoFakturi(@PathVariable Long id){
        List<StavkaFaktureDTO> stavkeDTO = new ArrayList<>();
        for(StavkaFakture stavkaFakture : stavkaFaktureRepository.findAllByFakturaId(id)){
            stavkeDTO.add(new StavkaFaktureDTO(stavkaFakture));
        }

        return new ResponseEntity<List<StavkaFaktureDTO>>(stavkeDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> izbrisiStavku(@PathVariable Long id){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getPrincipal().toString();

        StavkaFakture stavkaFakture = stavkaFaktureRepository.getOne(id);
        if(stavkaFakture==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!stavkaFakture.getFaktura().getPreduzece().getEmail().equals(email)){

            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

        Faktura faktura = stavkaFakture.getFaktura();
        faktura.setOsnovica(faktura.getOsnovica() - stavkaFakture.getOsnovicaPDV());
        faktura.setUkupanPDV(faktura.getUkupanPDV() - stavkaFakture.getIznosPDV());
        faktura.setIznosZaPlacanje(faktura.getIznosZaPlacanje() - stavkaFakture.getIznosStavka());
        fakturaRepository.save(faktura);
        stavkaFaktureRepository.delete(stavkaFakture);

        return new ResponseEntity<>(HttpStatus.OK);


    }



}
