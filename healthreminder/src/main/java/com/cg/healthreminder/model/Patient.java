package com.cg.healthreminder.model;

// Author: Naman Bhandari

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@Column(name = "patient_id")
	private Integer patientId;
	@Column(name = "email")
	private String patientEmail;
	@Column(name = "patient_name", nullable = false)
	private String patientName;
	@Column(name = "mobile", nullable=false)
	private String patientMobile;
	@Column(name = "age")
	private Integer patientAge;
	@Column(name="height")
	private Double patientHeight;
	@Column(name="weight")
	private Double patientWeight;
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientMobile() {
		return patientMobile;
	}
	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}
	public Integer getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(Integer patientAge) {
		this.patientAge = patientAge;
	}
	public Double getPatientHeight() {
		return patientHeight;
	}
	public void setPatientHeight(Double patientHeight) {
		this.patientHeight = patientHeight;
	}
	public Double getPatientWeight() {
		return patientWeight;
	}
	public void setPatientWeight(Double patientWeight) {
		this.patientWeight = patientWeight;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientEmail=" + patientEmail + ", patientName=" + patientName
				+ ", patientMobile=" + patientMobile + ", patientAge=" + patientAge + ", patientHeight=" + patientHeight
				+ ", patientWeight=" + patientWeight + "]";
	}

	
}
