package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim014.pi.fakturisanje.model.Mesto;
import tim014.pi.fakturisanje.repositories.MestoRepository;

import java.util.List;


@RestController
@RequestMapping(value = "api/mesto")
public class MestoController {

    @Autowired
    private MestoRepository mestoRepo;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Mesto>> dajSvaMesta() {

        return new ResponseEntity<List<Mesto>>(mestoRepo.findAll(), HttpStatus.OK);

    }

    @PostMapping(value = "/add", consumes = "APPLICATION/JSON")
    public ResponseEntity<Mesto> dodajMesto(@RequestBody Mesto mesto) {

        if (mesto != null) {
            return new ResponseEntity<Mesto>(mestoRepo.save(mesto), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
