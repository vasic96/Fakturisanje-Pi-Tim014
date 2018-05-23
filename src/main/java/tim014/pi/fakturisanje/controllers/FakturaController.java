package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim014.pi.fakturisanje.dto.FakturaDTO;
import tim014.pi.fakturisanje.model.Faktura;
import tim014.pi.fakturisanje.repositories.FakturaRepository;
import tim014.pi.fakturisanje.repositories.PoslovnaGodinaRepository;
import tim014.pi.fakturisanje.repositories.PoslovniPartneriRepository;
import tim014.pi.fakturisanje.repositories.PreduzeceRepository;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "api/fakture")
@RestController
public class FakturaController {

    @Autowired
    private FakturaRepository fakturaRepo;

    @Autowired
    private PreduzeceRepository preduzeceRepo;

    @Autowired
    private PoslovniPartneriRepository poslovniPartneriRepository;

    @Autowired
    private PoslovnaGodinaRepository poslovnaGodinaRepository;

    @GetMapping("/all")
    public ResponseEntity<?> sveFakture(){
        List faktureDTO = new ArrayList();
        for (Faktura faktura:fakturaRepo.findAll()) {
            faktureDTO.add(new FakturaDTO(faktura));
        }
        return  new ResponseEntity<List<FakturaDTO>>(faktureDTO,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> dodajFakturu(@RequestBody FakturaDTO fakturaDTO){
        if (fakturaDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!preduzeceRepo.existsById(fakturaDTO.getPreduzeceId()) || !poslovnaGodinaRepository.existsById(fakturaDTO.getPoslovnaGodinaId()) || !poslovniPartneriRepository.existsById(fakturaDTO.getPoslovniPartnerId())){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        Faktura faktura = new Faktura();
        faktura.setDatumFakture(fakturaDTO.getDatumFakture());
        faktura.setDatumValute(fakturaDTO.getDatumValute());
        faktura.setPreduzece(preduzeceRepo.getOne(fakturaDTO.getPreduzeceId()));
        faktura.setPoslovnaGodina(poslovnaGodinaRepository.getOne(fakturaDTO.getPoslovnaGodinaId()));
        faktura.setPoslovniPartner(poslovniPartneriRepository.getOne(fakturaDTO.getPoslovniPartnerId()));
        faktura.setStatus(fakturaDTO.getStatus());

        return new ResponseEntity<FakturaDTO>(new FakturaDTO(fakturaRepo.save(faktura)),HttpStatus.OK);

    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> fakturaPoId(@PathVariable Long id){
        if(!fakturaRepo.existsById(id)){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<FakturaDTO>(new FakturaDTO(fakturaRepo.getOne(id)),HttpStatus.OK);
    }

}
