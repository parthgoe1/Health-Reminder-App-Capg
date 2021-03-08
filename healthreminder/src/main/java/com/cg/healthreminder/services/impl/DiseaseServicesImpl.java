package com.cg.healthreminder.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.DiseaseJpaDao;
import com.cg.healthreminder.model.Diseases;
import com.cg.healthreminder.services.DiseaseServices;

@Service
public class DiseaseServicesImpl implements DiseaseServices{
	@Autowired
	DiseaseJpaDao diseaseDao;
	@Override
	public Diseases viewDisease(int dis_id) {
		return diseaseDao.findById(dis_id).get();
	}
	@Override
	public Diseases updateDiseaseInfo(int dis_id, String content) {
		Diseases d = diseaseDao.findById(dis_id).get();
        d.setDis_info(content);
        return diseaseDao.save(d);
	}
	@Override
	public Diseases addDisease(Diseases d) {
		return diseaseDao.save(d);
		
	}
	@Override
	public boolean deleteDisease(int dis_id) {
		diseaseDao.deleteById(dis_id);
        Diseases d = diseaseDao.findById(dis_id).get();
        if(null == d){
            return true;
        }
        return false;
	}
}
