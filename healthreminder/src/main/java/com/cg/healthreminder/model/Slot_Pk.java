/**
 * @SayantanDas
 * 
 * This Class is just dedicated for creating the Composite key for the Model AppointmentSlots
*/


package com.cg.healthreminder.model;
import javax.persistence.*;

import java.io.Serializable;

@Embeddable
public class Slot_Pk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int doc_id;
	private String doc_date;
	
	public Slot_Pk() {
		super();
	}
	public Slot_Pk(int doc_id, String doc_date) {
		super();
		this.doc_id = doc_id;
		this.doc_date = doc_date;
	}
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public String getDoc_date() {
		return doc_date;
	}
	public void setDoc_date(String doc_date) {
		this.doc_date = doc_date;
	}

}
