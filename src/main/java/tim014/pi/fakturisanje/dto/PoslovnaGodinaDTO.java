package tim014.pi.fakturisanje.dto;

import org.springframework.web.bind.annotation.RestController;
import tim014.pi.fakturisanje.model.Faktura;
import tim014.pi.fakturisanje.model.PoslovnaGodina;

import java.util.List;

@RestController
public class PoslovnaGodinaDTO {

    private long id;
    private int godina;
    private boolean zakljucena;

    public PoslovnaGodinaDTO() {
    }

    public PoslovnaGodinaDTO(PoslovnaGodina pGodina) {
        this.id = pGodina.getId();
        this.godina = pGodina.getGodina();
        this.zakljucena = pGodina.isZakljucena();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public boolean isZakljucena() {
        return zakljucena;
    }
    public void setZakljucena(boolean zakljucena) {
        this.zakljucena = zakljucena;
    }

    public int getGodina() { return godina; }
    public void setGodina(int godina) {
        this.godina = godina;
    }
}
