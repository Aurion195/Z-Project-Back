package com.thmathieu.zproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ZProjectBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZProjectBackApplication.class, args);
	}

}
