package tim014.pi.fakturisanje.dto;

import tim014.pi.fakturisanje.model.PoslovniPartner;

public class PoslovniPartnerDTO {

    private Long id;
    private String naziv;
    private String adresa;
    private String vrsta;
    private Long mestoId;
    private Long preduzeceId;

    public PoslovniPartnerDTO() {}

    public PoslovniPartnerDTO(String naziv, String adresa, String vrsta, Long mestoId, Long preduzeceId) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.vrsta = vrsta;
        this.mestoId = mestoId;
        this.preduzeceId = preduzeceId;
    }

    public PoslovniPartnerDTO(PoslovniPartner partner){

        this.id = partner.getId();
        this.naziv = partner.getNaziv();
        this.adresa = partner.getAdresa();
        this.vrsta = partner.getVrsta();
        this.mestoId = partner.getMesto().getId();
        this.preduzeceId = partner.getPreduzece().getId();
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

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public Long getMestoId() {
        return mestoId;
    }

    public void setMestoId(Long mestoId) {
        this.mestoId = mestoId;
    }

    public Long getPreduzeceId() {
        return preduzeceId;
    }

    public void setPreduzeceId(Long preduzeceId) {
        this.preduzeceId = preduzeceId;
    }
}




