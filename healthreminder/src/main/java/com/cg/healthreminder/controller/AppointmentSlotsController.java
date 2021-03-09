/*
 * Author-> Sayantan Das
 * This is the ControllerClass for making various operations related to Appointment Slots model using
 * URL request mapping.
 * Operations available: Check all available Appointment slots, creation and deletion of Slots by Doctors

*/


package com.cg.healthreminder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthreminder.model.AppointmentSlots;
import com.cg.healthreminder.services.AppointmentSlotsServices;

//Author-> Sayantan Das
@RestController
@RequestMapping("/healthreminder")
public class AppointmentSlotsController {
	 	@Autowired
	    private AppointmentSlotsServices appointmentSlotService;

	    @GetMapping("/getAllSlots")
	    public List<AppointmentSlots> getAllSlots(){
	        return appointmentSlotService.getAllSlots();
	    }

	    @PostMapping("/createAppointmentSlot")
	    public AppointmentSlots createTicket(@RequestBody AppointmentSlots aps){
	        return appointmentSlotService.createAppointmentSlot(aps);
	    }

	    @DeleteMapping("/deleteAppointmentSlot")
	    public AppointmentSlots deleteAppointmentSlot(@RequestBody AppointmentSlots aps)  throws AllCustomExceptionHandler{
	        return appointmentSlotService.deleteAppointmentSlot(aps);
	    }

}
