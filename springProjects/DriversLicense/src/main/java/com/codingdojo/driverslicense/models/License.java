
package com.codingdojo.driverslicense.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String number;
    
    //private Integer numberUp;
    
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;
    
    @Size(min=2, max=2, message="State must be 2 characters long.")
    private String state;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    
    
    private Person person;
    
    //-------------------------LICENSE CONSTRUCTOR---------------------------//

    public License() {
        
    }

	public License(@Future Date expirationDate,
			@Size(min = 2, max = 2, message = "State must be 2 characters long.") String state, Person person) {
		
		this.expirationDate = expirationDate;
		this.state = state;
		this.person = person;
	}

    //-------------------------LICENSE CONSTRUCTOR---------------------------//

	//-------------------------Getters and Setters---------------------------//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	

//	public Integer getNumberUp() {
//		return numberUp;
//	}
//
//	public void setNumberUp(Integer numberUp) {
//		this.numberUp = numberUp;
//	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
    
	//-------------------------Getters and Setters---------------------------//

	// ----------------------------------------------------------------------

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
				
	
	
   
}