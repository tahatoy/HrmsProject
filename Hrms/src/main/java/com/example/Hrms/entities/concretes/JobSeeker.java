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


@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitaes"})
@PrimaryKeyJoinColumn(name = "id", referencedColumnName="id")

public class JobSeeker extends User {
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="national_identity")
	private String nationalId;
	
	@Column(name="birth_year")
	private String birthYear;
	
	@Column(name="status")
	private boolean status;
	
	@OneToMany(mappedBy = "jobSeeker")  //bir adayın birden fazla cvsi olabilir.
	private List<CurriculumVitae> curriculumVitaes;

		
	
}
