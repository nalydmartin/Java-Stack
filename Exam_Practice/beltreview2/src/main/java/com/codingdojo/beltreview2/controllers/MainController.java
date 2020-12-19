package com.codingdojo.beltreview2.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.beltreview2.models.Event;
import com.codingdojo.beltreview2.models.User;
import com.codingdojo.beltreview2.services.EventService;
import com.codingdojo.beltreview2.services.UserService;

@Controller
public class MainController {

	@Autowired
	private EventService eService;
	
	@Autowired
	private UserService uService;
	
	// ---------- PROCESS CREATE EVENT FORM ---------- //
	
	@PostMapping("/create_event")
	public String newEvent(@Valid @ModelAttribute("event") Event event, BindingResult results, HttpSession session) {
		
		User user = uService.findUserById((Long) session.getAttribute("userId"));
		
		if(results.hasErrors()) {
			return "homePage.jsp";
		} else {
			event.setUser(user);
			eService.createEvent(event);
			return "redirect:/home";
		}
		
	}
	
	
	// ---------- RENDER EDIT EVENT PAGE ---------- //

	@GetMapping("/edit_event/{id}")
	public String updateEvent(@PathVariable("id") Long id, @ModelAttribute("event") Event event, Model model) {
		
		model.addAttribute("event", eService.findEvent(id));
		
		return "editevent.jsp";
	}
	
	
	// ---------- PROCESS EDIT EVENT FORM ---------- //
	
	@PostMapping("/update_event/{id}")
	public String updatedEvent(@Valid @ModelAttribute("event")Event event, @PathVariable("id") Long id, BindingResult results) {
		
		if(results.hasErrors()) {
			return "redirect:/edit_event/" + id ;
		} else {
			
			eService.updateEvent(id, event);
			return "redirect:/home";
		}
		
	}
	
	// ---------- PROCESS EVENT DELETION ---------- //
	
	@GetMapping("/delete_event/{id}")
	public String deleteEvent(@PathVariable("id") Long id) {
		
		eService.deleteEvent(id);
		return "redirect:/home";
	}
	
	
	// ---------- RENDER EVENT DETAILS PAGE ---------- //
	@GetMapping("/event_details/{id}")
	public String eventDetails(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("event", eService.findEvent(id));
		
		return "eventdetails.jsp";
	}
	
}
