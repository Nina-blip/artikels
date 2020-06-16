package be.vdab.artikels.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql("/insertArtikelgroepen.sql")
@Sql("/insertArtikels.sql")
class ArtikelRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    private static final String ARTIKELS = "artikels";

    private final ArtikelRepository repository;

    public ArtikelRepositoryTest(ArtikelRepository repository) {
        this.repository = repository;
    }

    @Test
    void findByPrijsBetween() {
        var artikels = repository.findByPrijsBetween(BigDecimal.ONE, BigDecimal.valueOf(2));
        assertThat(artikels).hasSize(2).allSatisfy(artikel ->
            assertThat(artikel.getPrijs()).isGreaterThanOrEqualTo(BigDecimal.ONE).isLessThanOrEqualTo(BigDecimal.valueOf(2))
        );
    }

    @Test
    void findMetHoogstePrijs(){
        assertThat(repository.findMetHoogstePrijs()).isEqualByComparingTo("1.68");
    }

    @Test
    void findByArtikelgroepNaam(){
        assertThat(repository.findByArtikelgroepNaam("Fruit")).hasSize(2).allSatisfy(artikel ->
                assertThat(artikel.getArtikelgroep().getNaam()).isEqualTo("Fruit"));
    }
}