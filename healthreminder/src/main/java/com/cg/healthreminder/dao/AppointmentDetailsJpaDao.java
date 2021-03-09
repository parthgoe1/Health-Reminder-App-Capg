package com.cg.healthreminder.dao;
//Author-> Sayantan Das

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.healthreminder.model.AppointmentDetails;
@Repository
public interface AppointmentDetailsJpaDao extends JpaRepository<AppointmentDetails,Integer>{
	  @Query("select a from AppointmentDetails a where a.patient_id=:patient_id")
	  AppointmentDetails findByPatientId(int patient_id);
	  
	  @Query("select a from AppointmentDetails a where a.doc_id=:doc_id")
	  AppointmentDetails findByDoctorId(int doc_id);
}
