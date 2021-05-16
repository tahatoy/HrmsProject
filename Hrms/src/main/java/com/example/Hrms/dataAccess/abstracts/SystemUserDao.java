package com.example.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.SystemUser;

public interface SystemUserDao extends JpaRepository<SystemUser, Integer> {

}
