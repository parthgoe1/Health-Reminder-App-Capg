package com.cg.healthreminder.model;

import javax.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name="Appointment_Slots")
public class Appointment_Slots {
	
	@EmbeddedId      // this pk contains doc_id + doc_date as the primary key ->composite key 
	private Slot_Pk pk;
	
	@Column
	private Timestamp doc_st_time;
	
	@Column
	private Timestamp doc_end_time;

	public Slot_Pk getPk() {
		return pk;
	}

	public void setPk(Slot_Pk pk) {
		this.pk = pk;
	}

	public Timestamp getDoc_st_time() {
		return doc_st_time;
	}

	public void setDoc_st_time(Timestamp doc_st_time) {
		this.doc_st_time = doc_st_time;
	}

	public Timestamp getDoc_end_time() {
		return doc_end_time;
	}

	public void setDoc_end_time(Timestamp doc_end_time) {
		this.doc_end_time = doc_end_time;
	}

	@Override
	public String toString() {
		return "Appointment_Slots [pk=" + pk + ", doc_st_time=" + doc_st_time + ", doc_end_time=" + doc_end_time + "]";
	}
}
