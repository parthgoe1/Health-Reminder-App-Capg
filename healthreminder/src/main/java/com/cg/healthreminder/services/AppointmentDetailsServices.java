/*
 * Author-> Sayantan Das
 * This is the interface showing the services/operations that can be performed on AppointmentDetails Entity

*/

package com.cg.healthreminder.services;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.AppointmentDetails;

public interface AppointmentDetailsServices {
	
	AppointmentDetails findAppointmentDetailByPatientId(int pat_id) throws AllCustomException;
	AppointmentDetails findAppointmentDetailByDoctorId(int doc_id) throws AllCustomException;
    AppointmentDetails createAppointment(AppointmentDetails amp);
    AppointmentDetails deleteAppointmentByPatientId(int pat_id) throws AllCustomException;
    AppointmentDetails deleteAppointmentByDoctorId(int doc_id) throws AllCustomException;
}
