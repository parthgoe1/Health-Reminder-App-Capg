package com.cg.healthreminder.services;

import com.cg.healthreminder.model.AppointmentDetails;

public interface AppointmentDetailsServices {
	
	AppointmentDetails findAppointmentDetailByPatientId(int pat_id);
	AppointmentDetails findAppointmentDetailByDoctorId(int doc_id);
    AppointmentDetails createAppointment(AppointmentDetails amp);
    boolean deleteAppointmentByPatientId(int pat_id);
    boolean deleteAppointmentByDoctorId(int doc_id);
}
