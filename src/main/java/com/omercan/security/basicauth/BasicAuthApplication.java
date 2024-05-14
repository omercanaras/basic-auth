package com.omercan.security.basicauth;


import com.omercan.security.basicauth.dto.CreateUserRequest;
import com.omercan.security.basicauth.model.Role;
import com.omercan.security.basicauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

	private final UserService userService;

	public BasicAuthApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createDummyData();
	}

	private void createDummyData() {
		CreateUserRequest request = CreateUserRequest.builder()
				.name("aras")
				.username("aras")
				.password("password")
				.authorities(Set.of(Role.ROLE_USER))
				.build();
		userService.createUser(request);

		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("aras")
				.username("canaras")
				.password("password")
				.authorities(Set.of(Role.ROLE_ARAS))
				.build();
		userService.createUser(request2);


		CreateUserRequest request3 = CreateUserRequest.builder()
				.name("Admin")
				.username("admin")
				.password("admin")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();
		userService.createUser(request3);
	}
}