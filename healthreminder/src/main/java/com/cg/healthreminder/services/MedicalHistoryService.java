package com.cg.healthreminder.services;

// Author: Naman Bhandari

import java.util.List;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.MedicalHistory;

public interface MedicalHistoryService {
public List<MedicalHistory> getByPatientId(int id) throws AllCustomException;
public void addRecord(MedicalHistory m);
public void deleteRecord(String file);
public MedicalHistory updateRecord(MedicalHistory m);
}
