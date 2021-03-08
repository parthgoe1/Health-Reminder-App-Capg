package com.cg.healthreminder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthreminder.model.Patient;
import com.cg.healthreminder.services.PatientService;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;
	@GetMapping("/patients")
	public List<Patient> getPatients(){
		return this.patientService.getAllPatients();
	}
	@GetMapping("/patient/{id}")
	public Patient getPatient(@PathVariable int id) {
		return this.patientService.getPatient(id);
	}
	@PostMapping("/patient")
	public void addPatient(@RequestParam Patient p) {
		this.patientService.addPatient(p);
	}
	@PutMapping("/patient")
	public Patient updatePatient(@RequestParam Patient p) {
		return this.patientService.updatePatient(p);
	}
	@DeleteMapping("/patient/{id}")
	public void deletePatient(@PathVariable int id) {
		this.patientService.deletePatientById(id);
	}
}
