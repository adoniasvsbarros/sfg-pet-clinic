package com.adoniasbarros.sfgpetclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adoniasbarros.sfgpetclinic.model.Owner;
import com.adoniasbarros.sfgpetclinic.model.Vet;
import com.adoniasbarros.sfgpetclinic.services.OwnerService;
import com.adoniasbarros.sfgpetclinic.services.VetService;


@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirst_name("Michael");
		owner1.setLast_name("Weston");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirst_name("Fiona");
		owner2.setLast_name("Glenane");

		ownerService.save(owner2);

		System.out.println("Loaded owners...");

		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirst_name("Sam");
		vet1.setLast_name("Axe");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirst_name("Jessie");
		vet2.setLast_name("Porter");

		vetService.save(vet2);

		System.out.println("Loaded vets...");
	}
}
