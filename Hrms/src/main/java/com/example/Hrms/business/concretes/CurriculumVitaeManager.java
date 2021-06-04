package com.example.Hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Hrms.business.abstracts.CurriculumVitaeService;
import com.example.Hrms.core.adapters.CloudinaryAdapterService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessDataResult;
import com.example.Hrms.core.utilities.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.CurriculumVitaeDao;
import com.example.Hrms.entities.concretes.CurriculumVitae;
import com.example.Hrms.entities.concretes.JobSeeker;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;
	private CloudinaryAdapterService cloudinaryAdapterService;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao,
			CloudinaryAdapterService cloudinaryAdapterService) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.cloudinaryAdapterService = cloudinaryAdapterService;
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll());
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("Cv başarıyla sisteme eklendi");
	}

	@Override
	public DataResult<CurriculumVitae> imageUpload(int curriculumVitaeId, MultipartFile multipartFile)
			throws IOException {
		CurriculumVitae curriculumVitae = this.curriculumVitaeDao.findById(curriculumVitaeId).get();
		var result= this.cloudinaryAdapterService.CvImageUpload(multipartFile);
		curriculumVitae.setProfilePhoto(result.getData().get("url").toString());
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessDataResult<>("Fotograf basariyla kaydedildi.");
	}

}
