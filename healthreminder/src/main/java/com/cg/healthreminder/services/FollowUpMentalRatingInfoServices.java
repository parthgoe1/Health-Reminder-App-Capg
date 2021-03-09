package com.cg.healthreminder.services;

import com.cg.healthreminder.model.FollowUpMentalRatingInfo;

//Author --> Parth Goel
public interface FollowUpMentalRatingInfoServices {

	FollowUpMentalRatingInfo findMentalRatingById(Integer patientId);
	FollowUpMentalRatingInfo updateMentalRatingById(Integer patientId, Integer mentalRating);
	FollowUpMentalRatingInfo createMentalRating(FollowUpMentalRatingInfo followUpMentalRatingInfo);
	boolean deleteMentalRating(Integer patientId);
}
