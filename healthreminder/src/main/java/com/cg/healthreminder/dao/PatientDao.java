package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthreminder.model.Patient;
@Repository
public interface PatientDao extends JpaRepository<Patient, Integer>{

}
