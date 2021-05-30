package com.example.Hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Hrms.business.abstracts.JobService;
import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.core.utilities.SuccessDataResult;
import com.example.Hrms.core.utilities.SuccessResult;
import com.example.Hrms.dataAccess.abstracts.JobDao;
import com.example.Hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		 return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "İşler başarıyla listelendi");
	}

	@Override
	public Result add(Job job) {
		this.jobDao.save(job);
		return new SuccessResult("İşlem başarılı");
	}

	  @Override
	    public DataResult<List<Job>> findAllByActiveTrue() {
	        return new SuccessDataResult<List<Job>>(this.jobDao.findAllByActiveTrue(), "Aktif işler başarıyla listelendi.");
	    }

	    @Override
	    public DataResult<List<Job>> findAllByEmployerIdAndActiveTrue(int employerId) {
	        return new SuccessDataResult<List<Job>>(this.jobDao.findAllByEmployer_IdAndActiveTrue(employerId), "İşverenlere göre işler listelendi.");
	    }

	    @Override
	    public DataResult<List<Job>> findAllByActiveTrueOrderByCreatedTimeDesc() {
	        return new SuccessDataResult<List<Job>>(this.jobDao.findAllByActiveTrueOrderByCreatedTimeDesc(), "Oluşturma zamanına göre işler listelendi.");
	    }

	    @Override
	    public Result setValue(int id, boolean value) {
	        Job job = this.jobDao.findByIdAndActiveTrue(id);
	        job.setActive(value);
	        this.jobDao.save(job);
	        return new SuccessResult("Value setted to " + value + " successfully.");
	    }
	}
