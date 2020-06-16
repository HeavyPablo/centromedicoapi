package com.dosalamos.centromedicoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.dosalamos.centromedicoapi")
public class CentromedicoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentromedicoapiApplication.class, args);
	}
}
