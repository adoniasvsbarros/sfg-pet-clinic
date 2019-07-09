package com.adoniasbarros.sfgpetclinic.services;

import java.util.List;

import com.adoniasbarros.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
}
