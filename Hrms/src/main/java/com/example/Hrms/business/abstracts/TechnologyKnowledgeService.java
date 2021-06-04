package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.TechnologyKnowledge;

public interface TechnologyKnowledgeService {

	DataResult<List<TechnologyKnowledge>> getAll();
	DataResult<TechnologyKnowledge> get(int id);
	
	Result add(TechnologyKnowledge technologyKnowledge);
	Result update(TechnologyKnowledge technologyKnowledge);
	Result delete(int id);
}
