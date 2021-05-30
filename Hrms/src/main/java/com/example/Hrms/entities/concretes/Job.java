package com.example.Hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jobs")
public class Job {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;

	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_Salary")
	private int minSalary;
	
	@Column(name="open_positions")
	private int openPositions;
	
	@Column(name="position_expire_date")
	private Date positionExpireDate;

	@Column(name="is_active")
	private boolean active;
	
	@Column(name="created_time")
	private Date createdTime;
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	
}
