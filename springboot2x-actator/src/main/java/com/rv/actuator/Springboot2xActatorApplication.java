package com.rv.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.rv")
public class Springboot2xActatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2xActatorApplication.class, args);
	}

}
