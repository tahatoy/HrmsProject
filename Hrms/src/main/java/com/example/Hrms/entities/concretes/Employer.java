package com.example.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="Employers")
public class Employer extends User {

	
	@Column(name="company_name",nullable=false)
	private String companyName;
	
	@Column(name="web_site",nullable=false)
	private String website;
	
	@Column(name="phone_number",nullable=false)
	private String phoneNumber;
	
	@Column(name="email_verify")
	private boolean emailVerify=false;

	public Employer(String email, String password, String companyName, String website, String phoneNumber,boolean emailVerify) {
		super(email, password);
		this.companyName = companyName;
		this.website = website;
		this.phoneNumber = phoneNumber;
		this.emailVerify=emailVerify;
	}
	
	


	
}
