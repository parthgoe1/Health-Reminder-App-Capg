package com.cg.healthreminder.services;

import java.sql.*;

import com.cg.healthreminder.model.AlarmModule;

public interface AlarmModuleService {
	
	AlarmModule findAlarmById(Integer id);
	AlarmModule findAlarmByName(String name);
	Iterable<AlarmModule> getAllAlarms();
	AlarmModule updateAlarmNameById(Integer id, String name);
	AlarmModule updateAlarmTimeById(Integer id, Timestamp alarm_time);
	AlarmModule updateAlarmDateById(Integer id, Date alarm_date);
	AlarmModule updateAlarmNoteById(Integer id, String note);
	boolean deleteAlarmById(Integer id);
	AlarmModule createAlarm(AlarmModule alarmModule);
	
}
