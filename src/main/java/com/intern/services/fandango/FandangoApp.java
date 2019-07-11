package com.intern.services.fandango;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.intern.services.fandango.repository")
@SpringBootApplication
public class FandangoApp {

	public static void main(String[] args) {
		SpringApplication.run(FandangoApp.class, args);
	}
}