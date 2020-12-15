package com.codingdojo.dojosninjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosninjas.models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long>{

	
	// Find and return all Dojos in the database
	List<Dojo> findAll();
	
	
	
}
