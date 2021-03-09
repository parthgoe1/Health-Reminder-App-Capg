package com.cg.healthreminder.services;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.DietInfo;

//Author --> Parth Goel

public interface DietInfoServices {

	DietInfo findDietByBMI(Integer bmiValue) throws AllCustomException;
	Iterable<DietInfo> getAllDiets();
	DietInfo updateDietByBMI(Integer bmiValue, String dietInformation) throws AllCustomException;
	boolean deleteDietByBMI(Integer bmiValue) throws AllCustomException;
	DietInfo createDiet(DietInfo dietInfo);
	
}
