package com.cg.healthreminder.services.impl;

// Author: Naman Bhandari

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.PatientDao;
import com.cg.healthreminder.exception.AllCustomExceptionHandler;
import com.cg.healthreminder.model.Patient;
import com.cg.healthreminder.services.PatientService;


import javax.transaction.Transactional;
@Service
@Transactional
public class PatientServiceImpl implements PatientService{
	
	//Dao object created
	@Autowired
	private PatientDao patientDao;
	
	public List<Patient> getAllPatients(){
		return patientDao.findAll();
	}
	
	public Patient getPatient(int id) throws AllCustomExceptionHandler{
		Optional<Patient> p= patientDao.findById(id);
		Patient ans;
		if(p.isPresent()) {
			ans=p.get();
			return ans;
		}
		else {
			throw new AllCustomExceptionHandler("Patient not found");
		}
	}
	public void addPatient(Patient p) {
		patientDao.save(p);
	}

	@Override
	public Patient updatePatient(Patient p) {
		// TODO Auto-generated method stub
		return patientDao.save(p);
	}

	@Override
	public void deletePatientById(int id) {
		// TODO Auto-generated method stub
		patientDao.deleteById(id);
	}
}
