package com.codingdojo.thecode;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {

	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	
	@RequestMapping(path="/check_pass", method=RequestMethod.POST)
	public String success(@RequestParam String password, HttpSession session) {
		
		session.setAttribute("pass", "Bushido");
		
		if(password.equals("")) {
			return "redirect:/";
		} else if(!password.equals(session.getAttribute("pass"))) {
			return "redirect:/error_message";
		} else {
			return "redirect:/code";
		}
	}
	
	
	@RequestMapping("/code")
	public String codeSuccess() {
		
		return "success.jsp";
	}
	
	@RequestMapping("/error_message")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		
		return "redirect:/";
	}
	
}
