package com.codingdojo.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.services.DojoService;
import com.codingdojo.dojosninjas.services.NinjaService;

@Controller
public class MainController {

	
	@Autowired 
	private DojoService dServ;
	
	@Autowired 
	private NinjaService nServ;
	
	
	
	// --------------- RENDERS THE DOJO HOMEPAGE  --------------- //
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("dojos", dServ.findAllDojos());
		return "home.jsp";
	}
	
	// --------------- RENDERS THE DOJO HOMEPAGE  --------------- //

	
	// --------------- RENDERS THE NEW DOJO HOMEPAGE  --------------- //
	
		// *** Need to send the ModelAttribute into the form so the user can update it with information.
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojoObj") Dojo dojo) {
		
		return "newdojo.jsp";
	}
	
	// --------------- RENDERS THE NEW DOJO HOMEPAGE  --------------- //

	
	// --------------- PROCESS THE NEW DOJO CREATION --------------- //

	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojoObj") Dojo dojo, BindingResult results) {
		
		if (results.hasErrors()) {
			return "newdojo.jsp";
		} else {
			dServ.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	// --------------- PROCESS THE NEW DOJO CREATION --------------- //

	
	
	// --------------- RENDERS THE NEW NINJA HOMEPAGE  --------------- //

	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninjaObj") Ninja ninja, Model model) {
		
		model.addAttribute("dojos", dServ.findAllDojos());
		return "newninja.jsp";
	}
	
	// --------------- RENDERS THE NEW NINJA HOMEPAGE  --------------- //

	
	// --------------- PROCESS THE NEW NINJA CREATED --------------- //

	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninjaObj") Ninja ninja, BindingResult results) {
		
		if(results.hasErrors()) {
			return "newninja.jsp";
		} else {
			nServ.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	// --------------- PROCESS THE NEW NINJA CREATED --------------- //

	
	// --------------- RENDERS THE DOJO AND NINJAS PAGE --------------- //

	
	@GetMapping("/dojos/{id}")
	public String dojoNinjas(@PathVariable("id") Long id, Model model) {
		
		Dojo d = dServ.findDojoById(id);
		model.addAttribute("dojo", d);
		return "dojoninjas.jsp";
	}
	
	// --------------- RENDERS THE DOJO AND NINJAS PAGE --------------- //

	
	
}

