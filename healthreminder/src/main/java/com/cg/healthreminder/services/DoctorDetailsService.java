//AUTHOR --> Ankit Banerjee
package com.cg.healthreminder.services;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.DoctorDetails;

public interface DoctorDetailsService {

	DoctorDetails findDoctorById(Integer id)  throws AllCustomException;
	DoctorDetails findDoctorByName(String name)  throws AllCustomException;
	DoctorDetails findDoctorBySpec(String doctorSpec)  throws AllCustomException;
	Iterable<DoctorDetails> getAllDoctorDetails()  throws AllCustomException;
	DoctorDetails updateDocNameById(Integer id, String name)  throws AllCustomException;
	DoctorDetails updateDocVerfStatusById(Integer id, boolean verfStatus)  throws AllCustomException;
	DoctorDetails updateDocCertById(Integer id, String certFile)  throws AllCustomException;
	DoctorDetails updateDocSpecById(Integer id, String docSpec)  throws AllCustomException;
	DoctorDetails deleteDoctorById(Integer id)  throws AllCustomException;
	DoctorDetails createDoctor(DoctorDetails doctorDetails);
	

	
	
}
