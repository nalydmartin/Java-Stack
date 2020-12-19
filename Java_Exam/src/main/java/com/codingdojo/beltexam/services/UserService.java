package com.codingdojo.beltexam.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.beltexam.models.User;
import com.codingdojo.beltexam.repos.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository uRepo;
	
	
	public UserService(UserRepository userRepo) {
		this.uRepo = userRepo;
	}
	
	// ------- REGISTER USER AND PASSWORD ------- //
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return uRepo.save(user);
	}
	
	
	// ------- FIND USER BY EMAIL ------- //
	public User findByEmail(String email) {
        return uRepo.findByEmail(email);
    }
	
	
	// ------- FIND USER BY ID ------- //
	 public User findUserById(Long id) {
	    	Optional<User> u = uRepo.findById(id);
	    	
	    	if(u.isPresent()) {
	            return u.get();
	    	} else {
	    	    return null;
	    	}
	    }
	 
		// ------- AUTHENTICATE USER ------- //

	 public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = uRepo.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
     }
	 
	 
	 
}
