package com.example.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
