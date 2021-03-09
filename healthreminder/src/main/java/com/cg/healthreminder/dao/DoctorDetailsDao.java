package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.healthreminder.model.DoctorDetails;
@Repository
public interface DoctorDetailsDao extends JpaRepository<DoctorDetails,Integer>{
	
	@Query("select d from DoctorDetails d where d.doctId=:doct_id")
	DoctorDetails findDoctorById(Integer doct_id);
	
	@Query("select d from DoctorDetails d where d.docName=:doc_name")
	DoctorDetails findDoctorByName(String doc_name);
	
	
}
