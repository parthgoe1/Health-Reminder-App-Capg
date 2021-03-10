package com.cg.healthreminder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

//Author --> Parth Goel

@Entity
@Table(name = "Followup_Diet_Status_Info")
public class FollowUpDietStatusInfo {
	
	@Override
	public String toString() {
		return "DietInfo [ patientId = " + patientId + ", dietStatus = " + dietStatus + ", streak = " + streak + "]";
	}
	
    @Id
    @Min(1)
	@Column(name = "patient_id", nullable = false)
    private Integer patientId;
    
    @Column(name = "diet_status")
    private Boolean dietStatus;
    
    @Column(name = "streak")
    private Integer streak;
    
	public FollowUpDietStatusInfo() {
		this.streak = 0;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Boolean getDietStatus() {
		return dietStatus;
	}

	public void setDietStatus(Boolean dietStatus) {
		if(dietStatus == true) {
			this.streak++;
			this.dietStatus = dietStatus;
		}
		else {
			this.streak = 0;
			this.dietStatus = dietStatus;
		}
		this.dietStatus = dietStatus;
	}

	public Integer getStreak() {
		return streak;
	}

	public void setStreak(Integer streak) {
		this.streak = streak;
	}
    
}
