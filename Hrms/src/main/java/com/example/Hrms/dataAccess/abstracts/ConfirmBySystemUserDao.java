package com.example.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.ConfirmBySystemUser;

public interface ConfirmBySystemUserDao extends JpaRepository<ConfirmBySystemUser, Integer> {

}
