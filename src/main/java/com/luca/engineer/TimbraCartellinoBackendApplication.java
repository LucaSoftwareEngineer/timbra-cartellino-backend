package com.luca.engineer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class TimbraCartellinoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimbraCartellinoBackendApplication.class, args);
	}

}
