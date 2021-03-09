package com.cg.healthreminder.services.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.DietInfoJpaDao;
import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.DietInfo;
import com.cg.healthreminder.services.DietInfoServices;

// Author --> Parth Goel

@Service
@Transactional
public class DietInfoServicesImpl implements DietInfoServices{
	
	@Autowired
	private DietInfoJpaDao dietInfoJpaDao;

	@Override
	public DietInfo findDietByBMI(Integer bmiValue) throws AllCustomException{
		DietInfo di = dietInfoJpaDao.findById(bmiValue).get();
		if(di == null) {
			throw new AllCustomException("Diet Information not found for the given Patient id");
		}
		return di;
	}

	@Override
	public Iterable<DietInfo> getAllDiets() {
		return dietInfoJpaDao.findAll();
	}

	@Override
	public DietInfo updateDietByBMI(Integer bmiValue, String dietInformation) throws AllCustomException{
		
		DietInfo dietInfo = dietInfoJpaDao.findById(bmiValue).get();
		if(dietInfo == null) {
			throw new AllCustomException("Diet Information not found for the given Patient id, so can't be updated");
		}
		else {
			dietInfo.setDietInfo(dietInformation);
		}
		return dietInfoJpaDao.save(dietInfo);
		
	}

	@Override
	public boolean deleteDietByBMI(Integer bmiValue) throws AllCustomException{
		
		DietInfo di = dietInfoJpaDao.findById(bmiValue).get();
		if(di == null) {
			throw new AllCustomException("Diet Information not found for the given Patient id, so can't be deleted");
		}
		else {
			dietInfoJpaDao.deleteById(bmiValue);
		}
		DietInfo dietInfo = dietInfoJpaDao.findById(bmiValue).get();
		if(null == dietInfo) {
			return true;
		}
		return false;
		
	}

	@Override
	public DietInfo createDiet(DietInfo dietInfo) {
		
		return dietInfoJpaDao.save(dietInfo);
	}

}
