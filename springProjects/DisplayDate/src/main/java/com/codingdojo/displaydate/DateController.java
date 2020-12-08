package com.codingdojo.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {
	
	
	
	@RequestMapping("/")
	public String datePage() {
		
		return "index.jsp";
	}

	@RequestMapping("/date")
	public String date(Model model) {
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEEEEE', the' dd 'of 'MMMMMMMM', ' yyyy");
		
		String dateFormat = sdf.format(d);
		
		model.addAttribute("date", dateFormat);
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date t = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
		
		String timeFormat = sdf.format(t);
		
		model.addAttribute("time", timeFormat);
		return "time.jsp";
	}
	
	
}
