package com.codingdojo.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.beltexam.models.Show;
import com.codingdojo.beltexam.repos.ShowRepository;

@Service
public class ShowService {

	@Autowired
	private ShowRepository sRepo;
	
	
	// -------------------- FIND ALL SHOWS -------------------- //
	
	public List<Show> findAllShows() {
		
		return sRepo.findAll();
	}
	
	
	
	
	// -------------------- FIND ONE SHOW -------------------- //
	
	public Show findShowById(Long id) {
		
		Optional<Show> show = sRepo.findById(id);
		
		if(show.isPresent()) {
			return show.get();
		} else {
			return null;
		}
	}
	
	
	
	// -------------------- CREATE SHOW -------------------- //

	public void createShow(Show show) {
		
		sRepo.save(show);
	}
	
	
	
	// -------------------- UPDATE SHOW -------------------- //

	
	public void updateShow(Long id, Show show) {
		
		Show oldShow = this.findShowById(id);
		
		oldShow.setName(show.getName());
		oldShow.setNetwork(show.getNetwork());
		oldShow.setRating(show.getRating());
		
		sRepo.save(oldShow);
	}
	
	
	
	// -------------------- DELETE SHOW -------------------- //

	public void deleteShow(Long id) {
		
		sRepo.deleteById(id);
	}
	
}
