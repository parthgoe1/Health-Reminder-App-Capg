package com.cg.healthreminder.dao;

// Author: Naman Bhandari

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthreminder.model.Patient;

public interface PatientDao extends JpaRepository<Patient, Integer>{

}
