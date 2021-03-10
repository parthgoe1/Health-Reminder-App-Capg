//AUTHOR --> Ankit Banerjee
package com.cg.healthreminder.services.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthreminder.dao.AlarmModuleDao;
import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.AlarmModule;

@Service
@Transactional
public class AlarmModuleServiceImpl implements com.cg.healthreminder.services.AlarmModuleService {
	
	public static String Excep = "AlarmModule not found";
	
	@Autowired
	private AlarmModuleDao alarmModuleDao;
	
	@Override
	public AlarmModule findAlarmById(Integer id)  throws AllCustomException
	{
		AlarmModule ob =  alarmModuleDao.findAlarmById(id);
		if(ob == null) {
			throw new AllCustomException(Excep);
		}
		
		return ob;
	}
	
	@Override
	public AlarmModule findAlarmByName(String alarmName)  throws AllCustomException
	{
		AlarmModule ob = alarmModuleDao.findAlarmByName(alarmName);
		if(ob == null) {
			throw new AllCustomException(Excep);
		}
		
		return ob;
	}
	
	@Override
	public Iterable<AlarmModule> getAllAlarms()
	{
		return alarmModuleDao.findAll();
	}
	
	@Override
	public AlarmModule updateAlarmById(Integer aid, Integer pid, String name, Timestamp alarmTime, Date alarmDate, String note) throws AllCustomException
	{
		Optional<AlarmModule> alarmModules = alarmModuleDao.findById(aid);
		AlarmModule ob = null;
		
		if(alarmModules.isPresent()) {
			
			ob = alarmModules.get();
			ob.setAlarmName(name);
			ob.setAlarmTime(alarmTime);
			ob.setAlarmDate(alarmDate);
			ob.setAlarmNotes(note);
		}
		else
		{
			throw new AllCustomException(Excep);
		}
		
		return alarmModuleDao.save(ob);
	}
	
	
	@Override
	public AlarmModule deleteAlarmById(Integer id)  throws AllCustomException
	{
		Optional<AlarmModule> alarmModule = alarmModuleDao.findById(id);
		AlarmModule ob = null;
		if(alarmModule.isPresent()) {
			
			ob = alarmModule.get();
			alarmModuleDao.delete(ob);
		}
		else {
			throw new AllCustomException(Excep);
			
		}
		
		return ob;
	}
	
	@Override
	public AlarmModule createAlarm(AlarmModule alarmModule)
	{
		return alarmModuleDao.save(alarmModule);
	}
	
	
}
