/*
 * Author-> Shania Dalal
 * This is the Controller Class for performing operations on mentalHealth model using
 * URL Mapping
 * Operations in this class : viewing, updating mentalRating with id, and also adding new mentalRating
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
import com.cg.healthreminder.model.MentalHealth;
import com.cg.healthreminder.services.MentalHealthServices;

@RestController
@RequestMapping("/healthreminder")
@SuppressWarnings("rawtypes")
public class MentalHealthController {
	
	@Autowired
	private MentalHealthServices mentalServices;
	
	@GetMapping("/viewTips/{id}")
	public MentalHealth displayTips(@PathVariable Integer id) throws AllCustomException{
		return this.mentalServices.displayTips(id);
	}
	
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/addTips")
	public ResponseEntity addTips(@RequestBody MentalHealth h) {
		this.mentalServices.addTips(h);
		return new ResponseEntity("Tip added successfully", HttpStatus.OK);
	}
	
	
	@SuppressWarnings("unchecked")
	@PostMapping("/updateTips/{id}/{content}")
	public ResponseEntity updateTips(@PathVariable("id") Integer id, @PathVariable("content") String content) throws AllCustomException{
		this.mentalServices.updateTips(id, content);
		return new ResponseEntity("Health Tip Updated successfully", HttpStatus.OK);

	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/deleteTips/{id}")
	public ResponseEntity deleteTips(@PathVariable Integer id) throws AllCustomException{
		this.mentalServices.deleteTips(id);
		return new ResponseEntity("Health Tip deleted successfully", HttpStatus.OK);

	}
}
