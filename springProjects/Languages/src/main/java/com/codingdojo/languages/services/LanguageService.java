package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	// adding the book repository as a dependency
	private final LanguageRepository langRepo;
	
	
	// initializing the language repository
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	
	// Uses the crud repository find all method to retrieve all languages
	public List<Language> allLanguages() {
		return langRepo.findAll();
	}
	
	
	// creates a language
	public Language createLanguage(Language lang) {
		return langRepo.save(lang);
	}
	
	
	// updates a language from LanguagesApi.java
	public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
		
		Language lang = this.findLanguage(id);
		
		lang.setName(name);
		lang.setCreator(creator);
		lang.setCurrentVersion(currentVersion);
		
		langRepo.save(lang);
		return lang;
	}
	
	
	// updates a language from LanguagesController.java
	public Language updateLanguage(Language lang) {
		
		langRepo.save(lang);
		return lang;
	}
	
	
	// Retrieves a language object or retrieves null
	public Language findLanguage(Long id) {
		// optional can hold another object or hold null
		Optional<Language> optionalLanguage = langRepo.findById(id);
		if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
		
	}
	
	
	// deletes a language from the repository / database
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}
	
	 
}
