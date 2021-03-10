/*
 * Author-> Shania Dalal
 * This is the Controller Class for performing operations on Diseases model using
 * URL Mapping
 * Operations in this class : viewing, updating diseaseInfo with id, and also adding new diseases
 */
package com.cg.healthreminder.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.Diseases;
import com.cg.healthreminder.services.DiseaseServices;

@RestController
@RequestMapping("/healthreminder")
@SuppressWarnings("rawtypes")
public class DiseaseController {
	
	@Autowired
	private DiseaseServices diseaseServices;
	
	@GetMapping("/viewDisease/{id}")
	public Diseases viewDisease(@PathVariable Integer id) throws AllCustomException{
		return this.diseaseServices.viewDisease(id);
	}
	
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/addDisease")
	public ResponseEntity addDisease(@RequestBody Diseases d) {
		this.diseaseServices.addDisease(d);
		return new ResponseEntity("Disease added successfully", HttpStatus.OK);
	}
	
	
	@SuppressWarnings("unchecked")
	@PostMapping("/updateDisease/{id}/{content}")
	public ResponseEntity updateDiseaseInfo(@PathVariable("id") Integer id, @PathVariable("content") String content) throws AllCustomException{
		this.diseaseServices.updateDiseaseInfo(id, content);
		return new ResponseEntity("Disease Information Updated successfully", HttpStatus.OK);

	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping(value="/deleteDisease/{id}")
	public ResponseEntity deleteDisease(@PathVariable Integer id) throws AllCustomException{
		this.diseaseServices.deleteDisease(id);
		return new ResponseEntity("Disease deleted successfully", HttpStatus.OK);
	}
	
	

}
