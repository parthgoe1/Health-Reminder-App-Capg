package com.cg.healthreminder.services;

import com.cg.healthreminder.model.DietInfo;

//Author --> Parth Goel

public interface DietInfoServices {

	DietInfo findDietByBMI(Integer bmiValue);
	Iterable<DietInfo> getAllDiets();
	DietInfo updateDietByBMI(Integer bmiValue, String dietInformation);
	boolean deleteDietByBMI(Integer bmiValue);
	DietInfo createDiet(DietInfo dietInfo);
	
}
