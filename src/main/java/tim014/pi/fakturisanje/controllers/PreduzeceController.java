package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tim014.pi.fakturisanje.dto.PreduzeceDTO;
import tim014.pi.fakturisanje.model.Preduzece;
import tim014.pi.fakturisanje.repositories.MestoRepository;
import tim014.pi.fakturisanje.repositories.PreduzeceRepository;

import java.util.List;

@RestController
public class PreduzeceController {

    @Autowired
    private PreduzeceRepository preduzeceRepo;

    @Autowired
    private MestoRepository mestoRepo;

    @PostMapping(value = "api/preduzece/dodaj")
    public ResponseEntity<?> register(@RequestBody PreduzeceDTO preduzeceDTO) {

        if (preduzeceDTO != null) {

            Preduzece preduzece = new Preduzece();
            preduzece.setNaziv(preduzeceDTO.getNaziv());
            preduzece.setAdresa(preduzeceDTO.getAdresa());
            preduzece.setPib(preduzeceDTO.getPib());
            preduzece.setTelefon(preduzeceDTO.getTelefon());
            preduzece.setEmail(preduzeceDTO.getEmail());
            preduzece.setPassword(preduzeceDTO.getPassword());
            preduzece.setLogo(preduzeceDTO.getLogo());
            preduzece.setTip(preduzeceDTO.getTip());
            preduzece.setMesto(mestoRepo.getOne(preduzeceDTO.getMestoId()));

            return new ResponseEntity<>(new PreduzeceDTO(preduzece), HttpStatus.OK);


        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping
    public ResponseEntity<List<Preduzece>> svaPreduzeca() {

        return new ResponseEntity<List<Preduzece>>(preduzeceRepo.findAll(), HttpStatus.OK);

    }


}
