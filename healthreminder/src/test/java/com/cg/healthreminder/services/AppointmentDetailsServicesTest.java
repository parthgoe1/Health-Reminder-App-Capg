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
import java.util.Date;
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
}
