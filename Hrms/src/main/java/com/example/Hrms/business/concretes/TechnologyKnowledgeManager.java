package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.TechnologyKnowledgeService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessDataResult;
import com.example.Hrms.core.utilities.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.TechnologyKnowledgeDao;
import com.example.Hrms.entities.concretes.TechnologyKnowledge;

@Service
public class TechnologyKnowledgeManager implements TechnologyKnowledgeService{

	private TechnologyKnowledgeDao technologyKnowledgeDao;
	
	@Autowired
	public TechnologyKnowledgeManager(TechnologyKnowledgeDao technologyKnowledgeDao) {
		super();
		this.technologyKnowledgeDao = technologyKnowledgeDao;
	}

	@Override
	public DataResult<List<TechnologyKnowledge>> getAll() {
		return new SuccessDataResult<List<TechnologyKnowledge>>(this.technologyKnowledgeDao.findAll());
	}

	@Override
	public DataResult<TechnologyKnowledge> get(int id) {
		return new SuccessDataResult<TechnologyKnowledge>(this.technologyKnowledgeDao.findById(id).get());
	}

	@Override
	public Result add(TechnologyKnowledge technologyKnowledge) {
		this.technologyKnowledgeDao.save(technologyKnowledge);
		return new SuccessResult("Başarıyla kaydedildi");
	}

	@Override
	public Result update(TechnologyKnowledge technologyKnowledge) {
		this.technologyKnowledgeDao.save(technologyKnowledge);
		return new SuccessResult("Başarıyla kaydedildi");
	}

	@Override
	public Result delete(int id) {
		this.technologyKnowledgeDao.deleteById(id);
		return new SuccessResult("Başarıyla silindi");
	}

}
