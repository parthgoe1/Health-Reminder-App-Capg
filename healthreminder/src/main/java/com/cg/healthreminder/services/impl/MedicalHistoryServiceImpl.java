package com.cg.healthreminder.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthreminder.dao.MedicalHistoryDao;
import com.cg.healthreminder.model.MedicalHistory;
import com.cg.healthreminder.services.MedicalHistoryService;

public class MedicalHistoryServiceImpl implements MedicalHistoryService{
	@Autowired
	private MedicalHistoryDao medicalHistoryDao;

	@Override
	public List<MedicalHistory> getRecords() {
		// TODO Auto-generated method stub
		return medicalHistoryDao.findAll();
	}

}
