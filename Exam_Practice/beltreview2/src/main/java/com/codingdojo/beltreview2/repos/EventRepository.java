package com.codingdojo.beltreview2.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltreview2.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{

	List<Event> findAll();
	
	
}
