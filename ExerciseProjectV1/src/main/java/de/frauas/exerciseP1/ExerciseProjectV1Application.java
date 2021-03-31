package de.frauas.exerciseP1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "de.frauas.exerciseP1.repository")
@SpringBootApplication
public class ExerciseProjectV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseProjectV1Application.class, args);
	}

}
