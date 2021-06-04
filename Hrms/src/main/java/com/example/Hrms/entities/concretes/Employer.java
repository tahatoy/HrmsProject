package com.example.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@PrimaryKeyJoinColumn(name = "employer_id", referencedColumnName="id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobs"})
@Table(name="employers")
public class Employer extends User {

	
	@Column(name="company_name",nullable=false)
	private String companyName;
	
	@Column(name="web_site",nullable=false)
	private String website;
	
	@Column(name="phone_number",nullable=false)
	private String phoneNumber;
	
	@Column(name="status")
	private boolean status;
	
	@OneToMany(mappedBy="employer")
	private List<Job> jobs;
	


	
}
