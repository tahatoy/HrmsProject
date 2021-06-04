package com.example.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="curriculum_vitaes")

public class CurriculumVitae {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private int curriculumVitaeId;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedın_link")
	private String linkedınLink;
	
	
	@Column(name="description")
	private String description;
	
	@Column(name = "profile_photo")
	private String profilePhoto;
	
	
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<WorkExperience> workExperiences;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<School> schools;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<TechnologyKnowledge> technologyKnowledges;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<CvImage> cvImages;
	
	
	
}
