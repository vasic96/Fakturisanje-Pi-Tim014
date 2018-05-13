package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim014.pi.fakturisanje.dto.CenovnikDTO;
import tim014.pi.fakturisanje.model.Cenovnik;
import tim014.pi.fakturisanje.repositories.CenovnikRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/cenovnik")
public class CenovnikController {

    @Autowired
    private CenovnikRepository cenovnikRepo;

    @GetMapping(value = "/all")
    public ResponseEntity<List<CenovnikDTO>> dajSveCenovnike() {
        List<CenovnikDTO> cenovniciDto = new ArrayList<>();
        for (Cenovnik cenovnik : cenovnikRepo.findAll()) {
            cenovniciDto.add(new CenovnikDTO(cenovnik));
        }
        return new ResponseEntity<List<CenovnikDTO>>(cenovniciDto, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "APPLICATION/JSON")
    public ResponseEntity<Cenovnik> dodajCenovnik(@RequestBody Cenovnik cenovnik) {
        if (cenovnik == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cenovnik>(cenovnikRepo.save(cenovnik), HttpStatus.OK);
    }

    @GetMapping(value = "/all/{id}")
    public ResponseEntity<CenovnikDTO> dajCenovnikPoId(@PathVariable Long id) {
        if (!cenovnikRepo.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CenovnikDTO>(new CenovnikDTO(cenovnikRepo.getOne(id)), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> izbrisiCenovnik(@PathVariable Long id) {
        if (!cenovnikRepo.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cenovnikRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
