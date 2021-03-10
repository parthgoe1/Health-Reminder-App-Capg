package com.cg.healthreminder.services.impl;

// Author: Naman Bhandari

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.MedicalHistoryDao;
import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.MedicalHistory;
import com.cg.healthreminder.services.MedicalHistoryService;

import javax.transaction.Transactional;
@Service
@Transactional
public class MedicalHistoryServiceImpl implements MedicalHistoryService{
	//Dao object created
	@Autowired
	private MedicalHistoryDao medicalHistoryDao;
	
	private String validateMedHistory(MedicalHistory m) {
		String msg;
		if(m.getPatientId()<0)
			msg="PatientId should be more than or equal to 0";
		else msg="Validated";
		return msg;
	}
	
	public List<MedicalHistory> getByPatientId(int id) throws AllCustomException{
		List<MedicalHistory> mhlst= medicalHistoryDao.findRecordsByPatientId(id);
		if(mhlst.size()>0) {
			return mhlst;
		}
		else {
			throw new AllCustomException("No records found");
		}
		
	}
	public MedicalHistory addRecord(MedicalHistory m) throws AllCustomException{
		String msg = validateMedHistory(m);
		if(msg.equals("Validated"))
		return medicalHistoryDao.save(m);
		else throw new AllCustomException(msg);
	}
	public void deleteRecord(String file) {
		medicalHistoryDao.deleteById(file);
	}
	public MedicalHistory updateRecord(MedicalHistory m) {
		return medicalHistoryDao.save(m);
	}
}
