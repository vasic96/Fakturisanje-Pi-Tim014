package tim014.pi.fakturisanje.Fakturisanje.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cenovnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "datum_vazenja")
    private Date datumVazenja;

    @OneToMany
    private List<StavkaCenovnika> stavke;

    @ManyToOne
    @JoinColumn(name = "preduzece")
    private Preduzece preduzece;

    public Cenovnik(Date datumVazenja, Preduzece preduzece) {
        this.datumVazenja = datumVazenja;
        this.preduzece = preduzece;
        this.stavke = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumVazenja() {
        return datumVazenja;
    }

    public void setDatumVazenja(Date datumVazenja) {
        this.datumVazenja = datumVazenja;
    }

    public List<StavkaCenovnika> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaCenovnika> stavke) {
        this.stavke = stavke;
    }

    public Preduzece getPreduzece() {
        return preduzece;
    }

    public void setPreduzece(Preduzece preduzece) {
        this.preduzece = preduzece;
    }
}
