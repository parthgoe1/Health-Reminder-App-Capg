package com.cg.healthreminder.services;

import com.cg.healthreminder.model.DoctorDetails;

public interface DoctorDetailsService {

	DoctorDetails findDoctorById(Integer id);
	DoctorDetails findDoctorByName(String name);
	//DoctorDetails findDoctorBySpec(String doctorSpec);
	Iterable<DoctorDetails> getAllDoctorDetails();
	DoctorDetails updateDocNameById(Integer id, String name);
	DoctorDetails updateDocVerfStatusById(Integer id, boolean verfStatus);
	DoctorDetails updateDocCertById(Integer id, String certFile);
	DoctorDetails updateDocSpecById(Integer id, String docSpec);
	boolean deleteDoctorById(Integer id);
	DoctorDetails createDoctor(DoctorDetails doctorDetails);
	

	
	
}
