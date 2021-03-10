//AUTHOR --> Ankit Banerjee
package com.cg.healthreminder.services;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.cg.healthreminder.dao.AlarmModuleDao;
import com.cg.healthreminder.model.AlarmModule;
import com.cg.healthreminder.services.AlarmModuleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlarmModuleServiceTest {

	@MockBean
    private AlarmModuleDao alarmModuleDao;

	@Autowired
    private AlarmModuleService alarmModuleService;
    
	@Test
    public void testCreateAlarmModule() {
    	AlarmModule a= new AlarmModule();
    	a.setAlarmId(103);
    	a.setPatientId(1001);
    	a.setAlarmName("Back Medicine");
    	a.setAlarmDate(null);
    	a.setAlarmTime(null);
    	a.setAlarmNotes("Take the medicine after dinner");
		 
    	Mockito.when(alarmModuleDao.save(a)).thenReturn(a);
        assertThat(alarmModuleService.createAlarm(a)).isEqualTo(a);
    }
    
	@Test
    public void testGetAlarmModuleById() throws Exception{
		AlarmModule alarm = new AlarmModule();
		alarm.setAlarmId(104);
		alarm.setPatientId(1002);
		alarm.setAlarmName("Lung Medicine");
		alarm.setAlarmDate(null);
		alarm.setAlarmTime(null);
		alarm.setAlarmNotes("Take Medicine regularly");
    	
		AlarmModule a2 = alarmModuleDao.findById(103).get();
        Mockito.when(a2).thenReturn(alarm);
        assertThat(alarmModuleService.findAlarmById(103)).isEqualTo(alarm);
    }
	
	
}
