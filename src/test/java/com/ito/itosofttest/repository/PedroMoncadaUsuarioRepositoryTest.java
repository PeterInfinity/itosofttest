package com.ito.itosofttest.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ito.itosofttest.model.PedroMoncadaUsuario;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
class PedroMoncadaUsuarioRepositoryTest {

	@Autowired
	private PedroMoncadaUsuarioRepository userRepository;

	@BeforeAll
	static void initAll() {
		System.out.println("---initAll---");
	}

	@BeforeEach
	void init(TestInfo testInfo) {
		System.out.println("Start..." + testInfo.getDisplayName());
	}

	@Test
	void findByUsername() {
		System.out.println("prueba unitaria findByUsuario");
		Optional<PedroMoncadaUsuario> optionalUser = userRepository.findByUsuario("moncada");
		assertTrue(optionalUser.isPresent());

		PedroMoncadaUsuario user = optionalUser.get();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(user);
		System.out.println("user find it ::::: " + json);

	}

	@AfterEach
	void tearDown(TestInfo testInfo) {
		System.out.println("Finished..." + testInfo.getDisplayName());
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("---tearDownAll---");
	}
}
