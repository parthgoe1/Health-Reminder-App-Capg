package com.cg.healthreminder.services.impl;

// Author: Naman Bhandari

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.MedicalHistoryDao;
import com.cg.healthreminder.model.MedicalHistory;
import com.cg.healthreminder.services.MedicalHistoryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@Transactional
public class MedicalHistoryServiceImpl implements MedicalHistoryService{
	//Dao object created
	@Autowired
	private MedicalHistoryDao medicalHistoryDao;
	
	
	public List<MedicalHistory> getByPatientId(int id){
		return medicalHistoryDao.findRecordsByPatientId(id);
	}
	public void addRecord(MedicalHistory m) {
		medicalHistoryDao.save(m);
	}
	public void deleteRecord(String file) {
		medicalHistoryDao.deleteById(file);
	}
	public MedicalHistory updateRecord(MedicalHistory m) {
		return medicalHistoryDao.save(m);
	}
}
