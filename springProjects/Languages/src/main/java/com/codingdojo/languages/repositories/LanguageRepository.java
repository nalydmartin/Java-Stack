package com.codingdojo.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{

	// Retrieves all languages from the database
	List<Language> findAll();
	
	// Retrieves language by its name from the database
	List<Language> findByName(String search);
	
	
	List<Language> findByCreator(String search);
	
}
