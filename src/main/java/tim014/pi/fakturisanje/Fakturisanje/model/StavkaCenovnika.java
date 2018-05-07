package tim014.pi.fakturisanje.Fakturisanje.model;

import javax.persistence.*;

@Entity(name = "stavka_cenovnika")
public class StavkaCenovnika {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double cena;

    @ManyToOne
    @JoinColumn(name = "roba")
    private Roba roba;

    @ManyToOne
    @JoinColumn(name = "cenovnik")
    private Cenovnik cenovnik;

    public StavkaCenovnika(double cena, Roba roba, Cenovnik cenovnik) {
        this.cena = cena;
        this.roba = roba;
        this.cenovnik = cenovnik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Roba getRoba() {
        return roba;
    }

    public void setRoba(Roba roba) {
        this.roba = roba;
    }

    public Cenovnik getCenovnik() {
        return cenovnik;
    }

    public void setCenovnik(Cenovnik cenovnik) {
        this.cenovnik = cenovnik;
    }
}
