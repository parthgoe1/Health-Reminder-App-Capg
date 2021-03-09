package com.cg.healthreminder.services.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.DietInfoJpaDao;
import com.cg.healthreminder.model.DietInfo;
import com.cg.healthreminder.services.DietInfoServices;

// Author --> Parth Goel

@Service
@Transactional
public class DietInfoServicesImpl implements DietInfoServices{
	
	@Autowired
	private DietInfoJpaDao dietInfoJpaDao;

	@Override
	public DietInfo findDietByBMI(Integer bmiValue) {
		return dietInfoJpaDao.findById(bmiValue).get();
	}

	@Override
	public Iterable<DietInfo> getAllDiets() {
		return dietInfoJpaDao.findAll();
	}

	@Override
	public DietInfo updateDietByBMI(Integer bmiValue, String dietInformation) {
		
		DietInfo dietInfo = dietInfoJpaDao.findById(bmiValue).get();
		dietInfo.setDietInfo(dietInformation);
		return dietInfoJpaDao.save(dietInfo);
		
	}

	@Override
	public boolean deleteTicketByBMI(Integer bmiValue) {
		
		dietInfoJpaDao.deleteById(bmiValue);
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
