package com.cg.healthreminder.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;
//Author-> Sayantan Das

@Entity
@Table(name = "Appointment_Details")
public class AppointmentDetails {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "app_id")
    private int app_id;
	
	@Column
	private int patient_id;
    
	@Column
	private int doc_id;
	
	@Column
	private String doc_name;
	
	@Column
	private String patient_name;
	
	@Column
	private Date doc_date;
   
    @Column
	private Timestamp doc_st_time;
	
	@Column
	private Timestamp doc_end_time;

	public int getApp_id() {
		return app_id;
	}

	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public int getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	public String getDoc_name() {
		return doc_name;
	}

	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public Date getDoc_date() {
		return doc_date;
	}

	public void setDoc_date(Date doc_date) {
		this.doc_date = doc_date;
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
		return "Appointment_Details [app_id=" + app_id + ", patient_id=" + patient_id + ", doc_id=" + doc_id
				+ ", doc_name=" + doc_name + ", patient_name=" + patient_name + ", doc_date=" + doc_date
				+ ", doc_st_time=" + doc_st_time + ", doc_end_time=" + doc_end_time + "]";
	}

}
