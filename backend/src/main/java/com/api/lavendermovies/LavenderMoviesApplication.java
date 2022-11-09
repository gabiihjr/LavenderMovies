package com.api.lavendermovies;

import com.api.lavendermovies.domain.models.Role;
import com.api.lavendermovies.enums.RoleName;
import com.api.lavendermovies.repository.RoleRepository;
import com.api.lavendermovies.service.interfaces.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LavenderMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LavenderMoviesApplication.class, args);
	}

	@Bean
	CommandLineRunner run(IUserService userService, RoleRepository roleRepository) {
		return args -> {
			boolean adminExists = roleRepository.findByRoleName(RoleName.ADMIN).isPresent();
			boolean userExists = roleRepository.findByRoleName(RoleName.USER).isPresent();
			if (!adminExists || !userExists) {
				userService.saveRole(new Role(null, RoleName.USER));
				userService.saveRole(new Role(null, RoleName.ADMIN));
			}
		};
	}

}
