package com.example.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "employer_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobs"})
@Table(name="employers")
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
	
	@OneToMany(mappedBy="employer")
	private List<Job> jobs;
	


	
}
