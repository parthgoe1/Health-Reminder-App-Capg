/*
 * Author-> Sayantan Das
 * This is the class that implements the respective Service interfaces and accesses the postgress database
 * and perform CRUD operations as asked by client or the admin -> AppointmentDetailsServices

*/


package com.cg.healthreminder.services.impl;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthreminder.dao.AppointmentDetailsJpaDao;
import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.AppointmentDetails;
import com.cg.healthreminder.services.AppointmentDetailsServices;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@Transactional
public class AppointmentDetailsServicesImpl implements AppointmentDetailsServices {
	@Autowired
    private AppointmentDetailsJpaDao appointmentDetailsJpaDao;
	
	@Override
	public AppointmentDetails findAppointmentDetailByPatientId(int patient_id) throws AllCustomException {
		AppointmentDetails a= appointmentDetailsJpaDao.findByPatientId(patient_id);
		if(a==null) {
			throw new AllCustomException("Appointment not found for the given Patient id");
		}
		return a;
	}
	
	
	public AppointmentDetails findAppointmentDetailByDoctorId(int doc_id) throws AllCustomException {
		AppointmentDetails a= appointmentDetailsJpaDao.findByDoctorId(doc_id);
		if(a==null) {
			throw new AllCustomException("Appointment not found for the given Doctor id");
		}
		return a;
	}
    
	public AppointmentDetails createAppointment(AppointmentDetails amp){
    	return appointmentDetailsJpaDao.save(amp);
    }
    
	public AppointmentDetails deleteAppointmentByPatientId(int patient_id)  throws AllCustomException{
		AppointmentDetails a= appointmentDetailsJpaDao.findByPatientId(patient_id);
		if(a!=null) {
			
			 appointmentDetailsJpaDao.delete(a);
		}
		else {
			throw new AllCustomException("Appointment not found for the given Patient id");
		}
		return a;
    }
	
	
    public AppointmentDetails deleteAppointmentByDoctorId(int doc_id) throws AllCustomException {
    	AppointmentDetails a= appointmentDetailsJpaDao.findByDoctorId(doc_id);
		if(a!=null) {
			
			 appointmentDetailsJpaDao.delete(a);
		}
		else {
			throw new AllCustomException("Appointment not found for the given Doctor id");
		}
		return a;
    }
}
