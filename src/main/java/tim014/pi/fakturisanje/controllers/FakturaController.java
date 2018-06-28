package tim014.pi.fakturisanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tim014.pi.fakturisanje.dto.FakturaDTO;
import tim014.pi.fakturisanje.model.Faktura;
import tim014.pi.fakturisanje.repositories.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "api/fakture")
@RestController
public class FakturaController {

    @Autowired
    private FakturaRepository fakturaRepo;

    @Autowired
    private PreduzeceRepository preduzeceRepo;

    @Autowired
    private PoslovniPartneriRepository poslovniPartneriRepository;

    @Autowired
    private PoslovnaGodinaRepository poslovnaGodinaRepository;

    @Autowired
    private StavkaFaktureRepository stavkaFaktureRepository;

    @GetMapping("/all")
    public ResponseEntity<?> sveFakture(@RequestParam("page") Integer page,
                                        @RequestParam("direction") String dir,
                                        @RequestParam("order") String oreder){

        Sort.Direction direction;
        if(dir.equals("ASC")){
            direction = Sort.Direction.ASC;
        }else {
            direction = Sort.Direction.DESC;
        }

        PageRequest request = PageRequest.of(page -1,10,direction,oreder);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getPrincipal().toString();

        Page<FakturaDTO> faktureDTO = fakturaRepo.findAllByPreduzeceEmail(email,request).map(
                faktura -> new FakturaDTO(faktura)
        );


        return  new ResponseEntity<Page<FakturaDTO>>(faktureDTO,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> dodajFakturu(@RequestBody FakturaDTO fakturaDTO){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getPrincipal().toString();

        if (fakturaDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!poslovnaGodinaRepository.existsById(fakturaDTO.getPoslovnaGodinaId()) || !poslovniPartneriRepository.existsById(fakturaDTO.getPoslovniPartnerId())){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        Faktura faktura = new Faktura();
        faktura.setDatumFakture(fakturaDTO.getDatumFakture());
        faktura.setDatumValute(fakturaDTO.getDatumValute());
        faktura.setPreduzece(preduzeceRepo.findByEmail(email));
        faktura.setPoslovnaGodina(poslovnaGodinaRepository.getOne(fakturaDTO.getPoslovnaGodinaId()));
        faktura.setPoslovniPartner(poslovniPartneriRepository.getOne(fakturaDTO.getPoslovniPartnerId()));
        faktura.setStatus(fakturaDTO.getStatus());

        return new ResponseEntity<FakturaDTO>(new FakturaDTO(fakturaRepo.save(faktura)),HttpStatus.OK);

    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> fakturaPoId(@PathVariable Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getPrincipal().toString();
        if(!fakturaRepo.existsById(id) ){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(!fakturaRepo.getOne(id).getPreduzece().getEmail().equals(email)){
            return  new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<FakturaDTO>(new FakturaDTO(fakturaRepo.getOne(id)),HttpStatus.OK);

    }
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> izbrisiFakturu(@PathVariable Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getPrincipal().toString();

        Faktura faktura =  fakturaRepo.getOne(id);
        if(faktura == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!faktura.getPreduzece().getEmail().equals(email)){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        stavkaFaktureRepository.deleteAllByFakturaId(faktura.getId());
        fakturaRepo.delete(faktura);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}