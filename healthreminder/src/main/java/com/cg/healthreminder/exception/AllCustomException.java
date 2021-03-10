/*
 * Author-Sayantan Das
 * This is the Custom exception class which receives the message thrown by the exception
 */

package com.cg.healthreminder.exception;

public class AllCustomException extends Exception {
	private static final long serialVersionUID = 1L;

	public AllCustomException(String msg){
		super(msg);
	}
}
