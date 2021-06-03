package com.example.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	boolean existsByEmail(String email);
	boolean existsByPhoneNumber(String phoneNumber);
	boolean existsByWebsite(String website);
	Employer findById(Employer employer);
	Employer findByEmail(String email);
}
