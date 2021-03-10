/*
 * Author-> Shania Dalal
 * This class implements the DiseasesServices interface
 * It accesses the Postgres DB to perform admin/user operations
 * 
*/
package com.cg.healthreminder.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.DiseaseJpaDao;
import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.Diseases;
import com.cg.healthreminder.services.DiseaseServices;

@Service
@Transactional
public class DiseaseServicesImpl implements DiseaseServices{
	@Autowired
	private DiseaseJpaDao diseaseDao;
	
	@Override
	public Diseases viewDisease(Integer diseaseId) throws AllCustomException {
		Optional<Diseases> d= diseaseDao.findById(diseaseId);
		Diseases d2 = null;
		if(d.isPresent()) {
			d2 = d.get();
		}
		else {
			throw new AllCustomException("Disease not found for given ID");
		}
		return d2;
	}
	@Override
	public Diseases updateDiseaseInfo(Integer diseaseId, String content) throws AllCustomException{
		Optional<Diseases> d= diseaseDao.findById(diseaseId);
		Diseases d2 = null;
		if(d.isPresent()) {
			d2 = d.get();
		}
		else {
			throw new AllCustomException("Disease not found for given ID, cannot update Info.");
		}
        d2.setDiseaseInfo(content);
        return diseaseDao.save(d2);
	}
	
	@Override
	public Diseases addDisease(Diseases d) {
		return diseaseDao.save(d);
		
	}
	@Override
	public boolean deleteDisease(Integer diseaseId) throws AllCustomException{
		Optional<Diseases> m=diseaseDao.findById(diseaseId);
		if(m.isPresent()) {
			diseaseDao.deleteById(diseaseId);
		}
		else {
			throw new AllCustomException("Disease not found for given ID, cannot delete");
		}
		return true;
	}

}