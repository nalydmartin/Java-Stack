package com.codingdojo.beltexam.controllers;

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

import com.codingdojo.beltexam.models.Show;
import com.codingdojo.beltexam.models.User;
import com.codingdojo.beltexam.services.ShowService;
import com.codingdojo.beltexam.services.UserService;

@Controller
public class MainController {

	@Autowired 
	private UserService userService;
	
	@Autowired
	private ShowService showService;
	
	
	// ----------------- RENDER NEW SHOW PAGE ----------------- //
	
	@GetMapping("/new")
	public String newShowPage(@ModelAttribute("show")Show show) {
		
		return "createshow.jsp";
	}
	
	
	
	// ----------------- PROCESS NEW SHOW FORM ----------------- //
	@PostMapping("/new")
	public String addNewShow(@Valid @ModelAttribute("show")Show show, BindingResult results, HttpSession session) {
		
		User user = userService.findUserById((Long) session.getAttribute("userId"));
		
		if(results.hasErrors()) {
			return "createshow.jsp";
		} else {
			
			show.setUser(user);
			showService.createShow(show);
			return "redirect:/home";
		}
		
	}
	
	
	// ----------------- RENDER SHOW DETAILS PAGE ----------------- //
	
	@GetMapping("/show/{id}")
	public String showDetails(@PathVariable("id")Long id, Model model) {
		
		model.addAttribute("show", showService.findShowById(id));
		return "showdetails.jsp";
	}
	
	
	
	// ----------------- RENDER EDIT SHOW PAGE ----------------- //

	@GetMapping("/edit/{id}")
	public String editShow(@PathVariable("id")Long id, @ModelAttribute("show")Show show, Model model) {
		
		model.addAttribute("show", showService.findShowById(id));
		return "editpage.jsp";
		
	}
	
	// ----------------- PROCESS EDIT SHOW FORM ----------------- //

	@PostMapping("/edit/{id}")
	public String updateShow(@Valid @ModelAttribute("show")Show show, @PathVariable("id")Long id, BindingResult results) {
		
		if(results.hasErrors()) {
			return "redirect:/edit/" +id;
		} else {
			showService.updateShow(id, show);
			return "redirect:/home";
		}
		
	}
	
	
	// ----------------- DELETE SHOW ----------------- //
	@GetMapping("/delete/{id}")
	public String deleteShow(@PathVariable("id")Long id) {
		showService.deleteShow(id);
		return "redirect:/home";
	}
	
}
