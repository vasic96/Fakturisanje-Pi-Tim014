package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim014.pi.fakturisanje.dto.PoslovniPartnerDTO;
import tim014.pi.fakturisanje.model.PoslovniPartner;
import tim014.pi.fakturisanje.repositories.PoslovniPartneriRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/poslovni_partner")
public class PoslovniPartnerController {

    @Autowired
    private PoslovniPartneriRepository PPrepo;

    @GetMapping(value = "/all")
    public ResponseEntity<List<PoslovniPartnerDTO>> dajSvePoslovnePartnere() {
        List<PoslovniPartnerDTO> pp_repo = new ArrayList<>();
        for (PoslovniPartner pp : PPrepo.findAll()) {
            pp_repo.add(new PoslovniPartnerDTO(pp));
        }
        return new ResponseEntity<List<PoslovniPartnerDTO>>(pp_repo, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "APPLICATION/JSON")
    public ResponseEntity<PoslovniPartner> dodajPoslovnogPartnera(@RequestBody PoslovniPartner pp) {
        if (pp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PoslovniPartner>(PPrepo.save(pp), HttpStatus.OK);
    }

    @GetMapping(value = "/all/{id}")
    public ResponseEntity<PoslovniPartnerDTO> dajPoslovnogPartneraPoId(@PathVariable Long id) {
        if (!PPrepo.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PoslovniPartnerDTO>(new PoslovniPartnerDTO(PPrepo.getOne(id)), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> izbrisiPoslovnogPartnera(@PathVariable Long id) {
        if (!PPrepo.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PPrepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
