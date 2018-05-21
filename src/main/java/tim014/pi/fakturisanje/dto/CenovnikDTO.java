package tim014.pi.fakturisanje.dto;

import org.springframework.web.bind.annotation.RestController;
import tim014.pi.fakturisanje.model.Cenovnik;

import java.util.Date;

@RestController
public class CenovnikDTO {

    private Long id;
    private Date datumVazenja;
    private String preduzeceIme;

    public CenovnikDTO(){}

    public CenovnikDTO(Cenovnik cenovnik) {
        this.id = cenovnik.getId();
        this.datumVazenja = cenovnik.getDatumVazenja();
        this.preduzeceIme = cenovnik.getPreduzece().getNaziv();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Date getDatumVazenja() { return datumVazenja; }
    public void setDatumVazenja(Date date) { this.datumVazenja = date; }

    public String getPreduzeceIme() { return preduzeceIme; }
    public void setPreduzeceIme(String ime) { this.preduzeceIme = ime; }

}
