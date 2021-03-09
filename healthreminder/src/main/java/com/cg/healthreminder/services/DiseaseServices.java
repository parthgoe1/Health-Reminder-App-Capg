//author->Shania Dalal
package com.cg.healthreminder.services;

import com.cg.healthreminder.model.Diseases;

public interface DiseaseServices {
	public Diseases viewDisease(Integer diseaseId);
	public Diseases updateDiseaseInfo(Integer diseaseId, String content);
	public Diseases addDisease(Diseases d);
}
