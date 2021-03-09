/*
 * Author-> Shania Dalal
 * This is the Interface that defines the functions to be performed on the mentalHealth model
 * 
 * 
*/
package com.cg.healthreminder.services;

import com.cg.healthreminder.exception.AllCustomExceptionHandler;
import com.cg.healthreminder.model.mentalHealth;

public interface MentalHealthServices {
	public mentalHealth displayTips(Integer mentalRating) throws AllCustomExceptionHandler;
	public mentalHealth updateTips(Integer mentalRating, String uptips) throws AllCustomExceptionHandler;
	public mentalHealth addTips(mentalHealth m);
}
