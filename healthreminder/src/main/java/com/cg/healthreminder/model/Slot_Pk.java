package com.cg.healthreminder.model;
import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Embeddable
public class Slot_Pk implements Serializable {

	private int doc_id;
	private Date doc_date;
	
	public Slot_Pk() {
		super();
	}
	public Slot_Pk(int doc_id, Date doc_date) {
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
	public Date getDoc_date() {
		return doc_date;
	}
	public void setDoc_date(Date doc_date) {
		this.doc_date = doc_date;
	}

}
