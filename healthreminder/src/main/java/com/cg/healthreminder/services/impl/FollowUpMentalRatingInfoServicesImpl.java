package com.cg.healthreminder.services.impl;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.healthreminder.dao.FollowUpMentalRatingInfoJpaDao;
import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.FollowUpMentalRatingInfo;
import com.cg.healthreminder.services.FollowUpMentalRatingInfoServices;

// Author --> Parth Goel

@Service
@Transactional
public class FollowUpMentalRatingInfoServicesImpl implements FollowUpMentalRatingInfoServices{
	
	@Autowired
	private FollowUpMentalRatingInfoJpaDao followUpMentalRatingInfoJpaDao;
	private static final Logger logger=LogManager.getLogger(FollowUpMentalRatingInfoServicesImpl.class);
	
	@Override
	public FollowUpMentalRatingInfo findMentalRatingById(Integer patientId) throws AllCustomException{

		logger.info("Finding follow up mental rating information by ID ........");
		Optional<FollowUpMentalRatingInfo> fumri = followUpMentalRatingInfoJpaDao.findById(patientId);
		FollowUpMentalRatingInfo fumri2 = null;
		if(fumri.isPresent()) {
			fumri2 = fumri.get();
		}
		else {
			throw new AllCustomException("Mental Rating Information not found for the given Patient id");
		}
		return fumri2;
	}

	@Override
	public FollowUpMentalRatingInfo updateMentalRatingById(Integer patientId, Integer mentalRating) throws AllCustomException{

		logger.info("Updating follow up mental rating information by ID ........");
		Optional<FollowUpMentalRatingInfo> followUpMentalRatingInfo = followUpMentalRatingInfoJpaDao.findById(patientId);
		FollowUpMentalRatingInfo fumri = null;
		if(followUpMentalRatingInfo.isPresent()) {
			fumri = followUpMentalRatingInfo.get();
			fumri.setMentalRating(mentalRating);
		}
		else {
			throw new AllCustomException("Mental Rating Information not found for the given Patient id, so can't be updated");

		}
		return followUpMentalRatingInfoJpaDao.save(fumri);
		
	}

	@Override
	public FollowUpMentalRatingInfo createMentalRating(FollowUpMentalRatingInfo followUpMentalRatingInfo) {
		
		logger.info("Creating follow up mental rating information ........");
		return followUpMentalRatingInfoJpaDao.save(followUpMentalRatingInfo);
	}


	@Override
	public boolean deleteMentalRating(Integer patientId) throws AllCustomException{
	
		logger.info("Deleting follow up mental rating information by ID ........");
		Optional<FollowUpMentalRatingInfo> fumri= followUpMentalRatingInfoJpaDao.findById(patientId);
		if(fumri.isPresent()) {
			followUpMentalRatingInfoJpaDao.deleteById(patientId);
		}
		else {
			throw new AllCustomException("Mental Rating Information not found for the given Patient id, so can't be deleted");
		}
		return true;
	}

}
