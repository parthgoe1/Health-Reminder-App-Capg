/**
 * @SayantanDas
 * 
 * This is the Model/Entity Class for AppointmentSlots
*/


package com.cg.healthreminder.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Appointment_Slots")
public class AppointmentSlots {
	
	
	/**
	 * 
	 * this pk contains doc_id + doc_date as the primary key ->composite key 
	*/
	@EmbeddedId      
	private Slot_Pk pk;
	
	@NotNull
	@Column
	private String doctorStartTime;
	
	@NotNull
	@Column
	private String doctorEndTime;

	public Slot_Pk getPk() {
		return pk;
	}

	public void setPk(Slot_Pk pk) {
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
