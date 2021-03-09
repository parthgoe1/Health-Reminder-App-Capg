package com.cg.healthreminder.services.impl;

import java.util.Optional;

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
    
	public boolean deleteAppointmentByPatientId(int patient_id) {
		Optional<AppointmentDetails> a = Optional.of(appointmentDetailsJpaDao.findByPatientId(patient_id));
		AppointmentDetails app=null;
		if(a.isPresent()) {
			 app= a.get();
			 appointmentDetailsJpaDao.delete(app);
			 return true;
		}
		return false;
    }
	
	
    public boolean deleteAppointmentByDoctorId(int doc_id) {
    	Optional<AppointmentDetails> a = Optional.of(appointmentDetailsJpaDao.findByDoctorId(doc_id));
		AppointmentDetails app=null;
		if(a.isPresent()) {
			 app= a.get();
			 appointmentDetailsJpaDao.delete(app);
			 return true;
		}
		return false;
    }
}
