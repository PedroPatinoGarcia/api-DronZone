package com.pee.dockerized.postgresql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pee.dockerized.postgresql.Model.Rol;
import com.pee.dockerized.postgresql.Model.Usuario;
import com.pee.dockerized.postgresql.Services.UsuarioService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	CommandLineRunner initData(UsuarioService usuarioService) {
		return args -> {
			usuarioService.add(new Usuario("admin", "dron123", Rol.ADMIN));
		};
	}

}