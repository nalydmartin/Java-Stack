package com.codingdojo.beltexam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.beltexam.models.Show;
import com.codingdojo.beltexam.models.User;
import com.codingdojo.beltexam.services.ShowService;
import com.codingdojo.beltexam.services.UserService;
import com.codingdojo.beltexam.validator.UserValidator;



@Controller
public class UserController {

	
	@Autowired 
	private UserService uServ;
	
	@Autowired 
	private ShowService showServ;
	
	@Autowired
	private UserValidator validator;
	
	
	public UserController(UserService userService, UserValidator userValidator) {
        this.uServ = userService;
        this.validator = userValidator;
    }
	
	 @RequestMapping("/")
	    public String registerForm(@ModelAttribute("user") User user) {
	        return "loginAndRegister.jsp";
	    }
	
	 
	 @RequestMapping(value="/register", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	    	validator.validate(user, result);
	    	if(result.hasErrors()) {
	    		return "loginAndRegister.jsp";
	    	} else {
	    	uServ.registerUser(user);
	    	session.setAttribute("userId", user.getId());
	    	return "redirect:/home";
	    	}
	    }
	 
	 
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes model, HttpSession session) {
	        if (email=="") {
	    		model.addFlashAttribute("error", "Failed to login. Please try again.");
	        	return "redirect:/";
	        }
	    	boolean isAuthenticated = uServ.authenticateUser(email,  password);
	    	if(isAuthenticated) {
	    		User u = uServ.findByEmail(email);
	    		session.setAttribute("userId", u.getId());
	    		return "redirect:/home";
	    	} else {
	    		model.addFlashAttribute("error", "Failed to login. Please try again.");
	    		return "redirect:/";
	    	}
	    }
	 
	 
	 @RequestMapping("/home")
	    public String home(HttpSession session, Model model) {
	        // get user from session, save them in the model and return the home page
	    	Long userId = (Long) session.getAttribute("userId");
	    	
	    	// Checking is user session 
	    	if(userId == null) {
	    		return "redirect:/";
	    	}
	    	List<Show> allShows = showServ.findAllShows();
	    	model.addAttribute("shows", allShows);
	    	User u = uServ.findUserById(userId);
	        model.addAttribute("user", u);
	        return "homePage.jsp";

	    }
	 
	 
	 @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	        // invalidate session
	        // redirect to login page
	    	session.invalidate();
	    	return "redirect:/";

	    }
	 
	 
}
