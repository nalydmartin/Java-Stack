package com.codingdojo.beltexam.models;

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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="shows")
public class Show {

	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id; 

	
	@Size(min=1, message="Title must be at least 1 character.")
	private String name;
	
	
	@Size(min=1, message="Network must be at least 1 character.")
	private String network;
	
	
	@Range(min=1, max=5, message="Rating must be between 1 and 5.")
	private Integer rating;
	
	
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
	
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
	
    // ------------------------- SHOW CONSTRUCTORS ------------------------- //

	public Show() {
		
	}


	public Show(@Size(min = 1, message = "Title must be at least 1 character.") String name,
			@Size(min = 1, message = "Network must be at least 1 character.") String network,
			@Range(min = 1, max = 5, message = "Rating must be between 1 and 5.") Integer rating, User user) {
		super();
		this.name = name;
		this.network = network;
		this.rating = rating;
		this.user = user;
	}


    // ------------------------- SHOW GETTERS AND SETTERS ------------------------- //

	
	
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


	public String getNetwork() {
		return network;
	}


	public void setNetwork(String network) {
		this.network = network;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
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
    
    
	//------------------------FOR DATES/TIMES CREATED/UPDATED--------------------------//
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}

    
}
