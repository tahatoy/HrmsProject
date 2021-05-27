package com.example.Hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.JobSeekerService;
import com.example.Hrms.core.EmailService;
import com.example.Hrms.core.IdentityValidationService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.ErrorResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessDataResult;
import com.example.Hrms.core.utilities.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.JobSeekerDao;
import com.example.Hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private IdentityValidationService identityValidationService;
	private EmailService emailService;
	

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, IdentityValidationService identityValidationService,EmailService emailService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.identityValidationService = identityValidationService;
		this.emailService=emailService;
	}




	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}




	@Override
	public Result register(JobSeeker jobSeeker) {
		if(this.jobSeekerDao.existsByEmail(jobSeeker.getEmail())==true)
			return new ErrorResult("Bu e posta sisteme kayıtlıdır");
		
		else if(this.jobSeekerDao.existsByNationalId(jobSeeker.getNationalId())==true) 
			return new ErrorResult("Bu nationalId sisteme kayıtlıdır");
		
		else if(!jobSeeker.getPassword().equals(jobSeeker.getPasswordRepeat())) 
			return new ErrorResult("Şifreler uyuşmuyor.");
		
		if(!identityValidationService.validate( //mernis validasyonu simule edildi
				jobSeeker.getNationalId(),
				jobSeeker.getFirstName(),
				jobSeeker.getLastName()).isSuccess()) {
			return new ErrorResult("Mernis doğrulaması başarısız");
		}
		
			
			emailService.send("E-posta gönderildi.");
			jobSeeker.setVerify(true);// e postanın doğrulandığı simule edildi
			
			if(jobSeeker.isVerify()==true)
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Kayıt başarılı.");
		
	
	
	}


}
