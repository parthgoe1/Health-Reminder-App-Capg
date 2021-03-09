package com.cg.healthreminder.services.impl;

//Author-> Sayantan Das

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthreminder.dao.AppointmentDetailsJpaDao;
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
	public AppointmentDetails findAppointmentDetailByPatientId(int patient_id) {
		return appointmentDetailsJpaDao.findByPatientId(patient_id);
	}
	
	
	public AppointmentDetails findAppointmentDetailByDoctorId(int doc_id) {
		return appointmentDetailsJpaDao.findByDoctorId(doc_id);
	}
    
	public AppointmentDetails createAppointment(AppointmentDetails amp) {
    	return appointmentDetailsJpaDao.save(amp);
    }
    
	public AppointmentDetails deleteAppointmentByPatientId(int patient_id) {
		AppointmentDetails a= appointmentDetailsJpaDao.findByPatientId(patient_id);
		if(a!=null) {
			
			 appointmentDetailsJpaDao.delete(a);
		}
		return a;
    }
	
	
    public AppointmentDetails deleteAppointmentByDoctorId(int doc_id) {
    	AppointmentDetails a= appointmentDetailsJpaDao.findByDoctorId(doc_id);
		if(a!=null) {
			
			 appointmentDetailsJpaDao.delete(a);
		}
		return a;
    }
}
