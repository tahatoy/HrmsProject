package com.example.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="email_validators")

public class EmailValidator {

	@Id
	@Column(name="user_id",nullable=false)
	private int userId;
	
	@Column(name="is_validate",nullable=false)
	private boolean is_validate;
	
	public EmailValidator(){
		
	}

	public EmailValidator(int userId, boolean is_validate) {
		super();
		this.userId = userId;
		this.is_validate = is_validate;
	}
	
}
