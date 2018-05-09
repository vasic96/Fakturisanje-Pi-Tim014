package tim014.pi.fakturisanje.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Faktura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "broj_fakture", nullable = false)
    private int brojFakture;

    @Column(name = "datum_fakture", nullable = false)
    private Date datumFakture;

    @Column(name = "datum_valute", nullable = false)
    private Date datumValute;

    @Column(nullable = false)
    private double osnovica;

    @Column(name = "ukupan_pdv", nullable = false)
    private double ukupanPDV;

    @Column(name = "iznos_za_placanje", nullable = false)
    private double iznosZaPlacanje;

    @Column(nullable = false)
    private char[] status = new char[2];

    @OneToMany
    private List<StavkaFakture> stavkeFakture;

    @ManyToOne
    @JoinColumn(name = "preduzece")
    private Preduzece preduzece;

    @ManyToOne
    @JoinColumn(name = "poslovni_partner")
    private PoslovniPartner poslovniPartner;

    @ManyToOne
    @JoinColumn(name = "poslovna_godina")
    private PoslovnaGodina poslovnaGodina;

    public Faktura(int brojFakture, Date datumFakture, Date datumValute, double osnovica, double ukupanPDV, double iznosZaPlacanje,
                   char[] status, List<StavkaFakture> stavkeFakture, Preduzece preduzece,
                   PoslovniPartner poslovniPartner, PoslovnaGodina poslovnaGodina) {
        this.brojFakture = brojFakture;
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

    public int getBrojFakture() {
        return brojFakture;
    }

    public void setBrojFakture(int brojFakture) {
        this.brojFakture = brojFakture;
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

    public char[] getStatus() {
        return status;
    }

    public void setStatus(char[] status) {
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
