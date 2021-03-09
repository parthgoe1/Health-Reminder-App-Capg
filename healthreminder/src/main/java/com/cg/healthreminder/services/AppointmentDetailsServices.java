package com.cg.healthreminder.services;

import com.cg.healthreminder.model.AppointmentDetails;

public interface AppointmentDetailsServices {
	
	AppointmentDetails findAppointmentDetailByPatientId(int pat_id);
	AppointmentDetails findAppointmentDetailByDoctorId(int doc_id);
    AppointmentDetails createAppointment(AppointmentDetails amp);
    AppointmentDetails deleteAppointmentByPatientId(int pat_id);
    AppointmentDetails deleteAppointmentByDoctorId(int doc_id);
}
