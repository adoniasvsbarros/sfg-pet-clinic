package com.adoniasbarros.jokesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@SpringBootApplication
@ImportResource("classpath:chuck-config.xml")
public class JokesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JokesAppApplication.class, args);
	}

}
