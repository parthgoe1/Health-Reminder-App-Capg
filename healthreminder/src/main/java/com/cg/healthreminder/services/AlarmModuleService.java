//AUTHOR --> Ankit Banerjee
package com.cg.healthreminder.services;

import java.sql.*;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.AlarmModule;

public interface AlarmModuleService {
	
	AlarmModule findAlarmById(Integer id)  throws AllCustomException;
	AlarmModule findAlarmByName(String alarmName)  throws AllCustomException;
	Iterable<AlarmModule> getAllAlarms()  throws AllCustomException;
	AlarmModule updateAlarmNameById(Integer id, String name)  throws AllCustomException;
	AlarmModule updateAlarmTimeById(Integer id, Timestamp alarmTime)  throws AllCustomException;
	AlarmModule updateAlarmDateById(Integer id, Date alarmDate)  throws AllCustomException;
	AlarmModule updateAlarmNoteById(Integer id, String note)  throws AllCustomException;
	AlarmModule deleteAlarmById(Integer id)  throws AllCustomException;
	AlarmModule createAlarm(AlarmModule alarmModule);
	
}
