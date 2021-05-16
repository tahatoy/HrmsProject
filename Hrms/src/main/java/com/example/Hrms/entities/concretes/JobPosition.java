package com.example.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="job_positions")

public class JobPosition {

	@Id
	@Column(name="id",nullable=false)
	private int id;
	
	@Column(name="positionName",nullable=false)
	private String positionName;
}
