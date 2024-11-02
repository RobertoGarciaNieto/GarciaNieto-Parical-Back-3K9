package com.example.Parcial1Back;

import com.example.Parcial1Back.controllers.DnaController;
import com.example.Parcial1Back.services.DnaService;
import com.example.Parcial1Back.repositories.DnaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Parcial1BackApplicationTests {

	@Autowired
	private DnaController dnaController;

	@Autowired
	private DnaService dnaService;

	@Autowired
	private DnaRepository dnaRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testContextLoads() {
		// Esta prueba verifica que el contexto de Spring Boot se carga correctamente
	}

	@Test
	void testDnaControllerIsNotNull() {
		assertThat(dnaController).isNotNull();
	}

	@Test
	void testDnaServiceIsNotNull() {
		assertThat(dnaService).isNotNull();
	}

	@Test
	void testDnaRepositoryIsNotNull() {
		assertThat(dnaRepository).isNotNull();
	}
}