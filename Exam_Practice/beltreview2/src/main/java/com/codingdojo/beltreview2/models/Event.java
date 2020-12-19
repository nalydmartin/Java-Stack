package com.codingdojo.beltreview2.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	  
	  @Size(min=1, message="Name must be at least 1 character.")
	  private String name;
	  
	  @Size(min=2, message="Location must be at least 2 characters.")
	  private String location;
	  
	  @Future
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	  private Date date;
	  
	  
	  private String state;
	  
	  @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    // --------------- EVENT CONSTRUCTORS --------------- ///
	    
		public Event(@Size(min = 1, message = "Name must be at least 1 character.") String name,
				@Size(min = 2, message = "Location must be at least 2 characters.") String location, @Future Date date,
				String state) {
			super();
			this.name = name;
			this.location = location;
			this.date = date;
			this.state = state;
		}
	  
	
	    public Event() {
	    	
	    }

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user;
	    
	    // --------------- EVENT GETTERS ANS SETTERS --------------- ///

	    

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


		public String getLocation() {
			return location;
		}


		public void setLocation(String location) {
			this.location = location;
		}


		public Date getDate() {
			return date;
		}


		public void setDate(Date date) {
			this.date = date;
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
	    
	    
	    
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
		
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}
	    
	
}
