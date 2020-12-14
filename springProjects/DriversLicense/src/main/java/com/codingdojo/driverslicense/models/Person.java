package com.codingdojo.driverslicense.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="persons")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min=1, message="First name must be at least 1 character.")
    private String firstName;
    
    @Size(min=1, message="Last name must be at least 1 character.")
    private String lastName;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private License license;
    
    
    //-------------------------PERSON CONSTRUCTOR---------------------------//
    
    public Person() {
        
    }


	public Person(@Size(min = 1) String firstName, 
			@Size(min = 1) String lastName, License license) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.license = license;
	}

	//-------------------------PERSON CONSTRUCTOR---------------------------//
	
	//-------------------------Getters and Setters---------------------------//

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


	public License getLicense() {
		return license;
	}


	public void setLicense(License license) {
		this.license = license;
	}
    
	//-------------------------Getters and Setters---------------------------//

	// ----------------------------------------------------------------------
			// 
				@PrePersist
			    protected void onCreate(){
			        this.createdAt = new Date();
			    }
			    @PreUpdate
			    protected void onUpdate(){
			        this.updatedAt = new Date();
			    }
			
		
    
}   