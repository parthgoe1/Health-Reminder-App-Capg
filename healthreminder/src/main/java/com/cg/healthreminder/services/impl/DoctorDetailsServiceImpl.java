package com.cg.healthreminder.services.impl;

import org.springframework.beans.factory.annotation.Autowired;


import com.cg.healthreminder.dao.DoctorDetailsDao;
import com.cg.healthreminder.model.DoctorDetails;
import com.cg.healthreminder.services.DoctorDetailsService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class DoctorDetailsServiceImpl implements DoctorDetailsService {

	@Autowired
	private DoctorDetailsDao doctorDetailsDao;
	
	@Override
	public DoctorDetails findDoctorById(Integer id)
	{
		return doctorDetailsDao.findDoctorById(id);
	}
	
	@Override
	public DoctorDetails findDoctorByName(String name)
	{
		return doctorDetailsDao.findDoctorByName(name);
	}
	
//	@Override
//	public DoctorDetails findDoctorBySpec(String doctorSpec)
//	{
//		return doctorDetailsDao.findDoctorBySpec(doctorSpec);
//	}
	
	@Override
	public Iterable<DoctorDetails> getAllDoctorDetails()
	{
		return doctorDetailsDao.findAll();
	}
	
	@Override
	public DoctorDetails updateDocNameById(Integer id, String name)
	{
		DoctorDetails doctorDetails = doctorDetailsDao.findById(id).get();
		doctorDetails.setDoctorName(name);
		return doctorDetailsDao.save(doctorDetails);
	}
	
	@Override
	public DoctorDetails updateDocVerfStatusById(Integer id, boolean verfStatus)
	{
		DoctorDetails doctorDetails = doctorDetailsDao.findById(id).get();
		doctorDetails.setVerfStatus(verfStatus);
		return doctorDetailsDao.save(doctorDetails);
	}
	
	@Override
	public DoctorDetails updateDocCertById(Integer id, String certFile)
	{
		DoctorDetails doctorDetails = doctorDetailsDao.findById(id).get();
		doctorDetails.setDoctorCertFile(certFile);
		return doctorDetailsDao.save(doctorDetails);
	}
	
	@Override
	public DoctorDetails updateDocSpecById(Integer id, String docSpec)
	{
		DoctorDetails doctorDetails = doctorDetailsDao.findById(id).get();
		doctorDetails.setDoctorSpec(docSpec);
		return doctorDetailsDao.save(doctorDetails);
	}
	
	
	@Override
	public boolean deleteDoctorById(Integer id)
	{
		doctorDetailsDao.deleteById(id);
		DoctorDetails doctorDetails = doctorDetailsDao.findById(id).get();
		if(null == doctorDetails)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public DoctorDetails createDoctor(DoctorDetails doctorDetails)
	{
		return doctorDetailsDao.save(doctorDetails);
	}
	
}
