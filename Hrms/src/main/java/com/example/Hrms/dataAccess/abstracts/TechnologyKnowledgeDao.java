package com.example.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.TechnologyKnowledge;

public interface TechnologyKnowledgeDao extends JpaRepository<TechnologyKnowledge, Integer> {

}
