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
	 
	 @Test
	 public void testDeleteTicketById() throws Exception{
	       AppointmentDetails apd1 = getAppointmentDetails();
	       AppointmentDetails apd2= new AppointmentDetails();
	       apd2.setDoc_id(3);
		   apd2.setDoc_name("Doctor Karan");
		   apd2.setDoc_st_time(null);
		   apd2.setDoc_end_time(null);
		   apd2.setDoc_date(null); 
		   apd2.setPatient_name("Deepak");
		   apd2.setPatient_id(7);

	        AppointmentDetails app = testEntityManager.persist(apd1);
	        testEntityManager.persist(apd2);

	        //delete one ticket DB
	        testEntityManager.remove(app);

	        List<AppointmentDetails> tickets = (List<AppointmentDetails>) appointmentDetailsJpaDao.findAll();
	        Assert.assertEquals(tickets.size(), 1);

	    }


}
