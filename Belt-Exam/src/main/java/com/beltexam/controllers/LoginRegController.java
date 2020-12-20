package com.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beltexam.models.User;
import com.beltexam.services.UserService;
import com.beltexam.validators.UserValidator;

@Controller
public class LoginRegController {
	 private final UserService userService;
	    

	    private final UserValidator userValidator;
	    

	    public LoginRegController(UserService userService, UserValidator userValidator) {
	        this.userService = userService;
	        this.userValidator = userValidator;
	        
	    }
    
    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user) {
        return "loginAndRegister.jsp";
    }


    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "loginAndRegister.jsp";
    	} else {
    	userService.registerUser(user);
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
    	boolean isAuthenticated = userService.authenticateUser(email,  password);
    	if(isAuthenticated) {
    		User u = userService.findByEmail(email);
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
    	
    	User u = userService.findUserById(userId);
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
