package com.cg.healthreminder.dao;

// Author: Naman Bhandari

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.healthreminder.model.MedicalHistory;

public interface MedicalHistoryDao extends JpaRepository<MedicalHistory,String>{
	@Query("select m from MedicalHistory m where m.patientId=:id")
	List<MedicalHistory> findRecordsByPatientId(int id);
}
