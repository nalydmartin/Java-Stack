package com.codingdojo.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;


@RestController
public class LanguagesApi {
	
	// This gives us access to the service class from the api class
	private final LanguageService langService;
	
	
	
	public LanguagesApi(LanguageService langService) {
		this.langService = langService;
	}
	
	
	@RequestMapping("/api/languages")
	public List<Language> index() {
		return langService.allLanguages();
	}
	
	
	@RequestMapping(value = "/api/languages", method=RequestMethod.POST)
	public Language create(@RequestParam(value="name") String name, 
			@RequestParam(value="creator") String creator, 
			@RequestParam(value="currentVersion") String currentVersion) {
		
		Language lang = new Language(name, creator, currentVersion);
		return langService.createLanguage(lang);
	}
	
	
	@RequestMapping(value="/api/languages/{id}")
	public Language show(@PathVariable("id") Long id) {
		
		Language lang = langService.findLanguage(id);
		return lang;
	}
	
	
	@RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
	public Language update(@PathVariable("id") Long id, 
			@RequestParam(value="name") String name, 
			@RequestParam(value="creator") String creator, 
			@RequestParam(value="currentVersion") String currentVersion) {
		
		Language lang = langService.updateLanguage(id, name, creator, currentVersion);
		
		return lang;
	}
	
	
	@RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		langService.deleteLanguage(id);
	}
	
}
