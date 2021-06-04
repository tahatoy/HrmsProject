package com.example.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hrms.entities.concretes.CvImage;

public interface CvImageDao extends JpaRepository<CvImage, Integer>{

}
