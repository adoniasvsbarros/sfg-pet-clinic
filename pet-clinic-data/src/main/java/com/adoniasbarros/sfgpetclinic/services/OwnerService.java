package com.adoniasbarros.sfgpetclinic.services;

import com.adoniasbarros.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
}
