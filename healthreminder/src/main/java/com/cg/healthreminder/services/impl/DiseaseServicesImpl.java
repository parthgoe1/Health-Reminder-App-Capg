/*
 * Author-> Shania Dalal
 * This class implements the DiseasesServices interface
 * It accesses the Postgres DB to perform admin/user operations
 * 
*/
package com.cg.healthreminder.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.DiseaseJpaDao;
import com.cg.healthreminder.exception.AllCustomExceptionHandler;
import com.cg.healthreminder.model.Diseases;
import com.cg.healthreminder.services.DiseaseServices;

@Service
@Transactional
public class DiseaseServicesImpl implements DiseaseServices{
	@Autowired
	DiseaseJpaDao diseaseDao;
	
	@Override
	public Diseases viewDisease(Integer diseaseId) throws AllCustomExceptionHandler {
		Diseases d= diseaseDao.findById(diseaseId).get();
		if(d==null) {
			throw new AllCustomExceptionHandler("Disease not found for given ID");
		}
		return d;
	}
	@Override
	public Diseases updateDiseaseInfo(Integer diseaseId, String content) throws AllCustomExceptionHandler{
		Diseases d = diseaseDao.findById(diseaseId).get();
		if(d==null) {
			throw new AllCustomExceptionHandler("Disease not found for given ID, cannot update Info.");
		}
        d.setDiseaseInfo(content);
        return diseaseDao.save(d);
	}
	
	@Override
	public Diseases addDisease(Diseases d) {
		return diseaseDao.save(d);
		
	}

}