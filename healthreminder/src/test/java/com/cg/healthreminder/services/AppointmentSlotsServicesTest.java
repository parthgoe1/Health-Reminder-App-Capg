/*
 * Author-> Sayantan Das
 * This is the Java Test class which Tests all the CRUD operations performed by the Services Layer
 * using jpa repository and service interface, for AppointmentSlots Entity

*/

package com.cg.healthreminder.services;
import static org.mockito.ArgumentMatchers.any;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthreminder.dao.AppointmentSlotsJpaDao;
import com.cg.healthreminder.model.AppointmentDetails;
import com.cg.healthreminder.model.AppointmentSlots;
import com.cg.healthreminder.model.Slot_Pk;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentSlotsServicesTest {
	 @MockBean
	  private AppointmentSlotsJpaDao appointmentSlotsJpaDao;

	  @Autowired
	  private AppointmentSlotsServices appointmentSlotServices;
	  
	  @Test
	  public void testCreateAppointmentSlot(){
		  AppointmentSlots slot= new AppointmentSlots();
		  slot.setDoctorEndTime(null);
		  slot.setDoctorStartTime(null);
		  Slot_Pk pk=new Slot_Pk();
		  pk.setDoc_date("2020-12-16");
		  pk.setDoc_id(1);
		  slot.setPk(pk);
		  Mockito.when(appointmentSlotsJpaDao.save(slot)).thenReturn(slot);
		  assertThat(appointmentSlotServices.createAppointmentSlot(slot)).isEqualTo(slot);
	    }
	  
	   @Test
	    public void testGetAllBookedTickets() throws Exception{
		   AppointmentSlots slot= new AppointmentSlots();
		   slot.setDoctorEndTime(null);
		   slot.setDoctorStartTime(null);
	       Slot_Pk pk=new Slot_Pk();
		   pk.setDoc_date("2020-12-16");
		   pk.setDoc_id(1);
		   slot.setPk(pk);

		   AppointmentSlots slot2= new AppointmentSlots();
		   slot2.setDoctorEndTime(null);
		   slot2.setDoctorStartTime(null);
		   Slot_Pk pk2=new Slot_Pk();
		   pk2.setDoc_date("2020-12-17");
		   pk2.setDoc_id(12);
		   slot2.setPk(pk2);
	       
		   List<AppointmentSlots> asl = new ArrayList<>();
	       asl.add(slot);
	       asl.add(slot2);

	        Mockito.when(appointmentSlotsJpaDao.findAll()).thenReturn(asl);
	        assertThat(appointmentSlotServices.getAllSlots()).isEqualTo(asl);
	    }
}
