/*
 * Author-> Shania Dalal
 * This is the Interface that defines the functions to be performed on the mentalHealth model
 * 
 * 
*/
package com.cg.healthreminder.services;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.mentalHealth;

public interface MentalHealthServices {
	public mentalHealth displayTips(Integer mentalRating) throws AllCustomException;
	public mentalHealth updateTips(Integer mentalRating, String uptips) throws AllCustomException;
	public mentalHealth addTips(mentalHealth m);
}
