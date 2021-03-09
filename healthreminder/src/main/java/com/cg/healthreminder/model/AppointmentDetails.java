/*
 * Author-> Sayantan Das
 * This is the Model class for AppointmentDetails Entity

*/


package com.cg.healthreminder.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;


@Entity
@Table(name = "Appointment_Details")
public class AppointmentDetails {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "app_id")
    private int appId;
	
	@Column
	private int patientId;
    
	@Column
	private int doctorId;
	
	@Column
	private String doctorName;
	
	@Column
	private String patientName;
	
	@Column
	private Date doctorDate;
   
    @Column
	private Timestamp doctorStartTime;
	
	@Column
	private Timestamp doctorEndTime;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Date getDoctorDate() {
		return doctorDate;
	}

	public void setDoctorDate(Date doctorDate) {
		this.doctorDate = doctorDate;
	}

	public Timestamp getDoctorStartTime() {
		return doctorStartTime;
	}

	public void setDoctorStartTime(Timestamp doctorStartTime) {
		this.doctorStartTime = doctorStartTime;
	}

	public Timestamp getDoctorEndTime() {
		return doctorEndTime;
	}

	public void setDoctorEndTime(Timestamp doctorEndTime) {
		this.doctorEndTime = doctorEndTime;
	}

	@Override
	public String toString() {
		return "AppointmentDetails [appId=" + appId + ", patientId=" + patientId + ", doctorId=" + doctorId
				+ ", doctorName=" + doctorName + ", patientName=" + patientName + ", doctorDate=" + doctorDate
				+ ", doctorStartTime=" + doctorStartTime + ", doctorEndTime=" + doctorEndTime + "]";
	}


}
