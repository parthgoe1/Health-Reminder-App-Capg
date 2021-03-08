package com.cg.healthreminder.model;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patient_id")
	private int patientId;
	@Column(name = "email", unique = true)
	private String patientEmail;
	@Column(name = "patient_name", nullable = false)
	private String patientName;
	@Column(name = "mobile", nullable=false)
	private String patientMobile;
	@Column(name = "age")
	private int patientAge;
	@Column(name="height")
	private double patientHeight;
	@Column(name="weight")
	private double patientWeight;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
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

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public double getPatientHeight() {
		return patientHeight;
	}

	public void setPatientHeight(double patientHeight) {
		this.patientHeight = patientHeight;
	}

	public double getPatientWeight() {
		return patientWeight;
	}

	public void setPatientWeight(double patientWeight) {
		this.patientWeight = patientWeight;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientEmail=" + patientEmail + ", patientName=" + patientName
				+ ", patientMobile=" + patientMobile + ", patientAge=" + patientAge + ", patientHeight=" + patientHeight
				+ ", patientWeight=" + patientWeight + "]";
	}
}
