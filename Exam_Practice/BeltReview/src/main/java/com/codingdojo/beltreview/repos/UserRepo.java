package com.codingdojo.beltreview.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltreview.models.User;



@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	
    User findByEmail(String email);
    
    
}