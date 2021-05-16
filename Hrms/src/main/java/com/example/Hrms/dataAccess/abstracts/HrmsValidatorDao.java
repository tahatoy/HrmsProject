package com.example.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.HrmsValidator;

public interface HrmsValidatorDao extends JpaRepository<HrmsValidator, Integer> {

}
