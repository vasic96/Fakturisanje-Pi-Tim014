package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tim014.pi.fakturisanje.dto.PoslovniPartnerDTO;
import tim014.pi.fakturisanje.model.PoslovniPartner;
import tim014.pi.fakturisanje.repositories.PoslovniPartneriRepository;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "api/poslovni_partner/")
@RestController
public class PoslovniPartnerController {

    @Autowired
    private PoslovniPartneriRepository poslovniPartneriRepos;

    @GetMapping("all")
    public ResponseEntity<?> sviPartneri(){

        List<PoslovniPartnerDTO> partneriDTO = new ArrayList<>();
        for (PoslovniPartner partner: poslovniPartneriRepos.findAll()) {

            partneriDTO.add(new PoslovniPartnerDTO(partner));
        }

        return new ResponseEntity<List<PoslovniPartnerDTO>>(partneriDTO,HttpStatus.OK);
    }

}
