package com.cg.healthreminder.services;

import com.cg.healthreminder.model.FollowUpDietStatusInfo;

//Author --> Parth Goel

public interface FollowUpDietStatusInfoServices {
	
	FollowUpDietStatusInfo findDietStatusById(Integer patientId);
	FollowUpDietStatusInfo updateDietStatusById(Integer patientId, Boolean dietStatus);
	FollowUpDietStatusInfo createDietStatus(FollowUpDietStatusInfo followUpDietStatusInfo);
	boolean deleteDietStatus(Integer patientId);

}
