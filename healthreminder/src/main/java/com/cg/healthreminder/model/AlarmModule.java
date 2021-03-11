//AUTHOR --> Ankit Banerjee
package com.cg.healthreminder.model;

import javax.persistence.*;
import java.sql.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Alarm_Module")
public class AlarmModule {
	
	@Override
	public String toString() {
		return "AlarmModule [alarmId=" + alarmId + ", patientId=" + patientId + ", alarmName=" + alarmName
				+ ", alarmTime=" + alarmTime + ", alarmDate=" + alarmDate + ", alarmNotes=" + alarmNotes + "]";
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "alarm_id")
    private Integer alarmId;
	
	//foreign key
	@NotNull
    @Column(name = "patient_id")
    private Integer patientId;
    
	@NotNull
    @Column(name = "alarm_name")
    private String alarmName;
    
    @Column(name = "alarm_time", nullable = true)
    private Timestamp alarmTime;
    
    @Column(name = "alarm_date", nullable = true)
    private Date alarmDate;
    
    @NotNull
    @Column(name = "notes")
    private String alarmNotes;

	public Integer getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(Integer alarmId) {
		this.alarmId = alarmId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getAlarmName() {
		return alarmName;
	}

	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}

	public Timestamp getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Timestamp alarmTime) {
		this.alarmTime = alarmTime;
	}

	public Date getAlarmDate() {
		return alarmDate;
	}

	public void setAlarmDate(Date alarmDate) {
		this.alarmDate = alarmDate;
	}

	public String getAlarmNotes() {
		return alarmNotes;
	}

	public void setAlarmNotes(String alarmNotes) {
		this.alarmNotes = alarmNotes;
	}

	    
    
	
}
