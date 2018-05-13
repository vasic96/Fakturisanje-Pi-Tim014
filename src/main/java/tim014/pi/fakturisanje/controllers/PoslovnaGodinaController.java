package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim014.pi.fakturisanje.dto.PoslovnaGodinaDTO;
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

    @PostMapping(value = "/add")
    public ResponseEntity<PoslovnaGodinaDTO> register(@RequestBody PoslovnaGodinaDTO pGodinaDTO) {
        if (pGodinaDTO != null) {
            PoslovnaGodina pgodina = new PoslovnaGodina(pGodinaDTO.getGodina(), pGodinaDTO.isZakljucena());
            pGodinaRep.save(pgodina);
            return new ResponseEntity<PoslovnaGodinaDTO>(new PoslovnaGodinaDTO(pgodina), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<PoslovnaGodina> obrisiGodinu(@PathVariable Long id) {
        pGodinaRep.deleteById(id);
        return new ResponseEntity<PoslovnaGodina>(HttpStatus.OK);
    }

    @GetMapping(value = "/all/{id}")
    public ResponseEntity<PoslovnaGodina> dajPoslovnuGodinuPoId(@PathVariable Long id) {
        if (!pGodinaRep.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PoslovnaGodina>(pGodinaRep.getOne(id), HttpStatus.OK);
    }
}
