package com.cg.healthreminder.services.impl;

// Author: Naman Bhandari

import java.util.*;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.PatientDao;
import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.Patient;
import com.cg.healthreminder.services.PatientService;


import javax.transaction.Transactional;
@Service
@Transactional
public class PatientServiceImpl implements PatientService{
	
	//Dao object created
	@Autowired
	private PatientDao patientDao;
	
	private String validatePatientData(Patient p) {
		String msg;
		if(p.getPatientId()<0)
			msg="PatientId should be more than or equal to 0";
		else if(!Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$").matcher(p.getPatientEmail()).matches())
			msg="Email format not correct";
		else if(!Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z]+)?$").matcher(p.getPatientName()).matches())
			msg="Name should only contain alphabets";
		else if(p.getPatientMobile()!=null && (p.getPatientMobile().length()!=10 || p.getPatientMobile().matches(".*[a-zA-Z]+.*")))
			msg="Mobile number should be only 10 digits";
		else if(p.getPatientAge()!=null && p.getPatientAge()<=0)
			msg="Age should be more than 0";
		else if(p.getPatientHeight()!=null && p.getPatientHeight()<=0)
			msg="Height should be more than 0";
		else if(p.getPatientWeight()!=null && p.getPatientWeight()<=0)
			msg="Weight should be more than 0";
		else msg="Validated";
		return msg;
	}
	
	public List<Patient> getAllPatients(){
		return patientDao.findAll();
	}
	
	public Patient getPatient(int id) throws AllCustomException{
		Optional<Patient> p= patientDao.findById(id);
		Patient ans;
		if(p.isPresent()) {
			ans=p.get();
			return ans;
		}
		else {
			throw new AllCustomException("Patient not found");
		}
	}
	public Patient addPatient(Patient p) throws AllCustomException{
		String msg = validatePatientData(p);
		if(msg.equals("Validated"))
		return patientDao.save(p);
		else  throw new AllCustomException(msg);
	}

	@Override
	public Patient updatePatient(Patient p) {
		return patientDao.save(p);
	}

	@Override
	public Integer deletePatientById(int id) {
		 patientDao.deleteById(id);
		 return id;
		 
	}
}
