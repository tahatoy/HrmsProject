package com.example.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.Verification;

public interface VerificationDao extends JpaRepository<Verification, Integer> {

}
