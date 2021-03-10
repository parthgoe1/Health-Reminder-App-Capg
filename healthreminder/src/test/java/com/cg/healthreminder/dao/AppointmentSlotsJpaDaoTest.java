/*
 * Author-> Sayantan Das
 * This is the Java Test class which Tests all the CRUD operations performed by the Repository/DAO
 * using jpa properties, for AppointmentSlots Entity

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


import com.cg.healthreminder.model.AppointmentSlots;
import com.cg.healthreminder.model.Slot_Pk;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppointmentSlotsJpaDaoTest {
	 @Autowired
     private TestEntityManager testEntityManager;
	 @Autowired
     private AppointmentSlotsJpaDao appointmentSlotsJpaDao;
	 
	 
	 private AppointmentSlots getAppointmentSlot() {
		 AppointmentSlots slot= new AppointmentSlots();
		 slot.setDoctorEndTime("12:00");
		 slot.setDoctorStartTime("9:00");
		 Slot_Pk pk=new Slot_Pk();
		 pk.setDoc_date("2020-12-16");
		 pk.setDoc_id(1);
		 slot.setPk(pk);
		 return slot;
	 }
	 
	 @Test
	 public void testNewAppointmentSlot() throws Exception{
	     AppointmentSlots slot = getAppointmentSlot();
	     AppointmentSlots saveInDb = testEntityManager.persist(slot);
	     AppointmentSlots getFromInDb = appointmentSlotsJpaDao.findById(saveInDb.getPk()).get();
	     assertThat(getFromInDb).isEqualTo(saveInDb);
	     assertThat(getFromInDb.toString()).isEqualTo(saveInDb.toString());
	 }
	 
	 @Test
	 public void testDeleteAppointmentSlot() throws Exception{
		 AppointmentSlots slot1 = getAppointmentSlot();
		 AppointmentSlots slot2= new AppointmentSlots();
		 slot2.setDoctorEndTime("12:00");
		 slot2.setDoctorStartTime("9:00");
		 Slot_Pk pk2=new Slot_Pk();
		 pk2.setDoc_date("2020-12-17");
		 pk2.setDoc_id(12);
		 slot2.setPk(pk2);

		 AppointmentSlots appslot = testEntityManager.persist(slot1);
         testEntityManager.persist(slot2);
         testEntityManager.remove(appslot);

         List<AppointmentSlots> tickets = (List<AppointmentSlots>) appointmentSlotsJpaDao.findAll();
	     Assert.assertEquals(1,tickets.size());

	    }
	 
	 @Test
	    public void testGetAllSlots() throws Exception{
		 AppointmentSlots slot1 = getAppointmentSlot();
		 AppointmentSlots slot2= new AppointmentSlots();
		 slot2.setDoctorEndTime("12:00");
		 slot2.setDoctorStartTime("9:00");
		 Slot_Pk pk2=new Slot_Pk();
		 pk2.setDoc_date("2020-12-17");
		 pk2.setDoc_id(12);
		 slot2.setPk(pk2);

		 testEntityManager.persist(slot1);
         testEntityManager.persist(slot2);
      
         List<AppointmentSlots> tickets = (List<AppointmentSlots>) appointmentSlotsJpaDao.findAll();
	     Assert.assertEquals(2,tickets.size());
	    }
}
