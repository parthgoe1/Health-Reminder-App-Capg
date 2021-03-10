/*
 * Author-> Sayantan Das
 * This is the Model class for AppointmentDetails Entity

*/


package com.cg.healthreminder.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Appointment_Details")
public class AppointmentDetails {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "app_id")
    private int appId;
	
	@NotNull
	@Column
	private int patientId;
    
	@NotNull
	@Column
	private int doctorId;
	
	@NotNull
	@Size(min=2, max=10)
	@Column
	private String doctorName;
	
	@NotNull
	@Size(min=2, max=10)
	@Column
	private String patientName;
	
	@NotNull
	@Column
	private Date doctorDate;
   
	@NotNull
    @Column
	private Timestamp doctorStartTime;
	
	@NotNull
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
