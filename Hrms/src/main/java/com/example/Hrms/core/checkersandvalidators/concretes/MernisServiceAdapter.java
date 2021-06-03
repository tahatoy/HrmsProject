package com.example.Hrms.core.checkersandvalidators.concretes;


import org.springframework.stereotype.Service;

import com.example.Hrms.core.checkersandvalidators.abstracts.MernisService;

@Service
public class MernisServiceAdapter implements MernisService{

	@Override
	public boolean checkMernis(String nationalId, String firstName, String lastName,String birthYear) {
		if(firstName.length()<2 || lastName.length()<2 ) {
			System.out.println("Ad ve soyad 2 harften küçük olmamalıdır");
			return false;
		}
		if(nationalId.length()!=11 || nationalId.startsWith("0")) {
			System.out.println("NationalId 11 haneli olmalı ve 0 ile başlamamalıdır");
			return false;
		}
		
		else {
			System.out.println("Doğrulama başarılı");
			return true;
		}
		
		
	}

}
