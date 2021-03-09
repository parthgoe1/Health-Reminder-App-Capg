package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthreminder.model.AppointmentSlots;
import com.cg.healthreminder.model.Slot_Pk;
@Repository
public interface AppointmentSlotsJpaDao extends JpaRepository<AppointmentSlots,Slot_Pk> {

}
