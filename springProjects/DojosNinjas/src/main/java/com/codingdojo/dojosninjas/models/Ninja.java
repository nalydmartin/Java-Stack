package com.codingdojo.dojosninjas.models;

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
@Table(name="ninjas")
public class Ninja {
	
		
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Size(min=1, message="First name must be at least 1 character!")
	 private String firstName;
	 
	 @Size(min=1, message="Last name must be at least 1 character!")
	 private String lastName;
	 

	 @Range(min=1l, max=99l, message="Age should not be less than 1 or greater than 99!")
	 private int age;
	 
	 
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 
	 
	 // MANY NINJAS CAN BELONG TO THE SAME DOJO
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="dojo_id")
	 private Dojo dojo;
	 
 
 // --------------- NINJA CONSTRUCTORS --------------- //

 
	 public Ninja() {
	     
	 }


	public Ninja(String firstName, String lastName, int age, Dojo dojo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dojo = dojo;
	}
	
	//--------------- NINJA CONSTRUCTORS --------------- //
	
	
	//--------------- GETTER AND SETTERS --------------- //
	
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public int getAge() {
		return age;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public Dojo getDojo() {
		return dojo;
	}
	
	
	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
	 
	 
	//--------------- GETTER AND SETTERS --------------- //
	
	 
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
