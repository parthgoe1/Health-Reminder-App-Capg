package com.cg.healthreminder.services;

import java.util.List;

import com.cg.healthreminder.model.AppointmentSlots;

public interface AppointmentSlotsServices {
	List<AppointmentSlots> getAllSlots();
	//AppointmentSlotsServices updateAppointmentSlot(int doc_id);
	AppointmentSlots createAppointmentSlot(AppointmentSlots as);
	AppointmentSlots deleteAppointmentSlot(AppointmentSlots as);
	
	
}
