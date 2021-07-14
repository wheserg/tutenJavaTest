package com.tuten.rest.tuten;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses=TimeController.class)
public class TutenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutenApplication.class, args);
	}

}
