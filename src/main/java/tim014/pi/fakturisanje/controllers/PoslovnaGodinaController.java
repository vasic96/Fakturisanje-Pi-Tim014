package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tim014.pi.fakturisanje.model.PoslovnaGodina;
import tim014.pi.fakturisanje.repositories.PoslovnaGodinaRepository;

import java.util.List;

@RestController
@RequestMapping(value = "api/pgodina")
public class PoslovnaGodinaController {

    @Autowired
    private PoslovnaGodinaRepository pGodinaRep;

    @GetMapping(value = "/all")
    public ResponseEntity<List<PoslovnaGodina>> giveAllPGodina() {

        return new ResponseEntity<List<PoslovnaGodina>>(pGodinaRep.findAll(), HttpStatus.OK);

    }


}
