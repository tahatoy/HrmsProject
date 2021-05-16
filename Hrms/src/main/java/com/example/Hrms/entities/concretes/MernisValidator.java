package com.example.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="mernis_validators")
public class MernisValidator {
	
	@Id
	@Column(name="mernis_user_id")
	private int userId;
	
	@Column(name="is_validate")
	private boolean is_validate;

	public MernisValidator() {
		
	}

	public MernisValidator(int userId, boolean is_validate) {
		super();
		this.userId = userId;
		this.is_validate = is_validate;
	}
	
	
	
}
