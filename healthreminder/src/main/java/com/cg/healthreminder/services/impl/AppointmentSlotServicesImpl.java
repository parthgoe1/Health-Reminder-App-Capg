package com.cg.healthreminder.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthreminder.dao.AppointmentSlotsJpaDao;
import com.cg.healthreminder.model.AppointmentSlots;
import com.cg.healthreminder.services.AppointmentSlotsServices;

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
	public boolean deleteAppointmentSlot(AppointmentSlots as) {
		Optional<AppointmentSlots> a = appointmentSlotsJpaDao.findById(as.getPk());
		AppointmentSlots aslot=null;
		if(a.isPresent()) {
			 aslot= a.get();
			 appointmentSlotsJpaDao.delete(aslot);
			 return true;
		}
		return false;
    }
}
