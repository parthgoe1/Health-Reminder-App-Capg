//AUTHOR --> Ankit Banerjee
package com.cg.healthreminder.services.impl;

import org.springframework.beans.factory.annotation.Autowired;


import com.cg.healthreminder.dao.DoctorDetailsDao;
import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.AlarmModule;
import com.cg.healthreminder.model.DoctorDetails;
import com.cg.healthreminder.services.DoctorDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class DoctorDetailsServiceImpl implements DoctorDetailsService {

	@Autowired
	private DoctorDetailsDao doctorDetailsDao;
	
	@Override
	public DoctorDetails findDoctorById(Integer id) throws AllCustomException
	{
		DoctorDetails ob = doctorDetailsDao.findDoctorById(id);
		if(ob == null) {
			throw new AllCustomException("Doctor Details Not Found");
		}
		
		return ob;
	}
	
	
	@Override
	public DoctorDetails findDoctorBySpec(String doctorSpec) throws AllCustomException
	{
		DoctorDetails ob = doctorDetailsDao.findDoctorBySpec(doctorSpec);
		if(ob == null) {
			throw new AllCustomException("Doctor Details Not Found");
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
		DoctorDetails doctorDetails = doctorDetailsDao.findById(doctorId).get();
		if(doctorDetails == null) {
			throw new AllCustomException("Doctor Details Not Found");
		}
		doctorDetails.setDoctorName(doctorName);
		doctorDetails.setVerfStatus(true);
		doctorDetails.setDoctorCertFile("Certified");
		doctorDetails.setDoctorSpec("Lungs");
		return doctorDetailsDao.save(doctorDetails);
	}
	
	
//	@Override
//	public DoctorDetails updateDocVerfStatusById(Integer id, boolean verfStatus) throws AllCustomException
//	{
//		DoctorDetails doctorDetails = doctorDetailsDao.findById(id).get();
//		if(doctorDetails == null) {
//			throw new AllCustomException("Doctor Details Not Found");
//		}
//		doctorDetails.setVerfStatus(verfStatus);
//		return doctorDetailsDao.save(doctorDetails);
//	}
//	
//	@Override
//	public DoctorDetails updateDocCertById(Integer id, String certFile) throws AllCustomException
//	{
//		DoctorDetails doctorDetails = doctorDetailsDao.findById(id).get();
//		if(doctorDetails == null) {
//			throw new AllCustomException("Doctor Details Not Found");
//		}
//		doctorDetails.setDoctorCertFile(certFile);
//		return doctorDetailsDao.save(doctorDetails);
//	}
//	
//	@Override
//	public DoctorDetails updateDocSpecById(Integer id, String docSpec) throws AllCustomException
//	{
//		DoctorDetails doctorDetails = doctorDetailsDao.findById(id).get();
//		if(doctorDetails == null) {
//			throw new AllCustomException("Doctor Details Not Found");
//		}
//		doctorDetails.setDoctorSpec(docSpec);
//		return doctorDetailsDao.save(doctorDetails);
//	}
	
	
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
			throw new AllCustomException("Doctor Details Not Found");
		}
		return ob;
	}
	
	@Override
	public DoctorDetails createDoctor(DoctorDetails doctorDetails)
	{
		return doctorDetailsDao.save(doctorDetails);
	}
	
}
