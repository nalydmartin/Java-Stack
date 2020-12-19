package com.codingdojo.beltreview2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.beltreview2.models.Event;
import com.codingdojo.beltreview2.repos.EventRepository;

@Service
public class EventService {

	@Autowired 
	private EventRepository eRepo;
	
	
	public EventService(EventRepository eRepo) {
		this.eRepo = eRepo;
	}
	
	
	// -------------- FIND ALL EVENTS -------------- //
	public List<Event> findAllEvents() {
		return eRepo.findAll();
	}
	
	
	
	// -------------- FIND ONE EVENT -------------- //

	public Event findEvent(Long id) {
		
		Optional<Event> event = eRepo.findById(id);
		if(event.isPresent()) {
			return event.get();
		} else {
			return null;
		}
	}
	
	
	// -------------- CREATE EVENT -------------- //

	public void createEvent(Event event) {
		eRepo.save(event);
	}
	
	
	// -------------- UPDATE EVENT -------------- //

	public void updateEvent(Long id, Event event) {
		
		Event oldEvent = this.findEvent(id);
		
		oldEvent.setName(event.getName());
		oldEvent.setDate(event.getDate());
		oldEvent.setLocation(event.getLocation());
		oldEvent.setState(event.getState());
		
		eRepo.save(oldEvent);
	}
	
	
	// -------------- DELETE EVENT -------------- //
	
	public void deleteEvent(Long id) {
		eRepo.deleteById(id);
	}
	
}
