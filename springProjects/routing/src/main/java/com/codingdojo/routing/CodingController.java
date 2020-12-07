package com.codingdojo.routing;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController{

	@RequestMapping(value="/coding", method=RequestMethod.GET)
	public String coding() {
		return "Hello Coding Dojo!";
	}
	
	
	@RequestMapping(value="/python", method=RequestMethod.GET)
	public String python() {
		return "Python/Django was sooooooo cool!";
	}
	
	
	@RequestMapping(value="/java", method=RequestMethod.GET)
	public String java() {
		return "Java makes me question my existance...";
	}
}
