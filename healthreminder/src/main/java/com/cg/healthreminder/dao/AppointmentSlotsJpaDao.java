package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthreminder.model.AppointmentSlots;
import com.cg.healthreminder.model.Slot_Pk;

public interface AppointmentSlotsJpaDao extends JpaRepository<AppointmentSlots,Slot_Pk> {

}
