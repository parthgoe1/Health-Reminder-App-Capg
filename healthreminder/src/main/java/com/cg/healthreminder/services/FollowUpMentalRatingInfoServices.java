package com.cg.healthreminder.services;

import com.cg.healthreminder.exception.AllCustomExceptionHandler;
import com.cg.healthreminder.model.FollowUpMentalRatingInfo;

//Author --> Parth Goel
public interface FollowUpMentalRatingInfoServices {

	FollowUpMentalRatingInfo findMentalRatingById(Integer patientId) throws AllCustomExceptionHandler;
	FollowUpMentalRatingInfo updateMentalRatingById(Integer patientId, Integer mentalRating) throws AllCustomExceptionHandler;
	FollowUpMentalRatingInfo createMentalRating(FollowUpMentalRatingInfo followUpMentalRatingInfo);
	boolean deleteMentalRating(Integer patientId) throws AllCustomExceptionHandler;
}
