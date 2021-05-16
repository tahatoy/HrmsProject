package com.example.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="hrms_validators")

public class HrmsValidator {

	@Id
	@Column(name="system_user_id",nullable=false)
	private int id;
	
	@Column(name="employer_id",nullable=false)
	private int employerId;
	
	@Column(name="is_validate",nullable=false)
	private boolean is_validate;
	
	public HrmsValidator() {
		
	}

	public HrmsValidator(int id, int employerId, boolean is_validate) {
		super();
		this.id = id;
		this.employerId = employerId;
		this.is_validate = is_validate;
	}
	
	
	
}

