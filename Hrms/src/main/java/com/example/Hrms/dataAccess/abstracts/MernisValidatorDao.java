package com.example.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.MernisValidator;

public interface MernisValidatorDao extends JpaRepository<MernisValidator,Integer> {

}
