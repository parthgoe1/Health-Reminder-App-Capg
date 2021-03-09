package com.cg.healthreminder.services.impl;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.healthreminder.dao.AlarmModuleDao;
import com.cg.healthreminder.model.AlarmModule;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@Transactional
public class AlarmModuleServiceImpl implements com.cg.healthreminder.services.AlarmModuleService {
	
	@Autowired
	private AlarmModuleDao alarmModuleDao;
	
	@Override
	public AlarmModule findAlarmById(Integer id)
	{
		return alarmModuleDao.findAlarmById(id);
	}
	
	@Override
	public AlarmModule findAlarmByName(String alarm_name)
	{
		return alarmModuleDao.findAlarmByName(alarm_name);
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
		alarmModules.setAlarmName(name);
		return alarmModuleDao.save(alarmModules);
	}
	
	@Override
	public AlarmModule updateAlarmTimeById(Integer id, Timestamp alarm_time)
	{
		AlarmModule alarmModules = alarmModuleDao.findById(id).get();
		alarmModules.setAlarmTime(alarm_time);
		return alarmModuleDao.save(alarmModules);
	}
	
	@Override
	public AlarmModule updateAlarmDateById(Integer id, Date alarm_date)
	{
		AlarmModule alarmModules = alarmModuleDao.findById(id).get();
		alarmModules.setAlarmDate(alarm_date);
		return alarmModuleDao.save(alarmModules);
	}
	
	@Override
	public AlarmModule updateAlarmNoteById(Integer id, String note)
	{
		AlarmModule alarmModules = alarmModuleDao.findById(id).get();
		alarmModules.setAlarmNotes(note);
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
