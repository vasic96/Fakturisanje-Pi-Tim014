package tim014.pi.fakturisanje.controllers;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tim014.pi.fakturisanje.dto.PreduzeceDTO;
import tim014.pi.fakturisanje.model.Mesto;
import tim014.pi.fakturisanje.model.PasswordConfirm;
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

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping(value = "sign-up")
    public ResponseEntity<PreduzeceDTO> register(@RequestBody PreduzeceDTO preduzeceDTO) {

        if (preduzeceDTO != null) {
            boolean emailValid = EmailValidator.getInstance().isValid(preduzeceDTO.getEmail());

                if(emailValid && preduzeceDTO.getPassword().length()>4) {
                    Preduzece preduzece = new Preduzece();
                    preduzece.setNaziv(preduzeceDTO.getNaziv());
                    preduzece.setAdresa(preduzeceDTO.getAdresa());
                    preduzece.setPib(preduzeceDTO.getPib());
                    preduzece.setTelefon(preduzeceDTO.getTelefon());
                    preduzece.setEmail(preduzeceDTO.getEmail());
                    preduzece.setPassword(bCryptPasswordEncoder.encode(preduzeceDTO.getPassword()));
                    preduzece.setLogo(preduzeceDTO.getLogo());
                    preduzece.setTip(preduzeceDTO.getTip());
                    preduzece.setMesto(mestoRepo.getOne(preduzeceDTO.getMestoId()));
                    preduzeceRepo.save(preduzece);
                    return new ResponseEntity<PreduzeceDTO>(new PreduzeceDTO(preduzece), HttpStatus.OK);
                }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping(value = "open/preduzece/all")
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

    @PutMapping(value="api/change-password")
    public ResponseEntity<?> promeniSifru(@RequestBody PasswordConfirm passwordConfirm){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getPrincipal().toString();

        Preduzece preduzece = preduzeceRepo.findByEmail(email);
        System.out.println(preduzece.getPassword());
        System.out.println(bCryptPasswordEncoder.encode(passwordConfirm.getOldPassword()));

        boolean isOldPasswordCorrect = bCryptPasswordEncoder.matches(passwordConfirm.getOldPassword(),preduzece.getPassword());

        if(!passwordConfirm.getPassword().equals(passwordConfirm.getConfirmPassword()) || !isOldPasswordCorrect){

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        preduzece.setPassword(bCryptPasswordEncoder.encode(passwordConfirm.getPassword()));
        preduzeceRepo.save(preduzece);

        return  new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/api/change-info")
    public ResponseEntity<?> uzmenaPodataka(@RequestBody PreduzeceDTO preduzeceDTO){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getPrincipal().toString();

        if(preduzeceDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Mesto mesto  = mestoRepo.getOne(preduzeceDTO.getMestoId());

        Preduzece preduzece = preduzeceRepo.findByEmail(email);
        if(!bCryptPasswordEncoder.matches(preduzeceDTO.getPassword(),preduzece.getPassword())){
            System.out.println(bCryptPasswordEncoder.matches(preduzeceDTO.getPassword(),preduzece.getPassword()));
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if(!preduzeceDTO.getEmail().equals(email) && preduzeceRepo.findByEmail(preduzeceDTO.getEmail())!=null && mesto != null)  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        preduzece.setNaziv(preduzeceDTO.getNaziv());
        preduzece.setEmail(preduzeceDTO.getEmail());
        preduzece.setTelefon(preduzeceDTO.getTelefon());
        preduzece.setAdresa(preduzeceDTO.getAdresa());
        preduzece.setTip(preduzeceDTO.getTip());
        preduzece.setMesto(mesto);
        preduzece.setLogo(preduzeceDTO.getLogo());

        preduzeceRepo.save(preduzece);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("api/my-info")
    public ResponseEntity<?> getMyInfo(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getPrincipal().toString();

        return new ResponseEntity<>(new PreduzeceDTO(preduzeceRepo.findByEmail(email)),HttpStatus.OK);


    }


}
