package com.cg.healthreminder.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthreminder.dao.DoctorDetailsDao;
import com.cg.healthreminder.model.DoctorDetails;
import com.cg.healthreminder.services.DoctorDetailsService;

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
	
	@Override
	public Iterable<DoctorDetails> getAllDoctorDetails()
	{
		return doctorDetailsDao.findAll();
	}
	
	@Override
	public DoctorDetails updateDocNameById(Integer id, String name)
	{
		DoctorDetails doctorDetails = doctorDetailsDao.findById(id).get();
		doctorDetails.setDoc_name(name);
		return doctorDetailsDao.save(doctorDetails);
	}
	
	@Override
	public DoctorDetails updateDocVerfStatusById(Integer id, boolean verfStatus)
	{
		DoctorDetails doctorDetails = doctorDetailsDao.findById(id).get();
		doctorDetails.setVerf_status(false);
		return doctorDetailsDao.save(doctorDetails);
	}
	
	@Override
	public DoctorDetails updateDocCertById(Integer id, String certFile)
	{
		DoctorDetails doctorDetails = doctorDetailsDao.findById(id).get();
		doctorDetails.setCertificate_file(certFile);
		return doctorDetailsDao.save(doctorDetails);
	}
	
	@Override
	public DoctorDetails updateDocSpecById(Integer id, String docSpec)
	{
		DoctorDetails doctorDetails = doctorDetailsDao.findById(id).get();
		doctorDetails.setDoc_spec(docSpec);
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