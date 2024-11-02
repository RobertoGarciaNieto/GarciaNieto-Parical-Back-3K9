package com.example.Parcial1Back.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DnaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCheckMutant_True() throws Exception {
        String json = "{\"dna\": [\"ATGCGA\", \"CAGTGC\", \"TTATGT\", \"AGAAGG\", \"CCCCTA\", \"TCACTG\"]}";
        mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testCheckMutant_False() throws Exception {
        String json = "{\"dna\": [\"ATGCGA\", \"CAGTGC\", \"TTATTT\", \"AGACGG\", \"GCGTCA\", \"TCACTG\"]}";
        mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isForbidden());
    }
}