package com.example.Parcial1Back.services;

import com.example.Parcial1Back.entities.Dna;
import com.example.Parcial1Back.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.IntStream;

@Service
public class DnaService {

    private final DnaRepository dnaRepository;
    private static final int SEQUENCE_LENGTH = 4;

    @Autowired
    public DnaService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public boolean analyzeDna(String[] dna) {
        if (dna.length < 4) {
            return false;
        }

        //Combina filas de matriz armando una sola cadena, siendo separada por coma cada fila
        String dnaSequence = String.join(",", dna);

        //Revisa si en la BD ya está este ADN
        Optional<Dna> existingDna;

        try {
            existingDna = dnaRepository.findByDna(dnaSequence);
        } catch (Exception e) {
            // Manejo de la excepción, puedes logearla o lanzar una RuntimeException
            throw new RuntimeException("Error al buscar en la base de datos", e);
        }
        //Si ya está esta secuencia devuelve si es mutante o no
        if (existingDna.isPresent()) {
            return existingDna.get().isMutant();
        }

        // Llama a isMutant para determinar si el ADN es mutante o no y devuelve un booleano
        boolean isMutant = isMutant(dna);
        Dna dnaEntity = Dna.builder().dna(dnaSequence).isMutant(isMutant).build();
        //Guarda el resultado en la BD
        dnaRepository.save(dnaEntity);
        return isMutant;
    }

    public static boolean isMutant(String[] dna) {
        int n = dna.length;
        //El IntStream crea un flujo (stream) de enteros desde n hasta n-1
        //El anyMatch verifica si hay al menos un elemento que cumpla con la condición
        //Se anidan para ver filas y columnas
        return IntStream.range(0, n).anyMatch(i ->
                IntStream.range(0, n).anyMatch(j ->
                        checkSequence(dna, i, j, 0, 1, n) ||  // Horizontal
                        checkSequence(dna, i, j, 1, 0, n) ||  // Vertical
                        checkSequence(dna, i, j, 1, 1, n) ||  // Diagonal descendente
                        checkSequence(dna, i, j, 1, -1, n)    // Diagonal ascendente
                )
        );
    }

    // Este es el método que revisa si hay secuencias
    private static boolean checkSequence(String[] dna, int x, int y, int dx, int dy, int n) {
        // Se calcula la posición final de la secuencia
        int endX = x + (SEQUENCE_LENGTH - 1) * dx;
        int endY = y + (SEQUENCE_LENGTH - 1) * dy;

        // Verificamos que no se exceda el límite de la matriz
        if (endX >= n || endY >= n || endY < 0) {
            return false;
        }

        // Obtenemos el primer carácter
        char first = dna[x].charAt(y);

        // Usamos IntStream para recorrer los caracteres de la secuencia
        //El allMatch se usa para verificar si todos los caracteres cumplen la condición
        return IntStream.range(0, SEQUENCE_LENGTH).allMatch(i -> {
            int nx = x + i * dx; // Nueva posición en la dirección dx
            int ny = y + i * dy; // Nueva posición en la dirección dy
            // Verificamos si el carácter actual es igual al primero
            return dna[nx].charAt(ny) == first;
        });
    }
}
