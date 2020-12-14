package com.codingdojo.driverslicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.driverslicense.models.License;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long>{

	
	// Retrieve all licenses in the database

	List<License> findAll();
}
