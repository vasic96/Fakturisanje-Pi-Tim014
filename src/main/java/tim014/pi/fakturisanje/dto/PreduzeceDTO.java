package tim014.pi.fakturisanje.dto;

import tim014.pi.fakturisanje.model.Preduzece;

import java.io.Serializable;

public class PreduzeceDTO implements Serializable {

    private long id;
    private String naziv;
    private String adresa;
    private int pib;
    private String telefon;
    private String email;
    private String password;
    private String logo;
    private String tip;
    private long mestoId;
    private String gradDrzava;

    public PreduzeceDTO() {

    }

    public PreduzeceDTO(Preduzece preduzece) {

        this.id = preduzece.getId();
        this.naziv = preduzece.getNaziv();
        this.adresa = preduzece.getAdresa();
        this.pib = preduzece.getPib();
        this.telefon = preduzece.getTelefon();
        this.email = preduzece.getEmail();
        this.password = preduzece.getPassword();
        this.logo = preduzece.getLogo();
        this.tip = preduzece.getTip();
        this.mestoId = preduzece.getMesto().getId();
        this.gradDrzava = preduzece.getMesto().getGrad() + ", " + preduzece.getMesto().getDrzava();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getMestoId() {
        return mestoId;
    }

    public void setMestoId(long mestoId) {
        this.mestoId = mestoId;
    }

    public String getGradDrzava() {
        return gradDrzava;
    }

    public void setGradDrzava(String gradDrzava) {
        this.gradDrzava = gradDrzava;
    }
}
