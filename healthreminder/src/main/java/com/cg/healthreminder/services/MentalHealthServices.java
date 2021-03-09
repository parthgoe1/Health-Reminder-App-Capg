//author->Shania Dalal
package com.cg.healthreminder.services;

import com.cg.healthreminder.model.mentalHealth;

public interface MentalHealthServices {
	public mentalHealth displayTips(int mentalRating);
	public mentalHealth updateTips(int mentalRating, String uptips);
	public mentalHealth addTips(mentalHealth m);
	public boolean deleteTips(int mentalRating);
}
