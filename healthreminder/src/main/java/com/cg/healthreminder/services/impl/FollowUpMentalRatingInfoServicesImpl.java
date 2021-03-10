package com.cg.healthreminder.services.impl;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public FollowUpMentalRatingInfo findMentalRatingById(Integer patientId) throws AllCustomException{

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
		
		return followUpMentalRatingInfoJpaDao.save(followUpMentalRatingInfo);
	}


	@Override
	public boolean deleteMentalRating(Integer patientId) throws AllCustomException{

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
