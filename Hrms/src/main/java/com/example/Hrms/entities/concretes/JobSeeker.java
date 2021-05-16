package com.example.Hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="job_seekers")
public class JobSeeker {
	@Id
	@Column(name="jobseeker_user_id",nullable=false)
	private int jobSeekerId;
	
	@Column(name="jobseeker_first_name",nullable=false)
	private String firstName;
	
	@Column(name="jobseeker_last_name",nullable=false)
	private String lastName;
	
	@Column(name="jobseeker_national_id",nullable=false)
	private String nationalId;
	
	@Column(name="job_seeker_birth_date",nullable=false)
	private Date birthDate;
	
	public JobSeeker() {
		
		
	}

	public JobSeeker(int jobSeekerId, String firstName, String lastName, String nationalId, Date birthDate) {
		super();
		this.jobSeekerId = jobSeekerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalId = nationalId;
		this.birthDate = birthDate;
	}
	
	
	
}
