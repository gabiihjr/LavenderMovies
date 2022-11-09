package com.api.lavendermovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LavenderMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LavenderMoviesApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(IUserService userService) {
//		return args -> {
//			userService.saveRole(new Role(null, RoleName.USER));
//			userService.saveRole(new Role(null, RoleName.ADMIN));
//
//			userService.saveUser(new User(null, "aaaa", "aaaa", "aaaa", "aaaa", new ArrayList<>()));
//			userService.addRoleToUser("aaaa", RoleName.ADMIN);
//		};
//	}

}
