package com.cg.healthreminder.services.impl;
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
		FollowUpMentalRatingInfo fumri = followUpMentalRatingInfoJpaDao.findById(patientId).get();
		if(fumri == null) {
			throw new AllCustomException("Mental Rating Information not found for the given Patient id");
		}
		return fumri;
	}

	@Override
	public FollowUpMentalRatingInfo updateMentalRatingById(Integer patientId, Integer mentalRating) throws AllCustomException{
		FollowUpMentalRatingInfo followUpMentalRatingInfo = followUpMentalRatingInfoJpaDao.findById(patientId).get();
		if(followUpMentalRatingInfo == null) {
			throw new AllCustomException("Mental Rating Information not found for the given Patient id, so can't be updated");
		}
		else {
			followUpMentalRatingInfo.setMentalRating(mentalRating);
		}
		return followUpMentalRatingInfoJpaDao.save(followUpMentalRatingInfo);
		
	}

	@Override
	public FollowUpMentalRatingInfo createMentalRating(FollowUpMentalRatingInfo followUpMentalRatingInfo) {
		
		return followUpMentalRatingInfoJpaDao.save(followUpMentalRatingInfo);
	}


	@Override
	public boolean deleteMentalRating(Integer patientId) throws AllCustomException{
		FollowUpMentalRatingInfo fumri= followUpMentalRatingInfoJpaDao.findById(patientId).get();
		if(fumri == null) {
			throw new AllCustomException("Mental Rating Information not found for the given Patient id, so can't be deleted");
		}
		else {
			followUpMentalRatingInfoJpaDao.deleteById(patientId);
		}
		
		FollowUpMentalRatingInfo followUpMentalRatingInfo= followUpMentalRatingInfoJpaDao.findById(patientId).get();
		if(null == followUpMentalRatingInfo) {
			return true;
		}
		return false;
	}

}
