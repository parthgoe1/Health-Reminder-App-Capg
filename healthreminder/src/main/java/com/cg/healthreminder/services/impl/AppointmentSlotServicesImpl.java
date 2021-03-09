/*
 * Author-> Sayantan Das
 * This is the class that implements the respective Service interfaces and accesses the postgress database
 * and perform CRUD operations as asked by client or the admin -> AppointmentSlotsServices

*/

package com.cg.healthreminder.services.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthreminder.dao.AppointmentSlotsJpaDao;
import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.AppointmentSlots;
import com.cg.healthreminder.services.AppointmentSlotsServices;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@Transactional
public class AppointmentSlotServicesImpl implements AppointmentSlotsServices {
	
	@Autowired
    private AppointmentSlotsJpaDao appointmentSlotsJpaDao;
	
	public List<AppointmentSlots> getAllSlots(){
		 List<AppointmentSlots>appslots= appointmentSlotsJpaDao.findAll();
		 return appslots;
	}
	
	/*public AppointmentSlotsServices updateAppointmentSlot(int doc_id) {
		
	}*/
	
	public AppointmentSlots createAppointmentSlot(AppointmentSlots as) {
		return  appointmentSlotsJpaDao.save(as);
	}
	
	public AppointmentSlots deleteAppointmentSlot(AppointmentSlots as) throws AllCustomException {
		Optional<AppointmentSlots> a = appointmentSlotsJpaDao.findById(as.getPk());
		AppointmentSlots aslot=null;
		if(a.isPresent()) {
			 aslot= a.get();
			 appointmentSlotsJpaDao.delete(aslot); 
		}
		else
		{
			throw new AllCustomException("Appointment Slot not found");
		}
		return aslot;
    }
}
