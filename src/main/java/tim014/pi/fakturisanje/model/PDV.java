package tim014.pi.fakturisanje.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "pdv")
public class PDV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 40)
    private String naziv;

    @JsonIgnore
    @OneToMany
    private List<StopaPDV> stopePDV;

    @JsonIgnore
    @OneToMany
    private List<GrupaRobe> grupeRobe;


    public PDV(String naziv, List<StopaPDV> stopePDV, List<GrupaRobe> grupeRobe) {
        this.naziv = naziv;
        this.stopePDV = stopePDV;
        this.grupeRobe = grupeRobe;
    }

    public PDV() {
    }

    public PDV(String naziv) {

        this.naziv = naziv;
        this.grupeRobe = new ArrayList<>();
        this.stopePDV = new ArrayList<>();
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

    public List<StopaPDV> getStopePDV() {
        return stopePDV;
    }

    public void setStopePDV(List<StopaPDV> stopePDV) {
        this.stopePDV = stopePDV;
    }

    public List<GrupaRobe> getGrupeRobe() {
        return grupeRobe;
    }

    public void setGrupeRobe(List<GrupaRobe> grupeRobe) {
        this.grupeRobe = grupeRobe;
    }
}
