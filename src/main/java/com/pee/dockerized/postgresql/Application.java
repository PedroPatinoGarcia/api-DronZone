package com.pee.dockerized.postgresql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pee.dockerized.postgresql.Model.Rol;
import com.pee.dockerized.postgresql.Model.Usuario;
import com.pee.dockerized.postgresql.Services.UsuarioService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*").allowedHeaders("*");
			}
		};
	}
	

	@Bean
	CommandLineRunner initData(UsuarioService usuarioService) {
		return args -> {
			usuarioService.add(new Usuario("admin", "dron123", Rol.ADMIN));
		};
	}

}