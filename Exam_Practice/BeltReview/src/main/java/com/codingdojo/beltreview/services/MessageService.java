package com.codingdojo.beltreview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.beltreview.models.Event;
import com.codingdojo.beltreview.models.Message;
import com.codingdojo.beltreview.models.User;
import com.codingdojo.beltreview.repos.MessageRepo;

@Service
public class MessageService {

	@Autowired
	private MessageRepo mRepo;
	
	
	
	// -------------- FIND ALL MESSAGES -------------- //
	
	public List<Message> findAllMessages() {
		return mRepo.findAll();
	}
	
	
	// -------------- FIND ONE MESSAGE -------------- //

	public Message findMessageById(Long id) {
		
		Optional<Message> message = mRepo.findById(id);
		
		if(message.isPresent()) {
			return message.get();
		} else {
			return null;
		}
	}
	
	
	// -------------- CREATE MESSAGE -------------- //

	public void createMessage(Message message) {
		
		mRepo.save(message);
	}
	
	
	// -------------- CREATE MESSAGE -------------- //

	public void createNewMessage(String message, User user, Event event) {
		
		Message newMessage = new Message();
		
		newMessage.setComment(message);
		newMessage.setUser(user);
		newMessage.setEvent(event);
		
		mRepo.save(newMessage);
	}
	
	// -------------- UPDATE MESSAGE -------------- //
	
	public void updateMessage(Long id, Message message) {
		
		Message oldMessage = this.findMessageById(id);
		
		oldMessage.setComment(message.getComment());
		
		mRepo.save(oldMessage);
	}
	
	
	// -------------- DELETE MESSAGE -------------- //

	public void deleteMessage(Long id) {
		mRepo.deleteById(id);
	}
	
	
}
