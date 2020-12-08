package com.codingdojo.hellohuman;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class humanController {

	@RequestMapping("/")
	public String name(@RequestParam(value="name", required=false) String fname, String lname) {
		
		if (fname == null) {
			return "<h1>Hello human!<h1><p>Welcome to SpringBoot</p>";
		} else if (lname == null){
			return "<h1>Hello " + fname + "</h1><p>Welcome to SpringBoot</p>";
		}  else {
			return "<h1>Hello " + fname + lname + "</h1><p>Welcome to SpringBoot</p>";
		}
	}
}
