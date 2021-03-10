/*
 * Author-> Sayantan Das
 * This is the class that implements the respective Service interfaces and accesses the postgress database
 * and perform CRUD operations as asked by client or the admin -> AppointmentSlotsServices

*/

package com.cg.healthreminder.services.impl;


import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private static final Logger logger=LogManager.getLogger(AppointmentSlotServicesImpl.class);
	
	public List<AppointmentSlots> getAllSlots(){
		logger.info("Sending all SLots ........"); 
		
		List<AppointmentSlots>appslots= appointmentSlotsJpaDao.findAll();
		 return appslots;
	}
	
	
	public AppointmentSlots createAppointmentSlot(AppointmentSlots as) {
		logger.info("Creating Appointment SLot ........");
		
		return  appointmentSlotsJpaDao.save(as);
	}
	
	public AppointmentSlots deleteAppointmentSlot(AppointmentSlots as) throws AllCustomException {
		logger.info("Deleting appointment SLot ........");
		
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
