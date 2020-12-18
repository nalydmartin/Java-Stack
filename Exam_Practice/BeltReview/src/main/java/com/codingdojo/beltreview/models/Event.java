package com.codingdojo.beltreview.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Size(min=2, message="Name must be at least 2 characters.")
	private String name;
	
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	
	@Size(min=2, message="Location must be at least 2 characters.")
	private String location;
	
	
	private String state;
	
	
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    // Event is the child of User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    // Event is the owner of messages
    @OneToMany(mappedBy="event", fetch = FetchType.LAZY)
    private List<Message> messages;
    
// ------------------------- FOR DATE CREATED/UPDATED ------------------------- //
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
 // ------------------------- EVENT CONSTRUCTORS ------------------------- //
    
    public Event() {
    	
    }
    
  
	public Event(@Size(min = 2, message = "Name must be at least 2 characters.") String name, @Future Date date,
			@Size(min = 2, message = "Name must be at least 2 characters.") String location, String state) {
		
		this.name = name;
		this.date = date;
		this.location = location;
		this.state = state;
	}
	
	
	 // ------------------------- GETTERS AND SETTERS ------------------------- //

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
    
    
    
    
    
    
    
    
    
}
