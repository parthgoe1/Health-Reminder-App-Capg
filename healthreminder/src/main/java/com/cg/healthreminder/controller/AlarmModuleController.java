package com.cg.healthreminder.controller;

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
	
	@PutMapping("/updateAlarmNamebyId/{alarmName}/alarm/{alarmId}")
    public AlarmModule updateAlarmById(@PathVariable String alarmName, @PathVariable Integer alarmId) throws AllCustomException{
        return alarmModuleService.updateAlarmNameById(alarmId, alarmName);
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
