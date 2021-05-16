package com.example.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Employers")
public class Employer {

	@Id
	@Column(name="employer_id",nullable=false)
	private int userId;
	
	@Column(name="company_name",nullable=false)
	private String companyName;
	
	@Column(name="web_site",nullable=false)
	private String website;
	
	@Column(name="phone_number",nullable=false)
	private String phoneNumber;
	
	public Employer() {
		
	}

	public Employer(int userId, String companyName, String website, String phoneNumber) {
		super();
		this.userId = userId;
		this.companyName = companyName;
		this.website = website;
		this.phoneNumber = phoneNumber;
	}
	
}
