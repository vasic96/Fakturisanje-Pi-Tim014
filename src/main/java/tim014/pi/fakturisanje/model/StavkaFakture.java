package tim014.pi.fakturisanje.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity(name = "stavka_fakture")
public class StavkaFakture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int kolicina;

    @Column(name = "jedinicna_cena", nullable = false)
    private double jedinicnaCena;

    @Min(1)
    @Max(100)
    @Column(nullable = false)
    private double rabat;

    @Column(name = "osnovica_pdv", nullable = false)
    private double osnovicaPDV;

    @Min(1)
    @Max(100)
    @Column(name = "procenat_pdv", nullable = false)
    private double procenatPDV;

    @Column(name = "iznos_pdv", nullable = false)
    private double iznosPDV;

    @Column(name = "iznos_stavke", nullable = false)
    private double iznosStavke;

    @ManyToOne
    @JoinColumn(name = "roba")
    private Roba roba;

    @ManyToOne
    @JoinColumn(name = "faktura")
    private Faktura faktura;


    public StavkaFakture(int kolicina, double jedinicnaCena, double rabat, double osnovicaPDV, double procenatPDV, double iznosPDV, double iznosStavka, Roba roba, Faktura faktura) {
        this.kolicina = kolicina;
        this.jedinicnaCena = jedinicnaCena;
        this.rabat = rabat;
        this.osnovicaPDV = osnovicaPDV;
        this.procenatPDV = procenatPDV;
        this.iznosPDV = iznosPDV;
        this.iznosStavke = iznosStavka;
        this.roba = roba;
        this.faktura = faktura;
    }

    public StavkaFakture() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getJedinicnaCena() {
        return jedinicnaCena;
    }

    public void setJedinicnaCena(double jedinicnaCena) {
        this.jedinicnaCena = jedinicnaCena;
    }

    public double getRabat() {
        return rabat;
    }

    public void setRabat(double rabat) {
        this.rabat = rabat;
    }

    public double getOsnovicaPDV() {
        return osnovicaPDV;
    }

    public void setOsnovicaPDV(double osnovicaPDV) {
        this.osnovicaPDV = osnovicaPDV;
    }

    public double getProcenatPDV() {
        return procenatPDV;
    }

    public void setProcenatPDV(double procenatPDV) {
        this.procenatPDV = procenatPDV;
    }

    public double getIznosPDV() {
        return iznosPDV;
    }

    public void setIznosPDV(double iznosPDV) {
        this.iznosPDV = iznosPDV;
    }

    public double getIznosStavka() {
        return iznosStavke;
    }

    public void setIznosStavka(double iznosStavka) {
        this.iznosStavke = iznosStavka;
    }

    public Roba getRoba() {
        return roba;
    }

    public void setRoba(Roba roba) {
        this.roba = roba;
    }

    public Faktura getFaktura() {
        return faktura;
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }
}
