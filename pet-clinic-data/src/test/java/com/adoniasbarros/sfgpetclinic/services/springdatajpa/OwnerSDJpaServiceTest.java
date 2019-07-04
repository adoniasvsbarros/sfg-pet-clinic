package com.adoniasbarros.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.adoniasbarros.sfgpetclinic.model.Owner;
import com.adoniasbarros.sfgpetclinic.repositories.OwnerRepository;
import com.adoniasbarros.sfgpetclinic.repositories.PetRepository;
import com.adoniasbarros.sfgpetclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
public class OwnerSDJpaServiceTest {

	private static final String LAST_NAME = "Smith";

	@Mock
	OwnerRepository ownerRepository;

	@Mock
	PetRepository petRepository;

	@Mock
	PetTypeRepository petTypeRepository;

	@InjectMocks
	OwnerSDJpaService service;

	Owner returnOwner;

	@BeforeEach
	void setUp() {
		returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
	}

	@Test
	void findByLastName() {
		Mockito.when(ownerRepository.findByLastName(Mockito.any())).thenReturn(returnOwner);

		Owner smith = service.findByLastName(LAST_NAME);

		assertEquals(LAST_NAME, smith.getLastName());

		verify(ownerRepository).findByLastName(Mockito.any());
	}

	@Test
	void findAll() {
		Set<Owner> returnOwnerSet = new HashSet<Owner>();
		returnOwnerSet.add(Owner.builder().id(1L).build());
		returnOwnerSet.add(Owner.builder().id(2L).build());

		when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

		Set<Owner> owners = service.findAll();

		assertNotNull(owners);
		assertEquals(2, owners.size());

	}

	@Test
	void findById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

		Owner savedOwner = service.findById(1L);

		assertNotNull(savedOwner);

	}

	@Test
	void findByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

		Owner savedOwner = service.findById(1L);

		assertNull(savedOwner);

	}
	
	@Test
	void save() {
		Owner ownerToSave = Owner.builder().id(1L).build();
		
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		
		Owner savedOwner = service.save(ownerToSave);
		
		assertNotNull(savedOwner);
		
		verify(ownerRepository).save(any());
	}
	
	@Test
	void delete() {
		service.delete(returnOwner);
		
		//default is 1 time
		verify(ownerRepository).delete(any());
	}
	
	@Test
	void deleteById() {
		service.deleteById(1L);
		
		verify(ownerRepository).deleteById(anyLong());
	}
	
	

}
