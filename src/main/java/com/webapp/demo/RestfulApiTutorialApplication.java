package com.webapp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan({"com.webapp"})
@EntityScan("com.webapp.model")
@EnableJpaRepositories("com.webapp.repository")
@SpringBootApplication
public class RestfulApiTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApiTutorialApplication.class, args);
	}

}
