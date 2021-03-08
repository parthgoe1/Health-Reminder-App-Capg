package com.cg.healthreminder.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Followup_Info")
public class FollowUpInfo {
	
	@Override
	public String toString() {
		return "DietInfo [patientId = " + patientId + ", date = " + date + ", mentalRaiting=" + mentalRaiting
				+ ", dietStatus=" + dietStatus + "]";
	}
	@Id
    @Column(name = "patient_id", nullable = false)
    private Integer patientId;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "mental_rating")
    private Integer mentalRaiting;
    @Column(name = "diet_status")
    private boolean dietStatus;
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getMentalRaiting() {
		return mentalRaiting;
	}
	public void setMentalRaiting(Integer mentalRaiting) {
		this.mentalRaiting = mentalRaiting;
	}
	public boolean isDietStatus() {
		return dietStatus;
	}
	public void setDietStatus(boolean dietStatus) {
		this.dietStatus = dietStatus;
	}
    
    
    

    
}
