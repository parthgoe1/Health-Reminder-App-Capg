package com.cg.healthreminder.services.impl;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


	@Override
	public FollowUpDietStatusInfo findDietStatusById(Integer patientId) throws AllCustomException{
		FollowUpDietStatusInfo followUpDiestStatusInfo = followUpDietStatusInfoJpaDao.findById(patientId).get();
		if(followUpDiestStatusInfo == null) {
			throw new AllCustomException("Diet Status Information not found for the given Patient id");
		}
		return followUpDiestStatusInfo;
	}

	@Override
	public FollowUpDietStatusInfo updateDietStatusById(Integer patientId, Boolean dietStatus) throws AllCustomException{
		FollowUpDietStatusInfo followUpDietStatusInfo = followUpDietStatusInfoJpaDao.findById(patientId).get();
		if(followUpDietStatusInfo == null) {
			throw new AllCustomException("Diet Status Information not found for the given Patient id, so can't be updated");
		}
		else {
			followUpDietStatusInfo.setDietStatus(dietStatus);
		}
		return followUpDietStatusInfoJpaDao.save(followUpDietStatusInfo);
		
	}

	@Override
	public FollowUpDietStatusInfo createDietStatus(FollowUpDietStatusInfo followUpDietStatusInfo) {
		
		return followUpDietStatusInfoJpaDao.save(followUpDietStatusInfo);
	}


	@Override
	public boolean deleteDietStatus(Integer patientId) throws AllCustomException{
		FollowUpDietStatusInfo fdsi = followUpDietStatusInfoJpaDao.findById(patientId).get();
		if(fdsi == null) {
			throw new AllCustomException("Diet Status Information not found for the given Patient id, so can't be deleted");
		}
		else {
			followUpDietStatusInfoJpaDao.deleteById(patientId);
		}
		
		FollowUpDietStatusInfo followUpDietStatusInfo = followUpDietStatusInfoJpaDao.findById(patientId).get();
		if(null == followUpDietStatusInfo) {
			return true;
		}
		return false;
	}

}
