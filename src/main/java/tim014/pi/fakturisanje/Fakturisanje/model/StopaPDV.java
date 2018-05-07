package tim014.pi.fakturisanje.Fakturisanje.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "stopa_pdv")
public class StopaPDV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double procenat;

    @Column(name = "datum_vazenja", nullable = false)
    private Date datumVazenja;

    @ManyToOne
    @JoinColumn(name = "pdv")
    private PDV pdv;


    public StopaPDV(double procenat, Date datumVazenja, PDV pdv) {
        this.procenat = procenat;
        this.datumVazenja = datumVazenja;
        this.pdv = pdv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getProcenat() {
        return procenat;
    }

    public void setProcenat(double procenat) {
        this.procenat = procenat;
    }

    public Date getDatumVazenja() {
        return datumVazenja;
    }

    public void setDatumVazenja(Date datumVazenja) {
        this.datumVazenja = datumVazenja;
    }

    public PDV getPdv() {
        return pdv;
    }

    public void setPdv(PDV pdv) {
        this.pdv = pdv;
    }
}
