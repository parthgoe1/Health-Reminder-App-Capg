package com.cg.healthreminder.controller;

// Author: Naman Bhandari

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.MedicalHistory;
import com.cg.healthreminder.services.MedicalHistoryService;

@RestController
@RequestMapping("/healthreminder")
public class MedicalHistoryController {
	@Autowired
	private MedicalHistoryService medicalHistoryService;
	
	//To get all records for a patient 
	@GetMapping("/records/{id}")
	public List<MedicalHistory> getByPatientId(@PathVariable int id) throws AllCustomException{
		return this.medicalHistoryService.getByPatientId(id);
	}
	
	//To add a new record
	@PostMapping("/addrecord")
	public void addRecord(MedicalHistory m){
		this.medicalHistoryService.addRecord(m);
	}
	
	//To delete a particular record
	@DeleteMapping("/delrecord")
	public void delRecord(String file) {
		this.medicalHistoryService.deleteRecord(file);
	}
	
	//To update a record
	@PutMapping("/record")
	public MedicalHistory updateRecord(MedicalHistory m) {
		return this.medicalHistoryService.updateRecord(m);
	}
}
