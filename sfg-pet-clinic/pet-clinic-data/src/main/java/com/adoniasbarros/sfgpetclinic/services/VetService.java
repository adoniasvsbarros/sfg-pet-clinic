package com.adoniasbarros.sfgpetclinic.services;

import java.util.Set;

import com.adoniasbarros.sfgpetclinic.model.Vet;

public interface VetService {
	
	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
}
