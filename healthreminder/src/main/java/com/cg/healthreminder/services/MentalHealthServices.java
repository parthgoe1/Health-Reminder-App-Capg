/*
 * Author-> Shania Dalal
 * This is the Interface that defines the functions to be performed on the mentalHealth model
 * 
 * 
*/
package com.cg.healthreminder.services;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.MentalHealth;

public interface MentalHealthServices {
	public MentalHealth displayTips(Integer mentalRating) throws AllCustomException;
	public MentalHealth updateTips(Integer mentalRating, String uptips) throws AllCustomException;
	public MentalHealth addTips(MentalHealth m);
	public boolean deleteTips(Integer mentalRating) throws AllCustomException;
}
