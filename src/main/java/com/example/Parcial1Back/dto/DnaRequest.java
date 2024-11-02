package com.example.Parcial1Back.dto;

import lombok.Getter;
import lombok.Setter;
import com.example.Parcial1Back.validators.ValidDna;

@Getter
@Setter
public class DnaRequest {
    @ValidDna
    private String[] dna;
}
