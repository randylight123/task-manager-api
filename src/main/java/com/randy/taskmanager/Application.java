package com.randy.taskmanager;

import com.randy.taskmanager.entity.User;
import com.randy.taskmanager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner test(UserRepository userRepository) {
		return args -> {
			User user = User.builder()
					.username("randy")
					.email("randy@test.com")
					.password("123456")
					.build();

			userRepository.save(user);

			System.out.println("User saved!");
		};
	}
}