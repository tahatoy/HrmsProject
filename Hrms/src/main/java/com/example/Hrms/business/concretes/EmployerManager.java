package com.example.Hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.ConfirmBySystemUserService;
import com.example.Hrms.business.abstracts.EmployerService;
import com.example.Hrms.core.checkersandvalidators.abstracts.VerificationService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.ErrorResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessDataResult;
import com.example.Hrms.core.utilities.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.EmployerDao;
import com.example.Hrms.entities.concretes.Employer;
import com.example.Hrms.entities.concretes.Verification;
import com.example.Hrms.entities.dtos.EmployerRegisterDto;


@Service
public class EmployerManager implements EmployerService {

	private EmployerDao	employerDao;
	private ModelMapper modelMapper;
	private VerificationService verificationService;
	private ConfirmBySystemUserService confirmBySystemUserService;
	
	@Autowired
	public EmployerManager(EmployerDao empolyerDao, ModelMapper modelMapper,
			VerificationService verificationService,ConfirmBySystemUserService confirmBySystemUserService) {
		super();
		this.employerDao = empolyerDao;
		this.modelMapper = modelMapper;
		this.verificationService = verificationService;
		this.confirmBySystemUserService=confirmBySystemUserService;
	}


	
//---------------------------------------------------------------------------------------------------------	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

//---------------------------------------------------------------------------------------------------------	
	@Override
	public Result register(EmployerRegisterDto employerRegisterDto) {
		
		Employer employer=this.modelMapper.map(employerRegisterDto, Employer.class);
	
		if(employer.getCompanyName().isEmpty() || employer.getWebsite().isEmpty()
				|| employer.getPhoneNumber().isEmpty() || employer.getEmail().isEmpty() 
				|| employer.getPassword().isEmpty() || employer.getWebsite().isBlank() 
				|| employer.getPassword().isBlank()) {
			return new ErrorResult("Tüm alanlar doldurulmalıdır");
		}
		
		String email = employer.getEmail();
		String[] emailSplit = email.split("@");
		if(!employer.getWebsite().contains(emailSplit[0]))  {
            return new ErrorResult("Email ve domaininiz aynı olmalıdır");
        }
        
        if(employerDao.existsByEmail(employer.getEmail())==true) {
        	return new ErrorResult("Bu email sistem kayıtlıdır");
        }
        
        if(employerDao.existsByWebsite(employer.getWebsite())==true) {
        	return new ErrorResult("Bu website sistemde kayıtlıdır");
        }
        
        if(employerDao.existsByPhoneNumber(employer.getPhoneNumber())==true) {
        	return new ErrorResult("Bu telefon numarası sistemde kayıtlıdır");
        }
        
         
        else {
        	employer.setStatus(false); 
			this.employerDao.save(employer);
			String code = verificationService.verifyCode(); //Kullanıcı oluştuktan sonra status kısmı otamtik false olur hesabına doğrulama kodu gönderilir.
			verificationCode(code, employer.getId(), employer.getEmail()); //Doğrulama kodu gönderildikten onaylarsa status true durumuna döner.
			return new SuccessResult("Kayıt işlemi başarıyla gerçekleşti");
		}
	}
	
	
	@Override
	public Result emailVerification(Employer employer, String activationCode) {
		if(activationCode == null) {
			return new ErrorResult("Boş olamaz");
		}
		else if(!activationCode.equals(verificationService.verifyCode())) {
			return new ErrorResult("Doğrulama kodu hatalı");
		}
		
		Employer employers=getById(employer.getId()).getData();
		if(this.employerDao.findById(employers.getId())==null) {
			return new ErrorResult("Mevcut değil");
		}
		else {
			employer.setStatus(true);
			return new SuccessResult("Email doğrulaması başarılı");
		}
	}
	
	
	
    public void verificationCode(String code, int id, String email) {
		Verification verificationCode = new Verification(id, code, false, LocalDateTime.now());
		this.verificationService.save(verificationCode);
	}
    
    
    @Override
	public Result confirmBySystemUser(Employer employer) {
		if(!confirmBySystemUserService.isConfirmedBySystemUser(employer)) {
			return new ErrorResult("Tamamlanabilmesi için sistem personelinin onayı gereklidir");
		}
		else {
		  return new SuccessResult("Sistem personeli tarafından onaylanma tamamlandı");
		}
	}
    
 //---------------------------------------------------------------------------------------------------------------
	@Override
	public Result update(Employer employer, int id) {
		Employer employers = getById(id).getData();
		if(employer.getCompanyName().isEmpty() || employer.getWebsite().isEmpty()
				|| employer.getPhoneNumber().isEmpty() || employer.getEmail().isEmpty() 
				|| employer.getPassword().isEmpty() || employer.getWebsite().isBlank() 
				|| employer.getPassword().isBlank()) {
			return new ErrorResult("Tüm alanlar doldurulmalıdır");
		}
		
		String email = employer.getEmail();
		String[] emailSplit = email.split("@");
		if(!employer.getWebsite().contains(emailSplit[0]))  {
            return new ErrorResult("Email ve domaininiz aynı olmalıdır");
        }
        
        if(employerDao.existsByEmail(employer.getEmail())==true) {
        	return new ErrorResult("Bu email sistemde kayıtlıdır");
        }
        
        if(employerDao.existsByWebsite(employer.getWebsite())==true) {
        	return new ErrorResult("Bu website sistemde kayıtlıdır");
        }
        
        if(employerDao.existsByPhoneNumber(employer.getPhoneNumber())==true) {
        	return new ErrorResult("Bu telefon numarası sistemde kayıtlıdır");
        }
        
        else {
			this.employerDao.save(employer);
			return new SuccessResult("Kayıt işlemi başarıyla gerçekleşti");
        }
	}

//------------------------------------------------------------------------------------------------------------------
	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getOne(id));
	}



	

}
