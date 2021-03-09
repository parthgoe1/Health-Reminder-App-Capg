/*
 * Author-> Shania Dalal
 * This class implements the MentalHealthServices interface
 * It accesses the Postgres DB to perform admin/user operations
 * 
*/
package com.cg.healthreminder.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthreminder.dao.MentalHealthJpaDao;
import com.cg.healthreminder.model.mentalHealth;
import com.cg.healthreminder.services.MentalHealthServices;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@Transactional
public class MentalHealthServicesImpl implements MentalHealthServices {
	@Autowired
	MentalHealthJpaDao mentalDao;
	
	@Override
	public mentalHealth displayTips(Integer mentalRating){
		return mentalDao.findById(mentalRating).get();
	}
	@Override
	public mentalHealth updateTips(Integer mentalRating, String uptips) {
		mentalHealth m = mentalDao.findById(mentalRating).get();
        m.setMentalTip(uptips);
        return mentalDao.save(m);
	}
	@Override
	public mentalHealth addTips(mentalHealth m) {
		return mentalDao.save(m);
		
	}
	
}
