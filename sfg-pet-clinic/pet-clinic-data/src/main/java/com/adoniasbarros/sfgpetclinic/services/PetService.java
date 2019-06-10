package com.adoniasbarros.sfgpetclinic.services;

import java.util.Set;

import com.adoniasbarros.sfgpetclinic.model.Pet;

public interface PetService {
	
	Pet findById(Long id);
	
	Pet save(Pet owner);
	
	Set<Pet> findAll();
}
