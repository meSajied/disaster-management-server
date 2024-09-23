package org.disastermanagement.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.disastermanagement.users", 
		"org.disastermanagement.cost"})
@EntityScan(basePackages = {"org.disastermanagement.users", 
		"org.disastermanagement.cost"})
@EnableJpaRepositories(basePackages = {"org.disastermanagement.users", 
		"org.disastermanagement.cost"})
public class DisasterManagementServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(DisasterManagementServerApplication.class, args);
	}

}
