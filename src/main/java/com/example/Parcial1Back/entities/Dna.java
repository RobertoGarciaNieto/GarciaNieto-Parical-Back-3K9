package com.example.Parcial1Back.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Dna extends Base implements Serializable {

    @Column(unique = true)
    private String dna;

    private boolean isMutant;
}
