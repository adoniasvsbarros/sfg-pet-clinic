package com.adoniasbarros.jokesapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

//@Configuration
public class ChuckConfiguration {
	
	//@Bean
	public ChuckNorrisQuotes chuckNorrisQuotes() {
		return new ChuckNorrisQuotes();
	}
}
