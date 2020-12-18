package com.codingdojo.beltreview.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.beltreview.models.Event;

@Repository
public interface EventRepo extends CrudRepository<Event, Long> {

	// ------------- FINDS ALL EVENTS IN THE DATABASE ------------- //
	List<Event> findAll();
	
}
