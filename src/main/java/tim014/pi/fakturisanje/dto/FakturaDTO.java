package tim014.pi.fakturisanje.dto;

import tim014.pi.fakturisanje.model.Faktura;

import java.util.Date;

public class FakturaDTO {

    private long id;
    private Date datumFakture;
    private Date datumValute;
    private double osnovica;
    private double ukupanPDV;
    private double iznosZaPlacanje;
    private String status;
    private long preduzeceId;
    private long poslovniPartnerId;
    private long poslovnaGodinaId;

    public FakturaDTO() {
    }

    public FakturaDTO(Faktura faktura) {
        this.id = faktura.getId();
        this.datumFakture = faktura.getDatumFakture();
        this.datumValute = faktura.getDatumValute();
        this.osnovica = faktura.getOsnovica();
        this.ukupanPDV = faktura.getUkupanPDV();
        this.iznosZaPlacanje = faktura.getIznosZaPlacanje();
        this.status = faktura.getStatus();
        this.preduzeceId = faktura.getPreduzece().getId();
        this.poslovnaGodinaId = faktura.getPoslovnaGodina().getId();
        this.poslovniPartnerId = faktura.getPoslovniPartner().getId();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getPreduzeceId() {
        return preduzeceId;
    }

    public void setPreduzeceId(long preduzeceId) {
        this.preduzeceId = preduzeceId;
    }

    public long getPoslovniPartnerId() {
        return poslovniPartnerId;
    }

    public void setPoslovniPartnerId(long poslovniPartnerId) {
        this.poslovniPartnerId = poslovniPartnerId;
    }

    public long getPoslovnaGodinaId() {
        return poslovnaGodinaId;
    }

    public void setPoslovnaGodinaId(long poslovnaGodinaId) {
        this.poslovnaGodinaId = poslovnaGodinaId;
    }
}
