package tim014.pi.fakturisanje.dto;

import org.springframework.web.bind.annotation.RestController;
import tim014.pi.fakturisanje.model.StavkaCenovnika;

@RestController
public class StavkaCenovnikaDTO {

    private Long id;
    private double cena;
    private Long robaId;
    private Long cenovnikId;

    public StavkaCenovnikaDTO(){}

    public StavkaCenovnikaDTO(StavkaCenovnika stavkaCenovnika) {
        this.id = stavkaCenovnika.getId();
        this.cena = stavkaCenovnika.getCena();
        this.robaId = stavkaCenovnika.getRoba().getId();
        this.cenovnikId = stavkaCenovnika.getCenovnik().getId();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getCena() { return cena; }
    public void setCena(double cena) { this.cena = cena; }

    public Long getRobaId() { return robaId; }
    public void setRobaId(Long robaId) { this.robaId = robaId; }

    public Long getCenovnikId() { return cenovnikId; }
    public void setCenovnikId(Long cenovnikId) { this.cenovnikId = cenovnikId; }
}
