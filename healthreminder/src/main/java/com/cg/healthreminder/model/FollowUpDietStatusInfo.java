package com.cg.healthreminder.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Author --> Parth Goel

@Entity
@Table(name = "Followup_Diet_Status_Info")
public class FollowUpDietStatusInfo {
	
	@Override
	public String toString() {
		return "DietInfo [ patientId = " + patientId + ", dietStatus=" + dietStatus + "]";
	}
	
    @Id
	@Column(name = "patient_id", nullable = false)
    private Integer patientId;
    @Column(name = "diet_status")
    @ElementCollection
    private List<Boolean> dietStatus;
    
	
	public Integer getPatientId() {
		return patientId;
	}
	
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	public List<Boolean> getDietStatus() {
		return dietStatus;
	}
	
	public Boolean getDietStatus(Integer day) {
		return dietStatus.get(day);
	}
	
	public void setDietStatus(List<Boolean> dietStatus) {
		this.dietStatus = dietStatus;
	}
	
	public void setDietStatus(Boolean dietStatus) {
		if(this.dietStatus.size() <= 7) {
			this.dietStatus.add(dietStatus);
		}
		else {
			this.dietStatus.clear();
			this.dietStatus.add(dietStatus);
		}
	}
	
    
    
}
