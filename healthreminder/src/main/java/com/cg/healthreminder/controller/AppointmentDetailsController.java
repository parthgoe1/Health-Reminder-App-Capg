package com.cg.healthreminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthreminder.model.AppointmentDetails;
import com.cg.healthreminder.services.AppointmentDetailsServices;

//Author-> Sayantan Das
@RestController
@RequestMapping("/healthreminder")
public class AppointmentDetailsController {
	
	    @Autowired
	    private AppointmentDetailsServices appointmentDetailService;

	    @GetMapping("/findAppointmentByPatId/{patientId}")
	    public AppointmentDetails findAppointmentDetailsByPatientId(@PathVariable int patientId){
	        return appointmentDetailService.findAppointmentDetailByPatientId(patientId);
	    }

	    @GetMapping("/findAppointmentByDocId/{doctorId}")
	    public AppointmentDetails findAppointmentDetailsByDoctorId(@PathVariable int doctorId){
	        return appointmentDetailService.findAppointmentDetailByDoctorId(doctorId);
	    }

	    @PostMapping("/createAppointment")
	    public AppointmentDetails createTicket(@RequestBody AppointmentDetails apd){
	        return appointmentDetailService.createAppointment(apd);
	    }

	    @DeleteMapping("/deleteAppointmentByPatId/{patientId}")
	    public AppointmentDetails deleteAppointmentByPatientId(@PathVariable int patientId){
	        return appointmentDetailService.deleteAppointmentByPatientId(patientId);
	    }


	    @DeleteMapping("/deleteAppointmentByDocId/{doctorId}")
	    public AppointmentDetails deleteAppointmentByDoctorId(@PathVariable int doctorId){
	        return appointmentDetailService.deleteAppointmentByDoctorId(doctorId);
	    }
}
