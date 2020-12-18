package com.codingdojo.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.loginreg.models.User;
import com.codingdojo.loginreg.services.UserService;
import com.codingdojo.loginreg.validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;
    
	@Autowired
	private UserValidator validator;
    
    
    public UserController(UserService userService, UserValidator validator) {
        this.userService = userService;
        this.validator = validator;
    }
    
    
    // ------------------ RENDERS REGISTRATION PAGE ------------------ //
    
    @GetMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    
    // ------------------ RENDERS LOGIN PAGE ------------------ //
    
    @GetMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    
    // ------------------ PROCESSES REGISTRATION FORM ------------------ //

    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	validator.validate(user, result);
    	if(result.hasErrors()) {
    		return "registrationPage.jsp";
    	} else {
    		User u = userService.registerUser(user);
    		session.setAttribute("userID", u.getId());
    		return "redirect:/home";
    	}
    }
    
    
    // ------------------ PROCESSES LOGIN FORM ------------------ //
    
    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	
    	boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = userService.findByEmail(email);
    		session.setAttribute("userID", u.getId());
    		return "redirect:/home";
    	} else {
    		model.addAttribute("error", "Email or Password does not match, please try again.");
    		return "loginPage.jsp";
    	}
    }
    
    
    // ------------------ RENDERS HOME PAGE ------------------ //

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long userID = (Long) session.getAttribute("userID");
    	User u = userService.findUserById(userID);
    	model.addAttribute("curr_user", u);
    	return "homePage.jsp";
    	
    }
    
    
    // ------------------ PROCESSES LOGOUT FORM ------------------ //
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	
    	session.invalidate();
    	return "redirect:/login";
    }
    
}
