package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim014.pi.fakturisanje.model.Mesto;
import tim014.pi.fakturisanje.repositories.MestoRepository;

import javax.xml.ws.Response;
import java.util.List;


@RestController
public class MestoController {

    @Autowired
    private MestoRepository mestoRepo;

    @GetMapping(value = "open/mesto/all")
    public ResponseEntity<List<Mesto>> dajSvaMesta() {

        return new ResponseEntity<List<Mesto>>(mestoRepo.findAll(), HttpStatus.OK);

    }

    @PostMapping(value = "open/mesto/add", consumes = "APPLICATION/JSON")
    public ResponseEntity<Mesto> dodajMesto(@RequestBody Mesto mesto) {

        if (mesto != null) {
            return new ResponseEntity<Mesto>(mestoRepo.save(mesto), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping(value = "/all/{id}")
    public ResponseEntity<Mesto> dajMestoPoId(@PathVariable Long id) {

        if (mestoRepo.existsById(id)) {
            return new ResponseEntity<Mesto>(mestoRepo.getOne(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(value = "api/mesto/delete/{id}")
    public ResponseEntity<?> izbrisiMesto(@PathVariable Long id) {

        if (mestoRepo.existsById(id)) {
            mestoRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping(value = "api/mesto/update/{id}")
    public ResponseEntity<?> updateMesto(@RequestBody Mesto updatedMesto, @PathVariable Long id){
        Mesto mesto = mestoRepo.getOne(id);
            if(mesto == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        mesto.setId(id);
        mesto.setGrad(updatedMesto.getGrad());
        mesto.setDrzava(updatedMesto.getDrzava());
        mestoRepo.save(mesto);

        return new ResponseEntity<Mesto>(HttpStatus.OK);
    }


}
