package com.springboot.jpacrud;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemolearningsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemolearningsApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner ->{
			System.out.println("using command line runner");
		};
	}

}
