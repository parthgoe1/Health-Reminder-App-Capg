package com.cg.healthreminder.service;

import com.cg.healthreminder.model.Diseases;

public interface DiseaseServices {
	public Diseases viewDisease(int dis_id);
	public Diseases updateDiseaseInfo(int dis_id, String content);
	public Diseases addDisease(Diseases d);
	public boolean deleteDisease(int dis_id);
}
