/*
 * Author-> Sayantan Das
 * This is the Repository interface for performing JPA related operations on the AppointmentDetails Entity

*/


package com.cg.healthreminder.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.healthreminder.model.AppointmentDetails;
@Repository
public interface AppointmentDetailsJpaDao extends JpaRepository<AppointmentDetails,Integer>{
	  @Query("select a from AppointmentDetails a where a.patientId=:patientId")
	  AppointmentDetails findByPatientId(int patientId);
	  
	  @Query("select a from AppointmentDetails a where a.doctorId=:doctorId")
	  AppointmentDetails findByDoctorId(int doctorId);
}
