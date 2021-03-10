package com.cg.healthreminder.services.impl;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.healthreminder.dao.FollowUpDietStatusInfoJpaDao;
import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.FollowUpDietStatusInfo;
import com.cg.healthreminder.services.FollowUpDietStatusInfoServices;

// Author --> Parth Goel

@Service
@Transactional
public class FollowUpDietStatusInfoServicesImpl implements FollowUpDietStatusInfoServices{
	
	@Autowired
	private FollowUpDietStatusInfoJpaDao followUpDietStatusInfoJpaDao;
	private static final Logger logger=LogManager.getLogger(FollowUpDietStatusInfoServicesImpl.class);

	@Override
	public FollowUpDietStatusInfo findDietStatusById(Integer patientId) throws AllCustomException{

		logger.info("Finding follow up diet status information by ID ........");
		Optional<FollowUpDietStatusInfo> followUpDiestStatusInfo = followUpDietStatusInfoJpaDao.findById(patientId);
		FollowUpDietStatusInfo fudsi = null;
		if(followUpDiestStatusInfo.isPresent()) {
			fudsi = followUpDiestStatusInfo.get();
		}
		else {
			throw new AllCustomException("Diet Status Information not found for the given Patient id");
		}
		return fudsi;
	}

	@Override
	public FollowUpDietStatusInfo updateDietStatusById(Integer patientId, Boolean dietStatus) throws AllCustomException{
		
		logger.info("Updating follow up diet status information by ID ........");
		Optional<FollowUpDietStatusInfo> followUpDietStatusInfo = followUpDietStatusInfoJpaDao.findById(patientId);
		FollowUpDietStatusInfo fudsi = null;
		if(followUpDietStatusInfo.isPresent()) {
			fudsi = followUpDietStatusInfo.get();
			fudsi.setDietStatus(dietStatus);
		}
		else {
			throw new AllCustomException("Diet Status Information not found for the given Patient id, so can't be updated");
			
		}
		return followUpDietStatusInfoJpaDao.save(fudsi);
		
	}

	@Override
	public FollowUpDietStatusInfo createDietStatus(FollowUpDietStatusInfo followUpDietStatusInfo) {
		
		logger.info("Creating follow up diet status information ........");
		return followUpDietStatusInfoJpaDao.save(followUpDietStatusInfo);
	}


	@Override
	public boolean deleteDietStatus(Integer patientId) throws AllCustomException{

		logger.info("Deleting follow up diet status information by ID ........");
		Optional<FollowUpDietStatusInfo> fdsi = followUpDietStatusInfoJpaDao.findById(patientId);
	
		if(fdsi.isPresent()) {
			
			followUpDietStatusInfoJpaDao.deleteById(patientId);		}
		else {
			throw new AllCustomException("Diet Status Information not found for the given Patient id, so can't be deleted");
		}
		
		
		return true;
	}

}
