package com.codingdojo.beltreview.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltreview.models.Message;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long>{

	// ------------- FINDS ALL COMMENTS IN THE DATABASE ------------- //
	List<Message> findAll();
 	
	
	
}
