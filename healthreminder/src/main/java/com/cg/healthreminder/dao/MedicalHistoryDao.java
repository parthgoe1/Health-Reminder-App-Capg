package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthreminder.model.MedicalHistory;
@Repository
public interface MedicalHistoryDao extends JpaRepository<MedicalHistory,String>{

}
