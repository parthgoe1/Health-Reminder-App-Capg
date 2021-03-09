package com.cg.healthreminder.services.impl;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.FollowUpMentalRatingInfoJpaDao;
import com.cg.healthreminder.model.FollowUpMentalRatingInfo;
import com.cg.healthreminder.services.FollowUpMentalRatingInfoServices;

// Author --> Parth Goel

@Service
@Transactional
public class FollowUpMentalRatingInfoServicesImpl implements FollowUpMentalRatingInfoServices{
	
	@Autowired
	private FollowUpMentalRatingInfoJpaDao followUpMentalRatingInfoJpaDao;
	
	@Override
	public FollowUpMentalRatingInfo findMentalRatingById(Integer patientId) {
		return followUpMentalRatingInfoJpaDao.findById(patientId).get();
	}

	@Override
	public FollowUpMentalRatingInfo updateMentalRatingById(Integer patientId, Integer mentalRating) {
		FollowUpMentalRatingInfo followUpMentalRatingInfo = followUpMentalRatingInfoJpaDao.findById(patientId).get();
		followUpMentalRatingInfo.setMentalRating(mentalRating);
		return followUpMentalRatingInfoJpaDao.save(followUpMentalRatingInfo);
		
	}

	@Override
	public FollowUpMentalRatingInfo createMentalRating(FollowUpMentalRatingInfo followUpMentalRatingInfo) {
		
		return followUpMentalRatingInfoJpaDao.save(followUpMentalRatingInfo);
	}


	@Override
	public boolean deleteMentalRating(Integer patientId) {
		followUpMentalRatingInfoJpaDao.deleteById(patientId);
		FollowUpMentalRatingInfo followUpMentalRatingInfo= followUpMentalRatingInfoJpaDao.findById(patientId).get();
		if(null == followUpMentalRatingInfo) {
			return true;
		}
		return false;
	}

}
