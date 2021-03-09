package com.cg.healthreminder.services;

import com.cg.healthreminder.exception.AllCustomExceptionHandler;
import com.cg.healthreminder.model.FollowUpDietStatusInfo;

//Author --> Parth Goel

public interface FollowUpDietStatusInfoServices {
	
	FollowUpDietStatusInfo findDietStatusById(Integer patientId) throws AllCustomExceptionHandler;
	FollowUpDietStatusInfo updateDietStatusById(Integer patientId, Boolean dietStatus) throws AllCustomExceptionHandler;
	FollowUpDietStatusInfo createDietStatus(FollowUpDietStatusInfo followUpDietStatusInfo);
	boolean deleteDietStatus(Integer patientId) throws AllCustomExceptionHandler;

}
