package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim014.pi.fakturisanje.dto.StavkaCenovnikaDTO;
import tim014.pi.fakturisanje.model.StavkaCenovnika;
import tim014.pi.fakturisanje.repositories.StavkaCenovnikaRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/stavka_cenovnika")
public class StavkaCenovnikaController {

    @Autowired
    private StavkaCenovnikaRepository stavkaCenovnikaRepo;

    @GetMapping(value = "/all")
    public ResponseEntity<List<StavkaCenovnikaDTO>> dajSveStavkeCenovnika() {
        List<StavkaCenovnikaDTO> stavkaCenovnikaDto = new ArrayList<>();
        for (StavkaCenovnika stavkaCenovnika : stavkaCenovnikaRepo.findAll()) {
            stavkaCenovnikaDto.add(new StavkaCenovnikaDTO(stavkaCenovnika));
        }
        return new ResponseEntity<List<StavkaCenovnikaDTO>>(stavkaCenovnikaDto, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "APPLICATION/JSON")
    public ResponseEntity<StavkaCenovnika> dodajStavkuCenovnika(@RequestBody StavkaCenovnika stavkaCenovnika) {
        if (stavkaCenovnika == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<StavkaCenovnika>(stavkaCenovnikaRepo.save(stavkaCenovnika), HttpStatus.OK);
    }

    @GetMapping(value = "/all/{id}")
    public ResponseEntity<StavkaCenovnikaDTO> dajStavkuCenovnikaPoId(@PathVariable Long id) {
        if (!stavkaCenovnikaRepo.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<StavkaCenovnikaDTO>(new StavkaCenovnikaDTO(stavkaCenovnikaRepo.getOne(id)), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> izbrisiStavkuCenovnika(@PathVariable Long id) {
        if (!stavkaCenovnikaRepo.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        stavkaCenovnikaRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
