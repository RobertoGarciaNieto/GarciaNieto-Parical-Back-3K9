package com.example.Parcial1Back.Repository;

import com.example.Parcial1Back.entities.Dna;
import com.example.Parcial1Back.repositories.DnaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class DnaRepositoryTest {

    @Autowired
    private DnaRepository dnaRepository;

    @Test
    public void testFindByDna() {
        Dna dna = new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true);
        dnaRepository.save(dna);
        Dna foundDna = dnaRepository.findByDna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG").orElse(null);
        assertEquals(dna.getDna(), foundDna.getDna());
    }

    @Test
    public void testCountByIsMutant() {
        Dna dna1 = new Dna("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG", true);
        Dna dna2 = new Dna("ATGCGA,CAGTGC,TTATTT,AGACGG,GCGTCA,TCACTG", false);
        dnaRepository.save(dna1);
        dnaRepository.save(dna2);
        long countMutant = dnaRepository.countByIsMutant(true);
        long countHuman = dnaRepository.countByIsMutant(false);
        assertEquals(1, countMutant);
        assertEquals(1, countHuman);
    }
}