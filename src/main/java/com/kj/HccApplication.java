package com.kj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class HccApplication {

	public static void main(String[] args) {
		SpringApplication.run(HccApplication.class, args);
	}
}
