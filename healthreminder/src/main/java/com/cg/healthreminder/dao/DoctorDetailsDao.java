package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.healthreminder.model.DoctorDetails;

public interface DoctorDetailsDao extends JpaRepository<DoctorDetails,Integer>{
	
	@Query("select d from Doctor_Details d where d.doct_id=:doct_id")
	DoctorDetails findDoctorById(Integer id);
	
	@Query("select d from Doctor_Details d where d.doc_name=:doc_name")
	DoctorDetails findDoctorByName(String name);
	
	
}
