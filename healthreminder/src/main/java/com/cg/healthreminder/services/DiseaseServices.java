/*
 * Author-> Shania Dalal
 * This is the Interface that defines the functions to be performed on the Diseases model
 * 
 * 
*/
package com.cg.healthreminder.services;

import com.cg.healthreminder.exception.AllCustomExceptionHandler;
import com.cg.healthreminder.model.Diseases;

public interface DiseaseServices {
	public Diseases viewDisease(Integer diseaseId) throws AllCustomExceptionHandler;
	public Diseases updateDiseaseInfo(Integer diseaseId, String content) throws AllCustomExceptionHandler;
	public Diseases addDisease(Diseases d);
}
