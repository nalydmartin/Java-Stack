package com.codingdojo.routing;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DojoController{

	@RequestMapping("/{dojo}")
	public String dojo(@PathVariable("dojo") String dojo) {
		
		if(dojo.equals("dojo")) {
			return "Dojo: " + dojo;
		}
		
		if (dojo.equals("burbank")) {
			return "Burbank Dojo is located in Southern California.";
		}
		
		if(dojo.equals("san-jose")) {
			return "SJ Dojo is the headquarters.";
		}
		else {
			return "Nothing here.";
		}
	}
	

}
