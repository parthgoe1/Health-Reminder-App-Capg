//author->Shania Dalal
package com.cg.healthreminder.services;

import com.cg.healthreminder.model.Diseases;

public interface DiseaseServices {
	public Diseases viewDisease(int diseaseId);
	public Diseases updateDiseaseInfo(int diseaseId, String content);
	public Diseases addDisease(Diseases d);
	public boolean deleteDisease(int diseaseId);
}
