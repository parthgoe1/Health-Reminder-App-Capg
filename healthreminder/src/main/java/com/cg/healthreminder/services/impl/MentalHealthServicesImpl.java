//author->Shania Dalal
package com.cg.healthreminder.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthreminder.dao.MentalHealthJpaDao;
import com.cg.healthreminder.model.mentalHealth;
import com.cg.healthreminder.services.MentalHealthServices;

public class MentalHealthServicesImpl implements MentalHealthServices {
	@Autowired
	MentalHealthJpaDao mentalDao;
	
	@Override
	public mentalHealth displayTips(int mentalRating){
		return mentalDao.findById(mentalRating).get();
	}
	@Override
	public mentalHealth updateTips(int mentalRating, String uptips) {
		mentalHealth m = mentalDao.findById(mentalRating).get();
        m.setMentalTip(uptips);
        return mentalDao.save(m);
	}
	@Override
	public mentalHealth addTips(mentalHealth m) {
		return mentalDao.save(m);
		
	}
	@Override
	public boolean deleteTips(int mentalRating) {
		mentalDao.deleteById(mentalRating);
        mentalHealth m = mentalDao.findById(mentalRating).get();
        if(null == m){
            return true;
        }
        return false;
	}
}
