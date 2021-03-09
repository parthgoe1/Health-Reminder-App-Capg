package com.cg.healthreminder.services;

// Author: Naman Bhandari

import java.util.List;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.Patient;

public interface PatientService {
	public List<Patient> getAllPatients();
	public Patient getPatient(int id) throws AllCustomException;
	public void addPatient(Patient p);
	public Patient updatePatient(Patient p);
	public void deletePatientById(int id);
}
