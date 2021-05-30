package com.example.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cities")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobs"})
public class City {

	@Id
	@Column(name="cities_Id")
	private int citiesId;
	
	@Column(name="city_name")
	private String cityName;
	
	@OneToMany(mappedBy="city")
	private List<Job> jobs;
	
}
