package be.vdab.artikels.domain;

import javax.persistence.*;

@Entity
@Table(name = "artikelgroepen")
public class Artikelgroep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;

    protected Artikelgroep() {
    }

    public Artikelgroep(String naam) {
        this.naam = naam;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
