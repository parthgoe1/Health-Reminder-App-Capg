package com.cg.healthreminder.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.PatientDao;
import com.cg.healthreminder.model.Patient;
import com.cg.healthreminder.services.PatientService;
@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	private PatientDao patientDao;
	
	public List<Patient> getAllPatients(){
		return patientDao.findAll();
	}
	
	public Patient getPatient(int id) {
		return patientDao.findById(id).orElse(new Patient());
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
