/*
 * Author-> Sayantan Das
 * This is the ControllerClass for making various operations related to AppointmentDetails using
 * URL request mapping.
 * Operations available: finding appointment by Patient Id, Doctor Id, creation and deletion of appointments

*/
package com.cg.healthreminder.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.AppointmentDetails;
import com.cg.healthreminder.services.AppointmentDetailsServices;



@RestController
@RequestMapping("/healthreminder")
public class AppointmentDetailsController{
	
	    @Autowired
	    private AppointmentDetailsServices appointmentDetailService;
	    private static final Logger logger=LogManager.getLogger( AppointmentDetailsController.class);
	    
	    @GetMapping("/findAppointmentByPatId/{patientId}")
	    public AppointmentDetails findAppointmentDetailsByPatientId(@PathVariable int patientId) throws AllCustomException{
	    	logger.info("In controller class of finding appointment by patient ids ........"); 
	    	
	      	return appointmentDetailService.findAppointmentDetailByPatientId(patientId);
	    }

	    @GetMapping("/findAppointmentByDocId/{doctorId}")
	    public AppointmentDetails findAppointmentDetailsByDoctorId(@PathVariable int doctorId) throws AllCustomException{
	    	logger.info("In controller class of finding appointment by doctor ids ........");
	    	
	    	return appointmentDetailService.findAppointmentDetailByDoctorId(doctorId);
	    }

	    @PostMapping("/createAppointment")
	    public AppointmentDetails createTicket(@RequestBody AppointmentDetails apd){
	    	logger.info("In controller class of creating appointment ........");
	    	
	    	return appointmentDetailService.createAppointment(apd);
	    }

	    @DeleteMapping("/deleteAppointmentByPatId/{patientId}")
	    public AppointmentDetails deleteAppointmentByPatientId(@PathVariable int patientId) throws AllCustomException{
	    	logger.info("In controller class of deleting appointment by patient ids ........");
	    	
	    	return appointmentDetailService.deleteAppointmentByPatientId(patientId);
	    }


	    @DeleteMapping("/deleteAppointmentByDocId/{doctorId}")
	    public AppointmentDetails deleteAppointmentByDoctorId(@PathVariable int doctorId) throws AllCustomException{
	    	logger.info("In controller class of deleting appointment by doctor ids ........");
	    	
	    	return appointmentDetailService.deleteAppointmentByDoctorId(doctorId);
	    }
}
