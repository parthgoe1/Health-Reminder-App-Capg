package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.healthreminder.model.DoctorDetails;

public interface DoctorDetailsDao extends JpaRepository<DoctorDetails,Integer>{
	
	@Query("select d from DoctorDetails d where d.doct_id=:id")
	DoctorDetails findDoctorById(Integer id);
	
	@Query("select d from DoctorDetails d where d.doc_name=:name")
	DoctorDetails findDoctorByName(String name);
	
	
}
