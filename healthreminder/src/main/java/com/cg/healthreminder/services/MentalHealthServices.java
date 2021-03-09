package com.cg.healthreminder.services;

import com.cg.healthreminder.model.mentalHealth;

public interface MentalHealthServices {
	public mentalHealth displayTips(int mental_rating);
	public mentalHealth updateTips(int mental_rating, String uptips);
	public mentalHealth addTips(mentalHealth m);
	public boolean deleteTips(int mental_rating);
}