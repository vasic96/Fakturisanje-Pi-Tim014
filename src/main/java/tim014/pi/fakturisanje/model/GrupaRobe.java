package tim014.pi.fakturisanje.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "grupa_robe")
public class GrupaRobe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 70)
    private String naziv;

    @JsonIgnore
    @OneToMany
    private List<Roba> roba;

    @ManyToOne
    @JoinColumn(name = "preduzece")
    private Preduzece preduzece;

    @ManyToOne
    @JoinColumn(name = "pdv")
    private PDV pdv;

    public GrupaRobe(String naziv, List<Roba> roba, Preduzece preduzece, PDV pdv) {
        this.naziv = naziv;
        this.roba = roba;
        this.preduzece = preduzece;
        this.pdv = pdv;
    }

    public GrupaRobe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Roba> getRoba() {
        return roba;
    }

    public void setRoba(List<Roba> roba) {
        this.roba = roba;
    }

    public Preduzece getPreduzece() {
        return preduzece;
    }

    public void setPreduzece(Preduzece preduzece) {
        this.preduzece = preduzece;
    }

    public PDV getPdv() {
        return pdv;
    }

    public void setPdv(PDV pdv) {
        this.pdv = pdv;
    }
}
