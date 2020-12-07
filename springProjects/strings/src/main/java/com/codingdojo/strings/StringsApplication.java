package com.codingdojo.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication

@RestController
@RequestMapping("/cool")
public class StringsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	
	
	@RequestMapping("")
	public String hello() {		
		return "Hello Worlds!";
	}
	
	
	@RequestMapping("/random")
	public String random() {
		return "Help! I'm trapped inside the computer and I can't get out!!!";
	}
}
