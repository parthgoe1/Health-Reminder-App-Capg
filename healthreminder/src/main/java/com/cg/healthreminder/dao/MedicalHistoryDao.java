package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthreminder.model.MedicalHistory;

public interface MedicalHistoryDao extends JpaRepository<MedicalHistory,String>{

}
