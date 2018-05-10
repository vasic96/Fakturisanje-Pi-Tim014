package tim014.pi.fakturisanje.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "poslovna_godina")
public class PoslovnaGodina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int godina;

    @Column
    private boolean zakljucena;

    @JsonIgnore
    @OneToMany
    private List<Faktura> fakture;

    public PoslovnaGodina(int godina, boolean zakljucena, List<Faktura> fakture) {
        this.godina = godina;
        this.zakljucena = zakljucena;
        this.fakture = fakture;
    }

    public PoslovnaGodina() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public boolean isZakljucena() {
        return zakljucena;
    }

    public void setZakljucena(boolean zakljucena) {
        this.zakljucena = zakljucena;
    }

    public List<Faktura> getFakture() {
        return fakture;
    }

    public void setFakture(List<Faktura> fakture) {
        this.fakture = fakture;
    }
}
