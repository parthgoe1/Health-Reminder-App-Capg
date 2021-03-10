/*
 * Author-> Shania Dalal
 * This class implements the MentalHealthServices interface
 * It accesses the Postgres DB to perform admin/user operations
 * 
*/
package com.cg.healthreminder.services.impl;

import com.cg.healthreminder.exception.AllCustomException;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthreminder.dao.MentalHealthJpaDao;
import com.cg.healthreminder.model.MentalHealth;
import com.cg.healthreminder.services.MentalHealthServices;

import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;
@Service
@Transactional
public class MentalHealthServicesImpl implements MentalHealthServices {
	@Autowired
	MentalHealthJpaDao mentalDao;
	
	@Override
	public MentalHealth displayTips(Integer mentalRating) throws AllCustomException{
		Optional<MentalHealth> m = mentalDao.findById(mentalRating);
		MentalHealth m2 = null;
		if(m.isPresent()) {
			m2 = m.get();
		}
		else {
			throw new AllCustomException("Health Rating Record not found for given ID");
		}
		return m2;
	}
	@Override
	public MentalHealth updateTips(Integer mentalRating, String uptips) throws AllCustomException{
		Optional<MentalHealth> m= mentalDao.findById(mentalRating);
		MentalHealth m2 = null;
		if(m.isPresent()) {
			m2 = m.get();
		}
		else {
			throw new AllCustomException("Health Rating not found for given ID, cannot update Tip");
		}
        m2.setMentalTip(uptips);
        return mentalDao.save(m2);
	}
	@Override
	public MentalHealth addTips(MentalHealth m) {
		return mentalDao.save(m);
		
	}
	@Override
	public boolean deleteTips(Integer mentalRating) throws AllCustomException{
		Optional<MentalHealth> m=mentalDao.findById(mentalRating);
		if(m.isPresent()) {
			mentalDao.deleteById(mentalRating);
		}
		else {
			throw new AllCustomException("Health Rating not found for given ID, cannot delete");
		}
		return true;
	}
	
}
