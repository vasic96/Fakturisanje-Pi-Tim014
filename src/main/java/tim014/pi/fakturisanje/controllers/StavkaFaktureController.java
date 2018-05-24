package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim014.pi.fakturisanje.dto.StavkaFaktureDTO;
import tim014.pi.fakturisanje.model.*;
import tim014.pi.fakturisanje.repositories.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
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

        StavkaFakture stavkaFakture = new StavkaFakture();
        stavkaFakture.setKolicina(faktureDTO.getKolicina());
        double jedinicnaCena = stavkaCenovnikaRepository.findStavkaCenovnikaByRobaId(faktureDTO.getRobaId()).getCena();
        double cena = jedinicnaCena * faktureDTO.getKolicina();
        //double procenat = stopaPdvRepository.findStopaPDVByPdvId(robaRepository.getOne(faktureDTO.getRobaId()).getGrupaRobe().getPdv().getId()).getProcenat();
        List<StopaPDV> stope = stopaPdvRepository.findAllStopaPDVByPdvId(robaRepository.getOne(faktureDTO.getRobaId()).getGrupaRobe().getPdv().getId());
        double procenat = stope.get(stope.size()-1).getProcenat();
        stavkaFakture.setRabat(faktureDTO.getRabat());
        double osnovicaPDV = cena - ((cena / 100) * faktureDTO.getRabat());
        stavkaFakture.setOsnovicaPDV(osnovicaPDV);
        double iznosPDV = (osnovicaPDV / 100) * procenat;
        stavkaFakture.setIznosPDV(iznosPDV);
        stavkaFakture.setIznosStavka(osnovicaPDV + iznosPDV);
        stavkaFakture.setRoba(robaRepository.getOne(faktureDTO.getRobaId()));
        Faktura faktura = fakturaRepository.getOne(faktureDTO.getFakturaId());
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



}
