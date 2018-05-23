package tim014.pi.fakturisanje.dto;

import tim014.pi.fakturisanje.model.StavkaFakture;

public class StavkaFaktureDTO {

    private long id;
    private int kolicina;
    private double jedinicnaCena;
    private double rabat;
    private double osnovicaPDV;
    private double procenatPDV;
    private double iznosPDV;
    private double iznosStavke;
    private long robaId;
    private String robaNaziv;
    private long fakturaId;


    public StavkaFaktureDTO(StavkaFakture stavkaFakture) {

        this.id = stavkaFakture.getId();
        this.kolicina = stavkaFakture.getKolicina();
        this.jedinicnaCena = stavkaFakture.getJedinicnaCena();
        this.rabat = stavkaFakture.getRabat();
        this.osnovicaPDV = stavkaFakture.getOsnovicaPDV();
        this.procenatPDV = stavkaFakture.getProcenatPDV();
        this.iznosPDV = stavkaFakture.getIznosPDV();
        this.iznosStavke = stavkaFakture.getIznosStavka();
        this.robaId = stavkaFakture.getRoba().getId();
        this.fakturaId = stavkaFakture.getFaktura().getId();
        this.robaNaziv = stavkaFakture.getRoba().getNaziv();

    }

    public StavkaFaktureDTO(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public double getIznosStavke() {
        return iznosStavke;
    }

    public void setIznosStavke(double iznosStavke) {
        this.iznosStavke = iznosStavke;
    }

    public long getRobaId() {
        return robaId;
    }

    public void setRobaId(long robaId) {
        this.robaId = robaId;
    }

    public long getFakturaId() {
        return fakturaId;
    }

    public void setFakturaId(long fakturaId) {
        this.fakturaId = fakturaId;
    }

    public String getRobaNaziv() {
        return robaNaziv;
    }

    public void setRobaNaziv(String robaNaziv) {
        this.robaNaziv = robaNaziv;
    }
}
