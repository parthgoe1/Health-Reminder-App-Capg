package com.cg.healthreminder.services.impl;
import java.util.Optional;

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
<<<<<<< HEAD
		Optional<FollowUpDietStatusInfo> followUpDiestStatusInfo = followUpDietStatusInfoJpaDao.findById(patientId);
		FollowUpDietStatusInfo fudsi = null;
		if(followUpDiestStatusInfo.isPresent()) {
			fudsi = followUpDiestStatusInfo.get();
		}
		else {
=======
		FollowUpDietStatusInfo followUpDiestStatusInfo = followUpDietStatusInfoJpaDao.findById(patientId).get();
		if(followUpDiestStatusInfo == null) {
>>>>>>> 461dc30193bb505bdb963c002fb4d898594f0636
			throw new AllCustomException("Diet Status Information not found for the given Patient id");
		}
		return fudsi;
	}

	@Override
	public FollowUpDietStatusInfo updateDietStatusById(Integer patientId, Boolean dietStatus) throws AllCustomException{
<<<<<<< HEAD
		Optional<FollowUpDietStatusInfo> followUpDietStatusInfo = followUpDietStatusInfoJpaDao.findById(patientId);
		FollowUpDietStatusInfo fudsi = null;
		if(followUpDietStatusInfo.isPresent()) {
			fudsi = followUpDietStatusInfo.get();
			fudsi.setDietStatus(dietStatus);
=======
		FollowUpDietStatusInfo followUpDietStatusInfo = followUpDietStatusInfoJpaDao.findById(patientId).get();
		if(followUpDietStatusInfo == null) {
			throw new AllCustomException("Diet Status Information not found for the given Patient id, so can't be updated");
>>>>>>> 461dc30193bb505bdb963c002fb4d898594f0636
		}
		else {
			throw new AllCustomException("Diet Status Information not found for the given Patient id, so can't be updated");
			
		}
		return followUpDietStatusInfoJpaDao.save(fudsi);
		
	}

	@Override
	public FollowUpDietStatusInfo createDietStatus(FollowUpDietStatusInfo followUpDietStatusInfo) {
		
		return followUpDietStatusInfoJpaDao.save(followUpDietStatusInfo);
	}


	@Override
	public boolean deleteDietStatus(Integer patientId) throws AllCustomException{
<<<<<<< HEAD
		Optional<FollowUpDietStatusInfo> fdsi = followUpDietStatusInfoJpaDao.findById(patientId);
		FollowUpDietStatusInfo fdsi2 = null;
		if(fdsi.isPresent()) {
			fdsi2 = fdsi.get();
			followUpDietStatusInfoJpaDao.deleteById(patientId);
=======
		FollowUpDietStatusInfo fdsi = followUpDietStatusInfoJpaDao.findById(patientId).get();
		if(fdsi == null) {
			throw new AllCustomException("Diet Status Information not found for the given Patient id, so can't be deleted");
>>>>>>> 461dc30193bb505bdb963c002fb4d898594f0636
		}
		else {
			throw new AllCustomException("Diet Status Information not found for the given Patient id, so can't be deleted");
		}
		
		FollowUpDietStatusInfo followUpDietStatusInfo = followUpDietStatusInfoJpaDao.findById(patientId).get();
		if(null == followUpDietStatusInfo) {
			return true;
		}
		return false;
	}

}
