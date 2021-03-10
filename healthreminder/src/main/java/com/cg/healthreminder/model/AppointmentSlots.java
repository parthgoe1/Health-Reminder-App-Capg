/*
 * Author-> Sayantan Das
 * This is the Model class for AppointmentDetails Entity

*/

package com.cg.healthreminder.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Timestamp;

@Entity
@Table(name="Appointment_Slots")
public class AppointmentSlots {
	
	@EmbeddedId      // this pk contains doc_id + doc_date as the primary key ->composite key 
	private Slot_Pk pk;
	
	@NotNull
	@Column
	private Timestamp doctorStartTime;
	
	@NotNull
	@Column
	private Timestamp doctorEndTime;

	public Slot_Pk getPk() {
		return pk;
	}

	public void setPk(Slot_Pk pk) {
		this.pk = pk;
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
		return "AppointmentSlots [pk=" + pk + ", doctorStartTime=" + doctorStartTime + ", doctorEndTime="
				+ doctorEndTime + "]";
	}

	
	
}
