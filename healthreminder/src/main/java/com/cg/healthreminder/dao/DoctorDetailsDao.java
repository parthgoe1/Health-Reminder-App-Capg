package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.cg.healthreminder.model.DoctorDetails;

public interface DoctorDetailsDao extends JpaRepository<DoctorDetails,Integer>{
	
	@Query("select d from DoctorDetails d where d.doctorId=:doctorId")
	DoctorDetails findDoctorById(Integer doctorId);
	
	@Query("select d from DoctorDetails d where d.doctorName=:doctorName")
	DoctorDetails findDoctorByName(String doctorName);
	
	@Query("select d from DoctorDetails d where d.doctorSpec=:doctorSpec")
	DoctorDetails findDoctorBySpec(String doctorSpec);
	
	
}
