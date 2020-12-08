package com.codingdojo.counter;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/your_server")
public class CounterController {
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		
//		session.setAttribute("count", 0);
		
		Object sessionCount = session.getAttribute("count");
		
		if (sessionCount == null) {
			session.setAttribute("count", 0);
			model.addAttribute("count", session.getAttribute("count"));
		}
		
		session.setAttribute("count", (Integer) session.getAttribute("count") + 1);
		
		model.addAttribute("count", session.getAttribute("count"));
		
		return "index.jsp";
	}
	
	
	@RequestMapping("/counter")
	public String counter() {
		
		return "counter.jsp";
	}
	
	
	@RequestMapping("/clear")
	public String clear(HttpSession session) {
	
		session.invalidate();
		
		return "redirect:/your_server/";
	}
}
