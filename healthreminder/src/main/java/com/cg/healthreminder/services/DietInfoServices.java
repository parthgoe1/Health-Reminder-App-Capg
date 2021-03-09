package com.cg.healthreminder.services;

import com.cg.healthreminder.exception.AllCustomExceptionHandler;
import com.cg.healthreminder.model.DietInfo;

//Author --> Parth Goel

public interface DietInfoServices {

	DietInfo findDietByBMI(Integer bmiValue) throws AllCustomExceptionHandler;
	Iterable<DietInfo> getAllDiets();
	DietInfo updateDietByBMI(Integer bmiValue, String dietInformation) throws AllCustomExceptionHandler;
	boolean deleteDietByBMI(Integer bmiValue) throws AllCustomExceptionHandler;
	DietInfo createDiet(DietInfo dietInfo);
	
}
