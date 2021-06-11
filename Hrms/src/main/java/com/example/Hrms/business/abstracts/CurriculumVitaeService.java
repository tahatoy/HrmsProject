package com.example.Hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.CurriculumVitae;
import com.example.Hrms.entities.concretes.JobSeeker;

public interface CurriculumVitaeService {

    DataResult<List<CurriculumVitae>> getAll();
    Result add(CurriculumVitae curriculumVitae);
	DataResult<CurriculumVitae> getByJobSeekerId(int id);
	DataResult<CurriculumVitae> imageUpload(int curriculumVitaeId, MultipartFile multipartFile) throws IOException;
	
}
