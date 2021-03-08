package com.cg.healthreminder.model;

import javax.persistence.*;
import java.sql.*;
//import java.util.Date;

@Entity
@Table(name = "Alarm_Module")
public class AlarmModule {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "alarm_id")
    private Integer alarm_id;
	
	//foreign key
    @Column(name = "patient_id", nullable = false)
    private Integer patient_id;
    
    @Column(name = "alarm_name", nullable = false)
    private String alarm_name;
    
    @Column(name = "alarm_time", nullable = false)
    private Timestamp alarm_time;
    
    @Column(name = "alarm_date", nullable = false)
    private Date alarm_date;
    
    @Column(name = "notes", nullable = false)
    private String notes;

	public Integer getAlarm_id() {
		return alarm_id;
	}

	public void setAlarm_id(Integer alarm_id) {
		this.alarm_id = alarm_id;
	}

	public Integer getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}

	public String getAlarm_name() {
		return alarm_name;
	}

	public void setAlarm_name(String alarm_name) {
		this.alarm_name = alarm_name;
	}

	public Timestamp getAlarm_time() {
		return alarm_time;
	}

	public void setAlarm_time(Timestamp alarm_time) {
		this.alarm_time = alarm_time;
	}

	public Date getAlarm_date() {
		return alarm_date;
	}

	public void setAlarm_date(Date alarm_date) {
		this.alarm_date = alarm_date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "AlarmModule [alarm_id=" + alarm_id + ", patient_id=" + patient_id + ", alarm_name=" + alarm_name
				+ ", alarm_time=" + alarm_time + ", alarm_date=" + alarm_date + ", notes=" + notes + "]";
	}

	    
    
	
}
