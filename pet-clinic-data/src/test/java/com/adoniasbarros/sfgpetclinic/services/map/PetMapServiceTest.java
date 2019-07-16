package com.adoniasbarros.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adoniasbarros.sfgpetclinic.model.Pet;

public class PetMapServiceTest {

	PetMapService petMapService;
	
	final Long petId = 1L;
	
	@BeforeEach
	void setUp() {
		petMapService = new PetMapService();
		petMapService.save(Pet.builder().id(petId).build());
	}
	
	@Test
	void findAll() {
		Set<Pet> pets = petMapService.findAll();
		assertEquals(1, pets.size());
	}
	
	@Test
	void findById() {
		Pet pet = petMapService.findById(petId);
		assertEquals(petId, pet.getId());
	}
	
	@Test
	void save() {
		Long id = 2L;
		Pet savedPet = petMapService.save(Pet.builder().id(id).build());
		
		assertEquals(savedPet.getId(), petMapService.findById(id).getId());
		assertEquals(2, petMapService.findAll().size());
		
		
	}
	
	@Test
	void delete() {
		petMapService.delete(petMapService.findById(petId));
		assertEquals(0, petMapService.findAll().size());
	}
	
	@Test
	void deleteById() {
		petMapService.deleteById(petId);
		assertEquals(0, petMapService.findAll().size());
	}
	
}
