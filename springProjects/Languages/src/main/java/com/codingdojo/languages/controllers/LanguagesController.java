package com.codingdojo.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguagesController {

	private final LanguageService langService;
	
	
	public LanguagesController(LanguageService langService) {
		this.langService = langService;
	}
	
	
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language lang) {
		
		List<Language> languages = langService.allLanguages();
		
		model.addAttribute("languages", languages);
		
		return "/languages/index.jsp";
	}
	
	
	@RequestMapping("/languages/new")
	public String newLanguage(@ModelAttribute("language") Language lang) {
		
		return "/languages/index.jsp";
	}
	
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language lang, 
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "/languages/index.jsp";
		} else {
			langService.createLanguage(lang);
			return "redirect:/languages";
		}
	}
	
	
	@RequestMapping("/languages/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		
		Language lang = langService.findLanguage(id);
		model.addAttribute("languages", lang);
		return "/languages/bookInfo.jsp";
	}
	
	
	@RequestMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language lang = langService.findLanguage(id);
		model.addAttribute("languages", lang);
		
		return "/languages/edit.jsp";
	}
	
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.POST) 
	public String update(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		
		if (result.hasErrors()) {
			return "/languages/edit.jsp";
		} else {
			langService.updateLanguage(lang);
			return "redirect:/languages";
		}
	}
	
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		langService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
}
