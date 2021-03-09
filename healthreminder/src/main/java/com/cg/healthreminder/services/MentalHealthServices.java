//author->Shania Dalal
package com.cg.healthreminder.services;

import com.cg.healthreminder.model.mentalHealth;

public interface MentalHealthServices {
	public mentalHealth displayTips(Integer mentalRating);
	public mentalHealth updateTips(Integer mentalRating, String uptips);
	public mentalHealth addTips(mentalHealth m);
}
