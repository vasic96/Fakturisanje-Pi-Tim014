package tim014.pi.fakturisanje.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "jedinica_mere")
public class JedinicaMere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true, length = 2)
    private String naziv;

    @JsonIgnore
    @OneToMany
    private List<Roba> roba;

    public JedinicaMere(String naziv, List<Roba> roba) {
        this.naziv = naziv;
        this.roba = roba;
    }

    public JedinicaMere() {
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

    public List<Roba> getRoba() {
        return roba;
    }

    public void setRoba(List<Roba> roba) {
        this.roba = roba;
    }
}
