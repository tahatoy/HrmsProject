package com.example.Hrms.business.abstracts;

import java.util.List;

import com.example.Hrms.core.utilities.DataResult;
import com.example.Hrms.core.utilities.Result;
import com.example.Hrms.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
	Result add(City city);
}
