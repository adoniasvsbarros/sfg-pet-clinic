package com.adoniasbarros.sfgpetclinic.controllers;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.adoniasbarros.sfgpetclinic.model.Owner;
import com.adoniasbarros.sfgpetclinic.model.Pet;
import com.adoniasbarros.sfgpetclinic.services.OwnerService;
import com.adoniasbarros.sfgpetclinic.services.PetService;
import com.adoniasbarros.sfgpetclinic.services.VisitService;

@ExtendWith(MockitoExtension.class)
public class VisitControllerTest {

	
	@Mock
	VisitService visitService;
	
	@Mock
	PetService petService;

	@InjectMocks
	VisitController controller;

	MockMvc mockMvc;
	Pet pet;
	Owner owner;

	@BeforeEach
	void setUp() {
		pet = Pet.builder().id(1L).build();
		owner = Owner.builder().id(1L).build();
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void initNewVisitForm() throws Exception {
		when(petService.findById(anyLong())).thenReturn(pet);
		
		mockMvc.perform(get("/owners/1/pets/1/visits/new"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("visit"))
			.andExpect(view().name("pets/createOrUpdateVisitForm"));
	}
	
	@Test
	void processNewVisitForm() throws Exception {
		when(petService.findById(anyLong())).thenReturn(pet);
		
		mockMvc.perform(post("/owners/1/pets/1/visits/new"))
			.andExpect(status().is3xxRedirection())
			.andExpect(model().attributeExists("visit"))
			.andExpect(view().name("redirect:/owners/{ownerId}"));
		
		verify(visitService).save(any());
	}
}
