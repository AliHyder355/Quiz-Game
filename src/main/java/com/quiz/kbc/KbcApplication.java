package com.quiz.kbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@CrossOrigin(origins = "*")
@SpringBootApplication
public class KbcApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(KbcApplication.class, args);

	}


}
