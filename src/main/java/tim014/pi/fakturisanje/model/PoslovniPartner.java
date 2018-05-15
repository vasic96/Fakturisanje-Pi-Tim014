package tim014.pi.fakturisanje.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "poslovni_partner")
public class PoslovniPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 150)
    private String naziv;

    @Column(nullable = false)
    private String adresa;

    @Column(nullable = false)
    private char[] vrsta = new char[2];

    @JsonIgnore
    @OneToMany
    private List<Faktura> fakture;

    @ManyToOne
    @JoinColumn(name = "mesto")
    private Mesto mesto;

    @ManyToOne
    @JoinColumn(name = "preduzece")
    private Preduzece preduzece;


    public PoslovniPartner(String naziv, String adresa, char[] vrsta, List<Faktura> fakture, Mesto mesto, Preduzece preduzece) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.vrsta = vrsta;
        this.fakture = fakture;
        this.mesto = mesto;
        this.preduzece = preduzece;
    }

    public PoslovniPartner() {
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public char[] getVrsta() {
        return vrsta;
    }

    public void setVrsta(char[] vrsta) {
        this.vrsta = vrsta;
    }

    public List<Faktura> getFakture() {
        return fakture;
    }

    public void setFakture(List<Faktura> fakture) {
        this.fakture = fakture;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public Preduzece getPreduzece() {
        return preduzece;
    }

    public void setPreduzece(Preduzece preduzece) {
        this.preduzece = preduzece;
    }
}
