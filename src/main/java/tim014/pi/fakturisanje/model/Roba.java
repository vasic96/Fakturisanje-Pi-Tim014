package tim014.pi.fakturisanje.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Roba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @JsonIgnore
    @OneToMany
    private List<StavkaCenovnika> stavkeCenovnika;

    @JsonIgnore
    @OneToMany
    private List<StavkaFakture> stavkeFakture;

    @ManyToOne
    @JoinColumn(name = "jedinica_mere")
    private JedinicaMere jedinicaMere;

    @ManyToOne
    @JoinColumn(name = "grupa_robe")
    private GrupaRobe grupaRobe;

    public Roba(String naziv, List<StavkaCenovnika> stavkeCenovnika, List<StavkaFakture> stavkeFakture, JedinicaMere jedinicaMere, GrupaRobe grupaRobe) {
        this.naziv = naziv;
        this.stavkeCenovnika = stavkeCenovnika;
        this.stavkeFakture = stavkeFakture;
        this.jedinicaMere = jedinicaMere;
        this.grupaRobe = grupaRobe;
    }

    public Roba() {
    }

    public Long getId() { return id; }

    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<StavkaCenovnika> getStavkeCenovnika() {
        return stavkeCenovnika;
    }
    public void setStavkeCenovnika(List<StavkaCenovnika> stavkeCenovnika) {
        this.stavkeCenovnika = stavkeCenovnika;
    }

    public List<StavkaFakture> getStavkeFakture() {
        return stavkeFakture;
    }
    public void setStavkeFakture(List<StavkaFakture> stavkeFakture) {
        this.stavkeFakture = stavkeFakture;
    }

    public JedinicaMere getJedinicaMere() {
        return jedinicaMere;
    }
    public void setJedinicaMere(JedinicaMere jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    public GrupaRobe getGrupaRobe() {
        return grupaRobe;
    }
    public void setGrupaRobe(GrupaRobe grupaRobe) {
        this.grupaRobe = grupaRobe;
    }
}
