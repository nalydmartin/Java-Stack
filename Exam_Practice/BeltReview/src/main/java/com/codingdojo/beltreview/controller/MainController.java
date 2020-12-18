package com.codingdojo.beltreview.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.beltreview.models.Event;
import com.codingdojo.beltreview.models.Message;
import com.codingdojo.beltreview.models.User;
import com.codingdojo.beltreview.services.EventService;
import com.codingdojo.beltreview.services.MessageService;
import com.codingdojo.beltreview.services.UserService;

@Controller
public class MainController {

	@Autowired
	private EventService eServ;
	
	@Autowired
	private MessageService mServ;
	
	@Autowired
	private UserService uServ;
	
	
	// ------------- PROCESS NEW EVENT FORM ------------- //
	@PostMapping("/home/create_event")
	public String newEvent(@Valid @ModelAttribute("event") Event event, BindingResult results, HttpSession session) {
		
		User user = uServ.findUserById((Long) session.getAttribute("userID"));
		
		if(results.hasErrors()) {
			return "homePage.jsp";
		} else {
			event.setUser(user);
			eServ.createEvent(event);
			return "redirect:/home";
		}
	}
	
	
	// ------------- RENDERS THE EDIT EVENT PAGE ------------- //
	@GetMapping("/edit_event/{id}")
	public String editEvent(@PathVariable("id") Long id, @ModelAttribute("event") Event event, Model model) {
		
		model.addAttribute("event", eServ.findEventById(id));
		return "editevent.jsp";
	}
	
	
	// ------------- PROCESS EDIT EVENT FORM ------------- //
	@PostMapping("/edit_event/{id}")
	public String updateEvent(@Valid @PathVariable("id") Long id, @ModelAttribute("event") Event event, BindingResult results) {
		
		if(results.hasErrors()) {
			return "editevent.jsp";
		} else {
			Long eventId = event.getId();
			eServ.updateEvent(eventId, event);
			return "redirect:/home";
		}
	}
	
	
	// ------------- DELETE EVENT ------------- //
	@GetMapping("/delete_event/{id}")
	public String deleteEvent(@PathVariable("id") Long id) {
		eServ.deleteEvent(id);
		return "redirect:/home";
		
	}
	
	
	// ------------- RENDERS THE EVENT DETAILS PAGE ------------- //
	@GetMapping("/event_details/{id}")
	public String eventDetails(@PathVariable("id") Long id, Model model) {
		
		Event eventMessage = eServ.findEventById(id);
		List<Message> msg = eventMessage.getMessages();
		
		model.addAttribute("message", msg);
		model.addAttribute("event", eventMessage);
		return "eventdetails.jsp";
	}
	
	
	// ------------- PROCESS COMMENT FORM ------------- //

	@PostMapping("/comment/{id}")
	public String comment(@PathVariable("id")Long id, HttpSession session, @RequestParam(value="comment") String message, RedirectAttributes model) {
		
		User user = uServ.findUserById((Long) session.getAttribute("userID"));
		Event event = eServ.findEventById(id);
		
		if(message == "") {
			model.addFlashAttribute("error", "Comment must be at least 1 character.");
			return "redirect:/event_details/" + id;
		} else {
			mServ.createNewMessage(message, user, event);
			return "redirect:/event_details/" + id;
		}
		
		
		
	}
	
	
}
