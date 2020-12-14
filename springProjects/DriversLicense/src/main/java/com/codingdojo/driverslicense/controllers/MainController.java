package com.codingdojo.driverslicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.driverslicense.models.License;
import com.codingdojo.driverslicense.models.Person;
import com.codingdojo.driverslicense.services.MainService;

@Controller 
public class MainController {
	
	// Autowired connects the controller to the service class
	@Autowired
	private MainService mServ;
	
	
	//----------------RENDERS THE NEW PERSON FORM PAGE----------------//
	
	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute("personObj") Person person) {
		
		return "newperson.jsp";
	}
	
	//----------------RENDERS THE NEW PERSON FORM PAGE----------------//

	
	//----------------CREATES A NEW PERSON IN THE DATABASE----------------//
	
	@PostMapping("/persons/new")
	public String createPerson(@Valid @ModelAttribute("personObj") Person person, BindingResult results) {
		
		if(results.hasErrors()) {
			return "newperson.jsp";
		} else {
			mServ.createPerson(person);
			return "redirect:/licenses/new";
		}
	}
	
	//----------------CREATES A NEW PERSON IN THE DATABASE----------------//

	
	//----------------RENDERS THE NEW LICENSE FORM PAGE----------------//
	
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("licenseObj") License license, Model model) {
		
		List<Person> persons = mServ.findAllPersons();
		model.addAttribute("persons", persons);
		
		return "newlicense.jsp";
	}
		
	//----------------RENDERS THE NEW LICENSE FORM PAGE----------------//

		
	//----------------CREATES A NEW LICENSE IN THE DATABASE----------------//
	
	@PostMapping("/licenses/new")
	public String createLicense(@Valid @ModelAttribute("licenseObj") License license, BindingResult results) {
		
		
		if(results.hasErrors()) {
			return "newlicense.jsp";
		} else {
			
			mServ.createLicense(license);
			return "redirect:/persons/" + license.getId();
		}
	}
	
	//----------------CREATES A NEW LICENSE IN THE DATABASE----------------//
	
	
	//----------------RENDERS THE PROFILE PAGE----------------//

	
	@GetMapping("/persons/{id}")
	public String profilePage(@PathVariable("id") Long id, Model model) {
		
		Person person = mServ.findPersonById(id);
		model.addAttribute("person", person);
		
		return "profile.jsp";
	}
	
	//----------------RENDERS THE PROFILE PAGE----------------//

	
}
