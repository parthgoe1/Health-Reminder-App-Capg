/**
 * @SayantanDas
 * 
 * This is the Model/Entity Class for AppointmentSlots
*/


package com.cg.healthreminder.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="Appointment_Slots")
public class AppointmentSlots {
	
	
	/**
	 * 
	 * this pk contains doc_id + doc_date as the primary key ->composite key 
	*/
	@EmbeddedId      
	private SlotCompositeKey pk;
	
	@NotNull
	@Column
	@Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$",message="Please enter correct time")
	private String doctorStartTime;
	
	@NotNull
	@Column
	@Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$",message="Please enter correct time")
	private String doctorEndTime;

	public SlotCompositeKey getPk() {
		return pk;
	}

	public void setPk(SlotCompositeKey pk) {
		this.pk = pk;
	}

	public String getDoctorStartTime() {
		return doctorStartTime;
	}

	public void setDoctorStartTime(String doctorStartTime) {
		this.doctorStartTime = doctorStartTime;
	}

	public String getDoctorEndTime() {
		return doctorEndTime;
	}

	public void setDoctorEndTime(String doctorEndTime) {
		this.doctorEndTime = doctorEndTime;
	}

	@Override
	public String toString() {
		return "AppointmentSlots [pk=" + pk + ", doctorStartTime=" + doctorStartTime + ", doctorEndTime="
				+ doctorEndTime + "]";
	}

	
	
}
