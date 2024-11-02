package com.example.Parcial1Back.Service;

import com.example.Parcial1Back.services.DnaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DnaServiceTest {

    @Autowired
    private DnaService dnaService;

    @Test
    public void testIsMutant_True() {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        assertTrue(dnaService.isMutant(dna));
    }

    @Test
    public void testIsMutant_False() {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};
        assertFalse(dnaService.isMutant(dna));
    }
}