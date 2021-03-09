package com.cg.healthreminder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Author --> Parth Goel

@Entity
@Table(name = "Followup_Mental_Rating_Info")
public class FollowUpMentalRatingInfo {

	@Override
	public String toString() {
		return "DietInfo [ patientId = " + patientId + ", mentalRating=" + mentalRating	+ "]";
	}
	
    @Id
	@Column(name = "patient_id", nullable = false)
    private Integer patientId;
    
    @Column(name = "mental_rating")
    private Integer mentalRating;   

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getMentalRating() {
		return mentalRating;
	}

	public void setMentalRating(Integer mentalRating) {
		this.mentalRating = mentalRating;
	}		
	

}
