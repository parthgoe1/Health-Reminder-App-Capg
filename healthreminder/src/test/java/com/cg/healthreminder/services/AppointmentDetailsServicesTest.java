package com.cg.healthreminder.services;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthreminder.dao.AppointmentDetailsJpaDao;
import com.cg.healthreminder.model.AppointmentDetails;

import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentDetailsServicesTest {
	  @MockBean
	  private AppointmentDetailsJpaDao appointmentDetailsJpaDao;

	  @Autowired
	  private AppointmentDetailsServices appointmentDetailServices;
	  
	  @Test
	    public void testCreateAppointment(){
		  AppointmentDetails a= new AppointmentDetails();
		  a.setApp_id(1);
		  a.setDoc_id(5);
		  a.setDoc_name("Doctor Astin");
		  a.setDoc_st_time(null);
		  a.setDoc_end_time(null);
		  a.setDoc_date(null); 
		  a.setPatient_name("Sayantan");
		  a.setPatient_id(4);

		  Mockito.when(appointmentDetailsJpaDao.save(a)).thenReturn(a);
          assertThat(appointmentDetailServices.createAppointment(a)).isEqualTo(a);
	    }
	  
	  @Test
	    public void testFindByPatientId() throws Exception{
		  AppointmentDetails a= new AppointmentDetails();
		  a.setApp_id(1);
		  a.setDoc_id(5);
		  a.setDoc_name("Doctor Astin");
		  a.setDoc_st_time(null);
		  a.setDoc_end_time(null);
		  a.setDoc_date(null); 
		  a.setPatient_name("Sayantan");
		  a.setPatient_id(4);
		  
		  Mockito.when(appointmentDetailsJpaDao.findByPatientId(4)).thenReturn(a);
	      assertThat(appointmentDetailServices.findAppointmentDetailByPatientId(4)).isEqualTo(a);
	    }
	  
	  @Test
	    public void testFindByDoctorId() throws Exception{
		  AppointmentDetails a= new AppointmentDetails();
		  a.setApp_id(1);
		  a.setDoc_id(5);
		  a.setDoc_name("Doctor Astin");
		  a.setDoc_st_time(null);
		  a.setDoc_end_time(null);
		  a.setDoc_date(null); 
		  a.setPatient_name("Sayantan");
		  a.setPatient_id(4);
		  
		  Mockito.when(appointmentDetailsJpaDao.findByDoctorId(5)).thenReturn(a);
	      assertThat(appointmentDetailServices.findAppointmentDetailByDoctorId(5)).isEqualTo(a);
	    }
	  
	  @Test
	    public void testDeleteAppointmentByPatientId() throws Exception{
		  AppointmentDetails a= new AppointmentDetails();
		  a.setApp_id(1);
		  a.setDoc_id(5);
		  a.setDoc_name("Doctor Astin");
		  a.setDoc_st_time(Timestamp.valueOf("2020-05-01 15:30:00.0"));
		  a.setDoc_end_time(Timestamp.valueOf("2020-05-01 15:30:00.0"));
		  a.setDoc_date(Date.valueOf("2020-12-16")); 
		  a.setPatient_name("Sayantan");
		  a.setPatient_id(4);

		  
		  Mockito.when(appointmentDetailsJpaDao.save(a)).thenReturn(a);
		  appointmentDetailServices.createAppointment(a);
	      //Mockito.when(appointmentDetailsJpaDao.findByPatientId(4)).thenReturn(a);
	      //assertThat(appointmentDetailServices.findAppointmentDetailByPatientId(4)).isEqualTo(a);
	     // appointmentDetailsJpaDao.deleteById(a.getApp_id());
	      //Mockito.when(appointmentDetailsJpaDao.findById(1).get()).thenReturn(a);
		  
	      //assertThat(appointmentDetailServices.deleteAppointmentByPatientId(4)).isEqualTo(a);
		  System.out.println(appointmentDetailServices.deleteAppointmentByPatientId(4));
	    }
}
