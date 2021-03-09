package com.cg.healthreminder.services.impl;

import java.util.Optional;

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
<<<<<<< HEAD
		Optional<DietInfo> di = dietInfoJpaDao.findById(bmiValue);
		DietInfo di2 = null;
		if(di.isPresent()) {
			di2 = di.get();
		}
		else {
=======
		DietInfo di = dietInfoJpaDao.findById(bmiValue).get();
		if(di == null) {
>>>>>>> 461dc30193bb505bdb963c002fb4d898594f0636
			throw new AllCustomException("Diet Information not found for the given Patient id");
		}
		return di2;
	}

	@Override
	public Iterable<DietInfo> getAllDiets() {
		return dietInfoJpaDao.findAll();
	}

	@Override
	public DietInfo updateDietByBMI(Integer bmiValue, String dietInformation) throws AllCustomException{
		
<<<<<<< HEAD
		Optional<DietInfo> dietInfo = dietInfoJpaDao.findById(bmiValue);
		DietInfo di2 = null;
		if(dietInfo.isPresent()) {
			di2 = dietInfo.get();
			di2.setDietInfo(dietInformation);
=======
		DietInfo dietInfo = dietInfoJpaDao.findById(bmiValue).get();
		if(dietInfo == null) {
			throw new AllCustomException("Diet Information not found for the given Patient id, so can't be updated");
>>>>>>> 461dc30193bb505bdb963c002fb4d898594f0636
		}
		else {
			throw new AllCustomException("Diet Information not found for the given Patient id, so can't be updated");
		}
		return dietInfoJpaDao.save(di2);
		
	}

	@Override
	public boolean deleteDietByBMI(Integer bmiValue) throws AllCustomException{
		
<<<<<<< HEAD
		Optional<DietInfo> di = dietInfoJpaDao.findById(bmiValue);
		DietInfo di2 = null;
		if(di.isPresent()) {
			di2 = di.get();
			dietInfoJpaDao.deleteById(bmiValue);
=======
		DietInfo di = dietInfoJpaDao.findById(bmiValue).get();
		if(di == null) {
			throw new AllCustomException("Diet Information not found for the given Patient id, so can't be deleted");
>>>>>>> 461dc30193bb505bdb963c002fb4d898594f0636
		}
		else {
			throw new AllCustomException("Diet Information not found for the given Patient id, so can't be deleted");	
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
