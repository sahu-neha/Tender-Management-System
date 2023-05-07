package com.masai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.masai")
public class TenderManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TenderManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("+===========================================+");
		System.out.println("|   Application started successfully.....   |");
		System.out.println("+===========================================+");
	}

}
