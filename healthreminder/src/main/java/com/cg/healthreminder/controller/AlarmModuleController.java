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

import com.cg.healthreminder.model.AlarmModule;
import com.cg.healthreminder.services.AlarmModuleService;

@RestController
@RequestMapping("/alarm")
public class AlarmModuleController {

	@Autowired
    private AlarmModuleService alarmModuleService;
	
	@GetMapping("/getAllAlarms")
    public List<AlarmModule> getAllAlarms(){
        return (List<AlarmModule>) alarmModuleService.getAllAlarms();
    }
	
	@GetMapping("/getAlarmById/{alarmId}")
    public AlarmModule getAlarmById(@PathVariable Integer alarmId){
        return alarmModuleService.findAlarmById(alarmId);
    }
	
	@GetMapping("/getAlarmByName/{alarmName}")
    public AlarmModule getAlarmByEmail(@PathVariable String alarmName){
        return alarmModuleService.findAlarmByName(alarmName);
    }
	
	@PutMapping("/updateAlarmNamebyId/{alarmName}/alarm/{alarmId}")
    public AlarmModule updateAlarmById(@PathVariable String alarmName, @PathVariable Integer alarmId){
        return alarmModuleService.updateAlarmNameById(alarmId, alarmName);
    }
	
	@PostMapping("/createAlarm")
    public AlarmModule createAlarm(@RequestBody AlarmModule alarm){
        return alarmModuleService.createAlarm(alarm);
    }
	
	@DeleteMapping("/deleteAlarmById/alarm/{alarmId}")
    public boolean deleteAlarmById(@PathVariable Integer alarmId){
        return alarmModuleService.deleteAlarmById(alarmId);
    }
	
	
}
