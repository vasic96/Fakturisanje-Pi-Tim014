package tim014.pi.fakturisanje.dto;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PoslovniPartnerDTO {

    private Long id;
    private String naziv;
    private String adresa;
    private String vrsta;
    private Long mestoId;
    private Long preduzeceId;
}
