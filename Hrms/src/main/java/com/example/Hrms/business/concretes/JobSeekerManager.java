package com.example.Hrms.business.concretes;


import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.JobSeekerService;
import com.example.Hrms.core.checkersandvalidators.abstracts.MernisService;
import com.example.Hrms.core.checkersandvalidators.abstracts.VerificationService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.ErrorResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessDataResult;
import com.example.Hrms.core.utilities.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.JobSeekerDao;
import com.example.Hrms.entities.concretes.Employer;
import com.example.Hrms.entities.concretes.JobSeeker;
import com.example.Hrms.entities.concretes.Verification;
import com.example.Hrms.entities.dtos.JobSeekerRegisterDto;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private VerificationService verificationService;
	private MernisService mernisService;
	private ModelMapper modelMapper;
	
	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, VerificationService verificationService,
			MernisService mernisService,ModelMapper modelMapper) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.verificationService = verificationService;
		this.mernisService = mernisService;
		this.modelMapper=modelMapper;
	}

//----------------------------------------------------------------------------------------------------	

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

//----------------------------------------------------------------------------------------------------
	@Override
	public Result register(JobSeekerRegisterDto jobSeekerDto) {
		
		JobSeeker jobSeeker=this.modelMapper.map(jobSeekerDto, JobSeeker.class);
		
		if(jobSeeker.getFirstName().isEmpty() || jobSeeker.getLastName().isEmpty()
				|| jobSeeker.getNationalId().isEmpty() || jobSeeker.getNationalId().isEmpty()
				|| jobSeeker.getEmail().isEmpty() || jobSeeker.getPassword().isEmpty()
				|| jobSeeker.getFirstName().isBlank() || jobSeeker.getLastName().isBlank()
				|| jobSeeker.getPassword().isBlank()) {
			return new ErrorResult("Tüm alanlar doldurulmak zorundadır.");
		}
		
		
		if(this.jobSeekerDao.existsByEmail(jobSeeker.getEmail())==true)
			return new ErrorResult("Bu e posta sisteme kayıtlıdır");
		
		else if(this.jobSeekerDao.existsByNationalId(jobSeeker.getNationalId())==true) 
			return new ErrorResult("Bu nationalId sisteme kayıtlıdır");
		
		else if(!jobSeeker.getPassword().equals(jobSeeker.getPasswordRepeat())) 
			return new ErrorResult("Şifreler uyuşmuyor");
	
		if(!mernisService.checkMernis(jobSeeker.getFirstName(), jobSeeker.getLastName(), 
				jobSeeker.getNationalId(), jobSeeker.getBirthYear())) {
			return new ErrorResult("Doğrulama başarısız");
		}
			
		else {
			jobSeeker.setStatus(false);
			jobSeekerDao.save(jobSeeker);
			String code = verificationService.verifyCode();
			verificationCode(code, jobSeeker.getId(), jobSeeker.getEmail());
			return new SuccessResult("Kayıt başarıyla gerçekleşti");	
			}	
	}	
	
	
//----------------------------------------------------------------------------------------------------	
	@Override
	public Result emailVerification(JobSeeker jobSeeker, String activationCode) {
		if(activationCode == null) {
			return new ErrorResult("Boş olamaz");
		}
		else if(!activationCode.equals(verificationService.verifyCode())) {
			return new ErrorResult("Doğrulama kodu hatalı");
		}
		
		JobSeeker jobSeekers=getById(jobSeeker.getId()).getData();
		if(this.jobSeekerDao.findById(jobSeekers.getId())==null) {
			return new ErrorResult("Mevcut değil");
		}
		else {
			jobSeeker.setStatus(true);
			return new SuccessResult("Email doğrulaması başarılı");
		}
	}
	
	//----------------------------------------------------------------------------------------------------	
		public void verificationCode(String code, int id, String email) {
			Verification verificationCode = new Verification(id, code, false, LocalDateTime.now());
			this.verificationService.save(verificationCode);
	}

		//----------------------------------------------------------------------------------------------------	
	@Override
	public Result update(JobSeeker jobSeeker,int id) {
		JobSeeker jobSeekers=getById(id).getData();
		if(jobSeeker.getFirstName().isEmpty() || jobSeeker.getLastName().isEmpty()
				|| jobSeeker.getNationalId().isEmpty() || jobSeeker.getNationalId().isEmpty()
				|| jobSeeker.getEmail().isEmpty() || jobSeeker.getPassword().isEmpty()
				|| jobSeeker.getFirstName().isBlank() || jobSeeker.getLastName().isBlank()
				|| jobSeeker.getPassword().isBlank()) {
			return new ErrorResult("Tüm alanlar doldurulmak zorundadır.");
		}
		
		if(this.jobSeekerDao.existsByEmail(jobSeeker.getEmail())==true)
			return new ErrorResult("Bu e posta sisteme kayıtlıdır");
		
		else if(this.jobSeekerDao.existsByNationalId(jobSeeker.getNationalId())==true) 
			return new ErrorResult("Bu nationalId sisteme kayıtlıdır");
		
		else if(!jobSeeker.getPassword().equals(jobSeeker.getPasswordRepeat())) 
			return new ErrorResult("Şifreler uyuşmuyor");
	
		if(!mernisService.checkMernis(jobSeeker.getFirstName(), jobSeeker.getLastName(), 
				jobSeeker.getNationalId(), jobSeeker.getBirthYear())) {
			return new ErrorResult("Doğrulama başarısız");
		}
			
		else {
			jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Güncelleme başarıyla gerçekleşti");
		}
	}
	//----------------------------------------------------------------------------------------------------

	@Override
	public DataResult<JobSeeker> getById(int id) {
	return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getOne(id));
	}

}
