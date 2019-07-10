package com.adoniasbarros.sfgpetclinic.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.adoniasbarros.sfgpetclinic.model.Pet;
import com.adoniasbarros.sfgpetclinic.model.Visit;
import com.adoniasbarros.sfgpetclinic.services.PetService;
import com.adoniasbarros.sfgpetclinic.services.VisitService;

@Controller
public class VisitController {

	private final String CREATE_OR_UPDATE_VISIT_FORM = "pets/createOrUpdateVisitForm";

	VisitService visitService;
	PetService petService;

	public VisitController(VisitService visitService, PetService petService) {
		this.visitService = visitService;
		this.petService = petService;
	}

	@ModelAttribute("visit")
	public Visit setPet(@PathVariable String petId, Model model) {
		Pet pet = petService.findById(Long.valueOf(petId));
		model.addAttribute("pet", pet);
		Visit visit = new Visit();
		visit.setPet(pet);
		return visit;
		
	}
	
	@GetMapping("owners/*/pets/{petId}/visits/new")
	public String initNewVisitForm(Visit visit, @PathVariable String petId, Model model) {
		return CREATE_OR_UPDATE_VISIT_FORM;
	}
	
	@PostMapping("owners/{ownerId}/pets/{petId}/visits/new")
	public String processNewVisitForm(@Valid Visit visit, BindingResult result) {		
		if(result.hasErrors()) {
			return CREATE_OR_UPDATE_VISIT_FORM;
		} else {
			visitService.save(visit);
			return "redirect:/owners/{ownerId}";
		}
	}
}
