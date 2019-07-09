package com.adoniasbarros.sfgpetclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adoniasbarros.sfgpetclinic.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{

	Owner findByLastName(String lastName);

	List<Owner> findAllByLastNameLike(String lastName);
}