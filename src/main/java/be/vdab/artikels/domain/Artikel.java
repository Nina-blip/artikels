package be.vdab.artikels.domain;

import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "artikels")
public class Artikel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    private BigDecimal prijs;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "artikelgroepid")
    private Artikelgroep artikelgroep;

    protected Artikel() {
    }

    public Artikel(String naam, BigDecimal prijs, Artikelgroep artikelgroep) {
        this.naam = naam;
        this.prijs = prijs;
        setArtikelgroep(artikelgroep);
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public Artikelgroep getArtikelgroep() {
        return artikelgroep;
    }

    public void setArtikelgroep(Artikelgroep artikelgroep) {
        this.artikelgroep = artikelgroep;
    }
}
