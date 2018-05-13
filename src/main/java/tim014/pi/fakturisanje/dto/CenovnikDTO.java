package tim014.pi.fakturisanje.dto;

import org.springframework.web.bind.annotation.RestController;
import tim014.pi.fakturisanje.model.Cenovnik;

import java.util.Date;

@RestController
public class CenovnikDTO {

    private Long id;
    private Date datumVazenja;
    private Long preduzeceId;

    public CenovnikDTO(){}

    public CenovnikDTO(Cenovnik cenovnik) {
        this.id = cenovnik.getId();
        this.datumVazenja = cenovnik.getDatumVazenja();
        this.preduzeceId = cenovnik.getPreduzece().getId();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Date getDatumVazenja() { return datumVazenja; }
    public void setDatumVazenja(Date date) { this.datumVazenja = date; }

    public Long getPreduzeceId() { return preduzeceId; }
    public void setPreduzeceId(Long id) { this.preduzeceId = id; }

}
