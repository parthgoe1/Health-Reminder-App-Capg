package com.cg.healthreminder.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;



import static org.assertj.core.api.Assertions.assertThat;

import com.cg.healthreminder.model.AppointmentDetails;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppointmentDetailsJpaDaoTest {
	 @Autowired
     private TestEntityManager testEntityManager;
	 @Autowired
     private AppointmentDetailsJpaDao appointmentDetailsJpaDao;
	 
	 private AppointmentDetails getAppointmentDetails() {
		 AppointmentDetails a= new AppointmentDetails();
		 a.setDoc_id(5);
		 a.setDoc_name("Doctor Astin");
		 a.setDoc_st_time(null);
		 a.setDoc_end_time(null);
		 a.setDoc_date(null); 
		 a.setPatient_name("Sayantan");
		 a.setPatient_id(4);
		 
		 return a;
	 }

	 @Test
	 public void testNewAppointmentDetails() throws Exception{
	     AppointmentDetails apd = getAppointmentDetails();
	     AppointmentDetails saveInDb = testEntityManager.persist(apd);
	     AppointmentDetails getFromInDb = appointmentDetailsJpaDao.findById(saveInDb.getApp_id()).get();
	     assertThat(getFromInDb).isEqualTo(saveInDb);
	 }
	 
	 @Test
	 public void testGetAppointmentDetailsByPatientId() throws Exception{
		 AppointmentDetails apd = getAppointmentDetails();
		 AppointmentDetails saveInDb = testEntityManager.persist(apd);
	     AppointmentDetails getInDb = appointmentDetailsJpaDao.findByPatientId(apd.getPatient_id());
	     assertThat(getInDb).isEqualTo(saveInDb);
	    }
	 
	 @Test
	 public void testGetAppointmentDetailsByDoctorId() throws Exception{
		 AppointmentDetails apd = getAppointmentDetails();
		 AppointmentDetails saveInDb = testEntityManager.persist(apd);
	     AppointmentDetails getInDb = appointmentDetailsJpaDao.findByDoctorId(apd.getDoc_id());
	     assertThat(getInDb).isEqualTo(saveInDb);
	    }
	 


}
