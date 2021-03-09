package com.cg.healthreminder.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
    @ElementCollection
    private List<Integer> mentalRating;    
	
	public Integer getPatientId() {
		return patientId;
	}
	
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	public List<Integer> getMentalRating() {
		return mentalRating;
	}
	
	public Integer getMentalRating(Integer day) {
		return mentalRating.get(day);
	}
	
	public void setMentalRating(List<Integer> mentalRating) {
		this.mentalRating = mentalRating;
	}
	
	public void setMentalRating(Integer mentalRating) {
		if(this.mentalRating.size() <= 7) {
			this.mentalRating.add(mentalRating);
		}
		else {
			this.mentalRating.clear();
			this.mentalRating.add(mentalRating);
		}
	}
	
	

}
