package com.example.football_field_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FootballFieldManagementApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FootballFieldManagementApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FootballFieldManagementApplication.class);
	}
}
