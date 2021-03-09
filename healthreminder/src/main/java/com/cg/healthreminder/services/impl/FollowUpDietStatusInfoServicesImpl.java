package com.cg.healthreminder.services.impl;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.FollowUpDietStatusInfoJpaDao;
import com.cg.healthreminder.model.FollowUpDietStatusInfo;
import com.cg.healthreminder.services.FollowUpDietStatusInfoServices;

// Author --> Parth Goel

@Service
@Transactional
public class FollowUpDietStatusInfoServicesImpl implements FollowUpDietStatusInfoServices{
	
	@Autowired
	private FollowUpDietStatusInfoJpaDao followUpDietStatusInfoJpaDao;


	@Override
	public FollowUpDietStatusInfo findDietStatusById(Integer patientId) {
		return followUpDietStatusInfoJpaDao.findById(patientId).get();
	}

	@Override
	public FollowUpDietStatusInfo updateDietStatusById(Integer patientId, Boolean dietStatus) {
		FollowUpDietStatusInfo followUpDietStatusInfo = followUpDietStatusInfoJpaDao.findById(patientId).get();
		followUpDietStatusInfo.setDietStatus(dietStatus);
		return followUpDietStatusInfoJpaDao.save(followUpDietStatusInfo);
		
	}

	@Override
	public FollowUpDietStatusInfo createDietStatus(FollowUpDietStatusInfo followUpDietStatusInfo) {
		
		return followUpDietStatusInfoJpaDao.save(followUpDietStatusInfo);
	}


	@Override
	public boolean deleteDietStatus(Integer patientId) {
		followUpDietStatusInfoJpaDao.deleteById(patientId);
		FollowUpDietStatusInfo followUpDietStatusInfo = followUpDietStatusInfoJpaDao.findById(patientId).get();
		if(null == followUpDietStatusInfo) {
			return true;
		}
		return false;
	}

}
