package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.healthreminder.model.AlarmModule;


public interface AlarmModuleDao extends JpaRepository<AlarmModule,Integer>{

	@Query("select a from Alarm_Module a where t.alarm_id=:alarm_id")
	AlarmModule findAlarmById(Integer id);
	
	@Query("select a from Alarm_Module a where t.alarm_name=:alarm_name")
	AlarmModule findAlarmByName(String name);
	
//	@Query("select * from Alarm_Module a )
//	AlarmModule getAllAlarms();
	
}
