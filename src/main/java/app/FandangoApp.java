package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "app.repository")
@SpringBootApplication
public class FandangoApp {

	public static void main(String[] args) {
		SpringApplication.run(FandangoApp.class, args);
	}
}