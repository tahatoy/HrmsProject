package com.example.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {

}
