package com.example.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.EmailValidator;



public interface EmailValidatorDao extends JpaRepository<EmailValidator, Integer> {

}
