//Author - Ankit Banerjee
package com.cg.healthreminder.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.AlarmModule;
import com.cg.healthreminder.services.AlarmModuleService;

@RestController
@RequestMapping("/alarm")
public class AlarmModuleController {

	@Autowired
    private AlarmModuleService alarmModuleService;
	
	@GetMapping("/getAllAlarms")
    public List<AlarmModule> getAllAlarms() throws AllCustomException{
        return (List<AlarmModule>) alarmModuleService.getAllAlarms();
    }
	
	@GetMapping("/getAlarmById/{alarmId}")
    public AlarmModule getAlarmById(@PathVariable Integer alarmId) throws AllCustomException{
        return alarmModuleService.findAlarmById(alarmId);
    }
	
	@GetMapping("/getAlarmByName/{alarmName}")
    public AlarmModule getAlarmByEmail(@PathVariable String alarmName) throws AllCustomException{
        return alarmModuleService.findAlarmByName(alarmName);
    }
	
	@PutMapping("/updateAlarmbyId/{alarmId}/{patientId}/{alarmName}/{alarmTime}/{alarmDate}/{alarmNotes}")
    public AlarmModule updateAlarmById(@PathVariable Integer alarmId, @PathVariable Integer patientId,@PathVariable String alarmName,
    		@PathVariable Timestamp alarmTime,@PathVariable Date alarmDate, @PathVariable String alarmNotes) throws AllCustomException{
        return alarmModuleService.updateAlarmById(alarmId, patientId, alarmName, alarmTime, alarmDate, alarmNotes);
    }
	
	
	@PostMapping("/createAlarm")
    public AlarmModule createAlarm(@RequestBody AlarmModule alarm){
        return alarmModuleService.createAlarm(alarm);
    }
	
	@DeleteMapping("/deleteAlarmById/alarm/{alarmId}")
    public AlarmModule deleteAlarmById(@PathVariable Integer alarmId) throws AllCustomException{
        return alarmModuleService.deleteAlarmById(alarmId);
    }
	
	
}
