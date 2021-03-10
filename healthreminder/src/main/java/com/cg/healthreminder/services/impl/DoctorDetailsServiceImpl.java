//AUTHOR --> Ankit Banerjee
package com.cg.healthreminder.services.impl;

import org.springframework.beans.factory.annotation.Autowired;


import com.cg.healthreminder.dao.DoctorDetailsDao;
import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.DoctorDetails;
import com.cg.healthreminder.services.DoctorDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class DoctorDetailsServiceImpl implements DoctorDetailsService {

	public static String doctorExcepMessage = "Doctor Details Not Found";
	
	@Autowired
	private DoctorDetailsDao doctorDetailsDao;
	
	@Override
	public DoctorDetails findDoctorById(Integer id) throws AllCustomException
	{
		DoctorDetails ob = doctorDetailsDao.findDoctorById(id);
		if(ob == null) {
			throw new AllCustomException(doctorExcepMessage);
		}
		
		return ob;
	}
	
	
	@Override
	public DoctorDetails findDoctorBySpec(String doctorSpec) throws AllCustomException
	{
		DoctorDetails ob = doctorDetailsDao.findDoctorBySpec(doctorSpec);
		if(ob == null) {
			throw new AllCustomException(doctorExcepMessage);
		}
		
		return ob;
	}
	
	@Override
	public Iterable<DoctorDetails> getAllDoctorDetails()
	{
		return doctorDetailsDao.findAll();
	}
	
	@Override
	public DoctorDetails updateDoctorById(Integer doctorId,String doctorName,boolean verfStatus,  String doctorCertFile,  String doctorSpec) throws AllCustomException
	{
		Optional<DoctorDetails> doctorDetails = doctorDetailsDao.findById(doctorId);
		DoctorDetails ob = null;
		
		if(doctorDetails.isPresent()) {
			ob = doctorDetails.get();
			ob.setDoctorName(doctorName);
			ob.setVerfStatus(true);
			ob.setDoctorCertFile("Certified");
			ob.setDoctorSpec("Lungs");
		}
		else
		{
			throw new AllCustomException(doctorExcepMessage);
		}
		
		return doctorDetailsDao.save(ob);
	}
	
	
	@Override
	public DoctorDetails deleteDoctorById(Integer id) throws AllCustomException
	{
		Optional<DoctorDetails> doctorDetails = doctorDetailsDao.findById(id);
		DoctorDetails ob = null;
		
		if(doctorDetails.isPresent())
		{
			ob = doctorDetails.get();
			doctorDetailsDao.delete(ob);
		}
		else
		{
			throw new AllCustomException(doctorExcepMessage);
		}
		return ob;
	}
	
	@Override
	public DoctorDetails createDoctor(DoctorDetails doctorDetails)
	{
		return doctorDetailsDao.save(doctorDetails);
	}
	
}
