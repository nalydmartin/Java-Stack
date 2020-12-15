package com.codingdojo.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.repos.NinjaRepo;


@Service
public class NinjaService {

	@Autowired 
	private NinjaRepo ninjaRepo;
	
	

	// ------------- Find All Ninjas ------------- //

	public List<Ninja> findAllNinjas() {
		
		return ninjaRepo.findAll();
	}
	
	// ------------- Find All Ninjas ------------- //

	
	
	// ------------- Find One Ninja ------------- //

	public Ninja findNinjaById(Long id) {
		
		Optional<Ninja> ninja = ninjaRepo.findById(id);
		
		if(ninja.isPresent()) {
			return ninja.get();
		} else {
			return null;
		}
	}
	
	// ------------- Find One Ninja ------------- //

	
	
	// ------------- Create/Update Ninja ------------- //
	
	public Ninja createNinja(Ninja ninja) {
		
		return ninjaRepo.save(ninja);
	}
	
	// ------------- Create/Update Ninja ------------- //

	

	// ------------- Delete Ninja ------------- //

	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
	
	// ------------- Delete Ninja ------------- //

	
}
