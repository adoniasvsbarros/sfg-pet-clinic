package com.adoniasbarros.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adoniasbarros.sfgpetclinic.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{

}
