package tim014.pi.fakturisanje.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Faktura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "datum_fakture", nullable = false,columnDefinition = "DATE")
    private Date datumFakture;


    @Column(name = "datum_valute", nullable = false,columnDefinition = "DATE")
    private Date datumValute;

    @Column(columnDefinition = "DOUBLE DEFAULT 0")
    private double osnovica;

    @Column(name = "ukupan_pdv",columnDefinition = "DOUBLE DEFAULT 0")
    private double ukupanPDV;

    @Column(name = "iznos_za_placanje",columnDefinition = "DOUBLE DEFAULT 0")
    private double iznosZaPlacanje;

    @Size(min = 2, max = 2)
    @Column(nullable = false)
    private String status;

    @JsonIgnore
    @OneToMany
    private List<StavkaFakture> stavkeFakture;

    @ManyToOne
    @JoinColumn(name = "preduzece",nullable = false)
    private Preduzece preduzece;

    @ManyToOne
    @JoinColumn(name = "poslovni_partner",nullable = false)
    private PoslovniPartner poslovniPartner;

    @ManyToOne
    @JoinColumn(name = "poslovna_godina",nullable = false)
    private PoslovnaGodina poslovnaGodina;

    public Faktura(Date datumFakture, Date datumValute, double osnovica, double ukupanPDV, double iznosZaPlacanje,
                   String status, List<StavkaFakture> stavkeFakture, Preduzece preduzece,
                   PoslovniPartner poslovniPartner, PoslovnaGodina poslovnaGodina) {
        this.datumFakture = datumFakture;
        this.datumValute = datumValute;
        this.osnovica = osnovica;
        this.ukupanPDV = ukupanPDV;
        this.iznosZaPlacanje = iznosZaPlacanje;
        this.status = status;
        this.stavkeFakture = stavkeFakture;
        this.preduzece = preduzece;
        this.poslovniPartner = poslovniPartner;
        this.poslovnaGodina = poslovnaGodina;
    }

    public Faktura() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumFakture() {
        return datumFakture;
    }

    public void setDatumFakture(Date datumFakture) {
        this.datumFakture = datumFakture;
    }

    public Date getDatumValute() {
        return datumValute;
    }

    public void setDatumValute(Date datumValute) {
        this.datumValute = datumValute;
    }

    public double getOsnovica() {
        return osnovica;
    }

    public void setOsnovica(double osnovica) {
        this.osnovica = osnovica;
    }

    public double getUkupanPDV() {
        return ukupanPDV;
    }

    public void setUkupanPDV(double ukupanPDV) {
        this.ukupanPDV = ukupanPDV;
    }

    public double getIznosZaPlacanje() {
        return iznosZaPlacanje;
    }

    public void setIznosZaPlacanje(double iznosZaPlacanje) {
        this.iznosZaPlacanje = iznosZaPlacanje;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<StavkaFakture> getStavkeFakture() {
        return stavkeFakture;
    }

    public void setStavkeFakture(List<StavkaFakture> stavkeFakture) {
        this.stavkeFakture = stavkeFakture;
    }

    public Preduzece getPreduzece() {
        return preduzece;
    }

    public void setPreduzece(Preduzece preduzece) {
        this.preduzece = preduzece;
    }

    public PoslovniPartner getPoslovniPartner() {
        return poslovniPartner;
    }

    public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
        this.poslovniPartner = poslovniPartner;
    }

    public PoslovnaGodina getPoslovnaGodina() {
        return poslovnaGodina;
    }

    public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
        this.poslovnaGodina = poslovnaGodina;
    }
}
