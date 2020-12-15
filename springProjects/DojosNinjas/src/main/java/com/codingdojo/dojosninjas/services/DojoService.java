package com.codingdojo.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.repos.DojoRepo;


@Service
public class DojoService {

	@Autowired
	private DojoRepo dojoRepo;
	
	
	// ------------- Find All Dojos ------------- //
	
	public List<Dojo> findAllDojos() {
		
		return dojoRepo.findAll();
		}
	
	
	// ------------- Find All Dojos ------------- //

	
	
	// ------------- Find One Dojo ------------- //
	
	public Dojo findDojoById(Long id) {
		
		Optional<Dojo> dojo = dojoRepo.findById(id);
		
		if (dojo.isPresent()) {
			return dojo.get();
		} else {
			return null;
		}
	}

	// ------------- Find One Dojo ------------- //

	
	
	// ------------- Create/Update Dojo ------------- //
	
	public Dojo createDojo(Dojo dojo) {
		
		return dojoRepo.save(dojo);
	}
	
	
	// ------------- Create/Update Dojo ------------- //

	
	
	// ------------- Delete Dojo ------------- //

	public void deleteDojo(Long id) {
		
		dojoRepo.deleteById(id);
	}
	
	// ------------- Delete Dojo ------------- //


	
}
