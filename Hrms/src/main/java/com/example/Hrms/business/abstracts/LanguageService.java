package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.Language;

public interface LanguageService {
	DataResult<List<Language>> getAll();
	DataResult<Language> get(int id);
	
	Result add(Language language);
	Result update(Language language);
	Result delete(int id);
	
}
