package com.cg.healthreminder.service;

import java.util.List;

import com.cg.healthreminder.model.AppointmentSlots;

public interface AppointmentSlotsServices {
	List<AppointmentSlots> getAllSlots();
	//AppointmentSlotsServices updateAppointmentSlot(int doc_id);
	AppointmentSlots createAppointmentSlot(AppointmentSlots as);
	boolean deleteAppointmentSlot(AppointmentSlots as);
	
	
}
