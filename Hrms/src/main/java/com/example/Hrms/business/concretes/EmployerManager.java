package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.EmployerService;
import com.example.Hrms.core.EmailService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.ErrorResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessDataResult;
import com.example.Hrms.core.utilities.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.EmployerDao;
import com.example.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao	empolyerDao;
	private EmailService emailService;
	
	public EmployerManager(EmployerDao empolyerDao,EmailService emailService) {
		super();
		this.empolyerDao = empolyerDao;
		this.emailService=emailService;
	}



	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.empolyerDao.findAll());
	}


	@Override
	public Result register(Employer employer) {
		if(this.empolyerDao.existsByEmail(employer.getEmail())==true)
			return new ErrorResult("Bu e posta sisteme kayıtlıdır.");
		else if(!employer.getPassword().equals(employer.getPasswordRepeat()))
			return new ErrorResult("Şifreler uyuşmuyor");
		else if(isEmailandWebsiteDomainSame(employer)==true)
			return new ErrorResult("Email adresiniz ile domaniniz aynı olmalıdır"); 
		
		emailService.send("E-posta gönderildi.");//E postanın gönderilip onaylandığı simule edildi
		employer.setEmailVerify(true);
		
		if(employer.isEmailVerify()==true)
			this.empolyerDao.save(employer);
		
		return new SuccessResult("Kayıt başarılı");
		
	}
	
	
	private boolean isEmailandWebsiteDomainSame(Employer employer) {
		String email = employer.getEmail();
		String[] emailSplit = email.split("@");
		if(!emailSplit[1].equals(employer.getWebsite())) 
			return false;
		return true;
	}
	

}
