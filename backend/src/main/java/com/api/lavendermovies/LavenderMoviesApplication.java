package com.api.lavendermovies;

import com.api.lavendermovies.domain.models.Role;
import com.api.lavendermovies.domain.models.User;
import com.api.lavendermovies.enums.RoleName;
import com.api.lavendermovies.service.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class LavenderMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LavenderMoviesApplication.class, args);
	}

	@Bean
	CommandLineRunner run(IUserService userService) {
		return args -> {
			userService.saveRole(new Role(null, RoleName.USER));
			userService.saveRole(new Role(null, RoleName.ADMIN));

			userService.saveUser(new User(null, "aaaa", "aaaa", "aaaa", "aaaa", new ArrayList<>()));
			userService.addRoleToUser("aaaa", RoleName.ADMIN);
		};
	}

}
