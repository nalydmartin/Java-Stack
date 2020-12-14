package com.codingdojo.driverslicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.driverslicense.models.Person;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepo extends CrudRepository<Person, Long>{

	// Retrieve all persons in the database
	List<Person> findAll();
	
	
	
}
