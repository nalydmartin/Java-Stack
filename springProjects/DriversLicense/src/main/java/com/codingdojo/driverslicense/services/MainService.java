package com.codingdojo.driverslicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.driverslicense.models.License;
import com.codingdojo.driverslicense.models.Person;
import com.codingdojo.driverslicense.repositories.LicenseRepo;
import com.codingdojo.driverslicense.repositories.PersonRepo;


@Service
public class MainService {
	
	@Autowired
	private PersonRepo pRepo;
	
	@Autowired
	private LicenseRepo lRepo;
	
	
	public List<Person> findAllPersons() {
		
		return pRepo.findAll();
	}
	
	
	// Retrieve a single person from the database--------------------------------------------
	public Person findPersonById(Long id) {
		
		Optional<Person> person = pRepo.findById(id);
		
		if(person.isPresent()) {
			return person.get();
		} else {
			return null;
		}
	}
	
	// Retrieves a single license from the database--------------------------------------------
	public License findLicenseById(Long id) {
		
		Optional<License> license = lRepo.findById(id);
		
		if(license.isPresent()) {
			return license.get();
		} else {
			return null;
		}
	}
	
	// Saves a new person to the database--------------------------------------------
	public Person createPerson(Person person) {
		
		pRepo.save(person);
		return person;
	}
	
	// Saves a new license to the database--------------------------------------------
	public License createLicense(License license) {
		
	//		Long newNum = Long.parseLong("" + license.getId());
		
		license.setNumber(String.format("%06d", license.getId() ) );
		
		lRepo.save(license);
		return license;
	}
	
	

}
