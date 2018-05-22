package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tim014.pi.fakturisanje.dto.FakturaDTO;
import tim014.pi.fakturisanje.model.Faktura;
import tim014.pi.fakturisanje.repositories.FakturaRepository;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "api/fakture")
@RestController
public class FakturaController {

    @Autowired
    private FakturaRepository fakturaRepo;

    @GetMapping("/all")
    public ResponseEntity<?> sveFakture(){
        List faktureDTO = new ArrayList();
        for (Faktura faktura:fakturaRepo.findAll()) {
            faktureDTO.add(new FakturaDTO(faktura));
        }
        return  new ResponseEntity<List<FakturaDTO>>(faktureDTO,HttpStatus.OK);
    }

}
