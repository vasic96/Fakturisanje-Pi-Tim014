package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim014.pi.fakturisanje.dto.PreduzeceDTO;
import tim014.pi.fakturisanje.model.Preduzece;
import tim014.pi.fakturisanje.repositories.MestoRepository;
import tim014.pi.fakturisanje.repositories.PreduzeceRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PreduzeceController {

    @Autowired
    private PreduzeceRepository preduzeceRepo;

    @Autowired
    private MestoRepository mestoRepo;


    @PostMapping(value = "sign-up")
    public ResponseEntity<PreduzeceDTO> register(@RequestBody PreduzeceDTO preduzeceDTO) {

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
            preduzeceRepo.save(preduzece);
            return new ResponseEntity<PreduzeceDTO>(new PreduzeceDTO(preduzece), HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping(value = "api/preduzece/all")
    public ResponseEntity<List<PreduzeceDTO>> svaPreduzeca() {
        List<PreduzeceDTO> preduzecaDTO = new ArrayList<>();
        for (Preduzece preduzece : preduzeceRepo.findAll()) {
            preduzecaDTO.add(new PreduzeceDTO(preduzece));
        }
        return new ResponseEntity<List<PreduzeceDTO>>(preduzecaDTO, HttpStatus.OK);

    }

    @GetMapping(value = "api/preduzece/mesto/{id}")
    public ResponseEntity<List<PreduzeceDTO>> svaPreduzecaUMestu(@PathVariable Long id) {
        List<PreduzeceDTO> preduzecaDTO = new ArrayList<>();
        for (Preduzece preduzece : preduzeceRepo.findAllByMestoId(id)) {
            preduzecaDTO.add(new PreduzeceDTO(preduzece));
        }
        return new ResponseEntity<List<PreduzeceDTO>>(preduzecaDTO, HttpStatus.OK);
    }


}
