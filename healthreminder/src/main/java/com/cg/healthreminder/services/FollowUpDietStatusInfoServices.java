package com.cg.healthreminder.services;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.FollowUpDietStatusInfo;

//Author --> Parth Goel

public interface FollowUpDietStatusInfoServices {
	
	FollowUpDietStatusInfo findDietStatusById(Integer patientId) throws AllCustomException;
	FollowUpDietStatusInfo updateDietStatusById(Integer patientId, Boolean dietStatus) throws AllCustomException;
	FollowUpDietStatusInfo createDietStatus(FollowUpDietStatusInfo followUpDietStatusInfo);
	boolean deleteDietStatus(Integer patientId) throws AllCustomException;

}
