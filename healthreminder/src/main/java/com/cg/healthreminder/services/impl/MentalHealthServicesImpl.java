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
	public mentalHealth displayTips(int mental_rating){
		return mentalDao.findById(mental_rating).get();
	}
	@Override
	public mentalHealth updateTips(int mental_rating, String uptips) {
		mentalHealth m = mentalDao.findById(mental_rating).get();
        m.setMental_tip(uptips);
        return mentalDao.save(m);
	}
	@Override
	public mentalHealth addTips(mentalHealth m) {
		return mentalDao.save(m);
		
	}
	@Override
	public boolean deleteTips(int mental_rating) {
		mentalDao.deleteById(mental_rating);
        mentalHealth m = mentalDao.findById(mental_rating).get();
        if(null == m){
            return true;
        }
        return false;
	}
}
