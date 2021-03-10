/*
 * Author-> Sayantan Das
 * This is the Java Test class which Tests all the CRUD operations performed by the Repository/DAO
 * using jpa properties, for AppointmentDetails Entity

*/
package com.cg.healthreminder.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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
		  a.setDoctorId(5);
		  a.setDoctorName("Doctor Astin");
		  a.setDoctorStartTime(null);
		  a.setDoctorEndTime(null);
		  a.setDoctorDate(null); 
		  a.setPatientName("Sayantan");
		  a.setPatientId(4);

		 
		 return a;
	 }

	 @Test
	 public void testNewAppointmentDetails() throws Exception{
	     AppointmentDetails apd = getAppointmentDetails();
	     AppointmentDetails saveInDb = testEntityManager.persist(apd);
	     AppointmentDetails getFromInDb = appointmentDetailsJpaDao.findById(saveInDb.getAppId()).get();
	     assertThat(getFromInDb).isEqualTo(saveInDb);
	     assertThat(getFromInDb.toString()).isEqualTo(saveInDb.toString());
	 }
	 
	 @Test
	 public void testGetAppointmentDetailsByPatientId() throws Exception{
		 AppointmentDetails apd = getAppointmentDetails();
		 AppointmentDetails saveInDb = testEntityManager.persist(apd);
	     AppointmentDetails getInDb = appointmentDetailsJpaDao.findByPatientId(apd.getPatientId());
	     assertThat(getInDb).isEqualTo(saveInDb);
	    }
	 
	 @Test
	 public void testGetAppointmentDetailsByDoctorId() throws Exception{
		 AppointmentDetails apd = getAppointmentDetails();
		 AppointmentDetails saveInDb = testEntityManager.persist(apd);
	     AppointmentDetails getInDb = appointmentDetailsJpaDao.findByDoctorId(apd.getDoctorId());
	     assertThat(getInDb).isEqualTo(saveInDb);
	    }
	 
	 @Test
	 public void testDeleteAppointment() throws Exception{
	       AppointmentDetails apd1 = getAppointmentDetails();
	       AppointmentDetails apd2= new AppointmentDetails();
	       apd2.setDoctorId(3);
		   apd2.setDoctorName("Doctor Karan");
		   apd2.setDoctorStartTime(null);
		   apd2.setDoctorEndTime(null);
		   apd2.setDoctorDate(null); 
		   apd2.setPatientName("Deepak");
		   apd2.setPatientId(7);

	        AppointmentDetails app = testEntityManager.persist(apd1);
	        testEntityManager.persist(apd2);

	        //delete one ticket DB
	        testEntityManager.remove(app);

	        List<AppointmentDetails> tickets = (List<AppointmentDetails>) appointmentDetailsJpaDao.findAll();
	        Assert.assertEquals(tickets.size(), 1);

	    }


}
