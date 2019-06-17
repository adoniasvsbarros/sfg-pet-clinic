package com.adoniasbarros.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adoniasbarros.sfgpetclinic.model.Owner;
import com.adoniasbarros.sfgpetclinic.model.Pet;
import com.adoniasbarros.sfgpetclinic.model.PetType;
import com.adoniasbarros.sfgpetclinic.model.Vet;
import com.adoniasbarros.sfgpetclinic.services.OwnerService;
import com.adoniasbarros.sfgpetclinic.services.PetTypeService;
import com.adoniasbarros.sfgpetclinic.services.VetService;


@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	@Autowired
	public DataLoader(PetTypeService petTypeService, OwnerService ownerService, VetService vetService) {
		this.petTypeService = petTypeService;
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);		
		
		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);	
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("5 York Street");
		owner1.setCity("Toronto");
		owner1.setTelephone("80804567");

		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenane");
		owner2.setAddress("6 York Street");
		owner2.setCity("Toronto");
		owner2.setTelephone("70807654");
		
		Pet fionasPet = new Pet();
		fionasPet.setPetType(savedCatPetType);
		fionasPet.setOwner(owner2);
		fionasPet.setBirthDate(LocalDate.now());
		fionasPet.setName("Cato");
		owner2.getPets().add(fionasPet);

		ownerService.save(owner2);

		System.out.println("Loaded owners...");

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");

		vetService.save(vet2);

		System.out.println("Loaded vets...");
	}
}
