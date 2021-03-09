/*package com.cg.healthreminder.services.impl;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthreminder.dao.AlarmModuleDao;
import com.cg.healthreminder.model.AlarmModule;
import com.cg.healthreminder.model.DoctorDetails;

public class AlarmModuleServiceImpl implements com.cg.healthreminder.services.AlarmModuleService {
	
	@Autowired
	private AlarmModuleDao alarmModuleDao;
	
	@Override
	public AlarmModule findAlarmById(Integer id)
	{
		return alarmModuleDao.findAlarmById(id);
	}
	
	@Override
	public AlarmModule findAlarmByName(String name)
	{
		return alarmModuleDao.findAlarmByName(name);
	}
	
	@Override
	public Iterable<AlarmModule> getAllAlarms()
	{
		return alarmModuleDao.findAll();
	}
	
	@Override
	public AlarmModule updateAlarmNameById(Integer id, String name)
	{
		AlarmModule alarmModules = alarmModuleDao.findById(id).get();
		alarmModules.setAlarm_name(name);
		return alarmModuleDao.save(alarmModules);
	}
	
	@Override
	public AlarmModule updateAlarmTimeById(Integer id, Timestamp alarm_time)
	{
		AlarmModule alarmModules = alarmModuleDao.findById(id).get();
		alarmModules.setAlarm_time(alarm_time);
		return alarmModuleDao.save(alarmModules);
	}
	
	@Override
	public AlarmModule updateAlarmDateById(Integer id, Date alarm_date)
	{
		AlarmModule alarmModules = alarmModuleDao.findById(id).get();
		alarmModules.setAlarm_date(alarm_date);
		return alarmModuleDao.save(alarmModules);
	}
	
	@Override
	public AlarmModule updateAlarmNoteById(Integer id, String note)
	{
		AlarmModule alarmModules = alarmModuleDao.findById(id).get();
		alarmModules.setNotes(note);
		return alarmModuleDao.save(alarmModules);
	}
	
	@Override
	public boolean deleteAlarmById(Integer id)
	{
		alarmModuleDao.deleteById(id);
		AlarmModule alarmModule = alarmModuleDao.findById(id).get();
		if(null == alarmModule)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public AlarmModule createAlarm(AlarmModule alarmModule)
	{
		return alarmModuleDao.save(alarmModule);
	}
	
	
}
*/