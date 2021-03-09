//author->Shania Dalal
package com.cg.healthreminder.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.DiseaseJpaDao;
import com.cg.healthreminder.model.Diseases;
import com.cg.healthreminder.services.DiseaseServices;

@Service
@Transactional
public class DiseaseServicesImpl implements DiseaseServices{
	@Autowired
	DiseaseJpaDao diseaseDao;
	
	@Override
	public Diseases viewDisease(Integer diseaseId) {
		return diseaseDao.findById(diseaseId).get();
	}
	@Override
	public Diseases updateDiseaseInfo(Integer diseaseId, String content) {
		Diseases d = diseaseDao.findById(diseaseId).get();
        d.setDiseaseInfo(content);
        return diseaseDao.save(d);
	}
	
	@Override
	public Diseases addDisease(Diseases d) {
		return diseaseDao.save(d);
		
	}

}