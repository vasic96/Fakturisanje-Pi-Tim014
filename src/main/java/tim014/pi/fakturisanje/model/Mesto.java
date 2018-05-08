package tim014.pi.fakturisanje.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String grad;

    @Column(nullable = false)
    private String drzava;

    @JsonIgnore
    @OneToMany
    private List<Preduzece> preduzeca;

    @JsonIgnore
    @OneToMany
    private List<PoslovniPartner> poslovniPartneri;

    public Mesto() {
    }


    public Mesto(String grad, String drzava, List<Preduzece> preduzeca, List<PoslovniPartner> poslovniPartneri) {
        this.grad = grad;
        this.drzava = drzava;
        this.preduzeca = preduzeca;
        this.poslovniPartneri = poslovniPartneri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public List<Preduzece> getPreduzeca() {
        return preduzeca;
    }

    public void setPreduzeca(List<Preduzece> preduzeca) {
        this.preduzeca = preduzeca;
    }

    public List<PoslovniPartner> getPoslovniPartneri() {
        return poslovniPartneri;
    }

    public void setPoslovniPartneri(List<PoslovniPartner> poslovniPartneri) {
        this.poslovniPartneri = poslovniPartneri;
    }
}

