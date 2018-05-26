package tim014.pi.fakturisanje.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Preduzece {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @Column(nullable = false)
    private String adresa;

    @Size(max = 9,min = 9)
    @Column(nullable = false)
    private int pib;

    @Column
    private String telefon;

    @Column(unique = true,nullable = false)
    private String email;

    @JsonIgnore
    @Column
    private String password;

    @Column
    private String logo;

    @Column(nullable = false)
    private String tip;

    @JsonIgnore
    @OneToMany
    private List<GrupaRobe> grupeRobe;

    @JsonIgnore
    @OneToMany
    private List<Faktura> fakture;

    @JsonIgnore
    @OneToMany
    private List<Cenovnik> cenovnici;

    @ManyToOne
    @JoinColumn(name = "mesto",nullable = false)
    private Mesto mesto;

    public Preduzece() {
    }

    public Preduzece(String naziv, String adresa, int pib, String telefon, String email, String password, String logo, String tip, List<GrupaRobe> grupeRobe, List<Faktura> fakture, List<Cenovnik> cenovnici, Mesto mesto) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.pib = pib;
        this.telefon = telefon;
        this.email = email;
        this.password = password;
        this.logo = logo;
        this.tip = tip;
        this.grupeRobe = grupeRobe;
        this.fakture = fakture;
        this.cenovnici = cenovnici;
        this.mesto = mesto;
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

    public int getPib() {
        return pib;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public List<GrupaRobe> getGrupeRobe() {
        return grupeRobe;
    }

    public void setGrupeRobe(List<GrupaRobe> grupeRobe) {
        this.grupeRobe = grupeRobe;
    }

    public List<Faktura> getFakture() {
        return fakture;
    }

    public void setFakture(List<Faktura> fakture) {
        this.fakture = fakture;
    }

    public List<Cenovnik> getCenovnici() {
        return cenovnici;
    }

    public void setCenovnici(List<Cenovnik> cenovnici) {
        this.cenovnici = cenovnici;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }
}
