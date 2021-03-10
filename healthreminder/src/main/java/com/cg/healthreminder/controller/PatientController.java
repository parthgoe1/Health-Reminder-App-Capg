package com.cg.healthreminder.controller;

// Author: Naman Bhandari

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.Patient;
import com.cg.healthreminder.services.PatientService;

@RestController
@RequestMapping("/healthreminder")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	//To find list of all patients
	@GetMapping("/patients")
	public List<Patient> getPatients(){
		return this.patientService.getAllPatients();
	}
	
	//To find a particular patient details using its id
	@GetMapping("/patient/{id}")
	public Patient getPatient(@PathVariable int id) throws AllCustomException{
		return this.patientService.getPatient(id);
	}
	
	//To add new patient
	@PostMapping("/patient")
	public Patient addPatient(Patient p) {
		return this.patientService.addPatient(p);
	}
	
	//To update patient details
	@PutMapping("/patient")
	public Patient updatePatient(Patient p) {
		return this.patientService.updatePatient(p);
	}
	
	//To delete a patient
	@DeleteMapping("/patient/{id}")
	public void deletePatient(@PathVariable int id) {
		this.patientService.deletePatientById(id);
	}
}
