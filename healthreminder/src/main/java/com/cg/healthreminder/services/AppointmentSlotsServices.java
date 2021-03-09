/*
 * Author-> Sayantan Das
 * This is the interface showing the services/operations that can be performed on AppointmentDetails Entity

*/


package com.cg.healthreminder.services;

import java.util.List;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.AppointmentSlots;


public interface AppointmentSlotsServices {
	List<AppointmentSlots> getAllSlots();
	//AppointmentSlotsServices updateAppointmentSlot(int doctor_id);
	AppointmentSlots createAppointmentSlot(AppointmentSlots as);
	AppointmentSlots deleteAppointmentSlot(AppointmentSlots as) throws AllCustomException;
	
	
}
