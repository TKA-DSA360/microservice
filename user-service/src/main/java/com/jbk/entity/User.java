package com.jbk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	private long userId;
	
	private String userName;
	private String userEmail;
	private String userPassword;
	
	@OneToOne
	private Address address;
	
	

}
