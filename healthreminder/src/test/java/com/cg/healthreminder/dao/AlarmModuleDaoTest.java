package com.cg.healthreminder.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthreminder.model.AlarmModule;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AlarmModuleDaoTest {

	@Autowired
    private AlarmModuleDao alarmModuleDao;

    @Autowired
    private TestEntityManager testEntityManager;
    
    private AlarmModule getAlarmDetails() {
    	AlarmModule a= new AlarmModule();
    	a.setPatientId(102);
    	a.setAlarmName("Back Pain Medicine");
    	a.setAlarmDate(null);
    	a.setAlarmTime(null);
    	a.setAlarmNotes("Take the medicine after lunch");
		 
		 return a;
	 }
    
    @Test
	 public void testNewAlarmModuleDetails() throws Exception{
    	AlarmModule alarm = getAlarmDetails();
    	AlarmModule saveInDb = testEntityManager.persist(alarm);
    	AlarmModule getFromInDb = alarmModuleDao.findById(saveInDb.getAlarmId()).get();
	    assertThat(getFromInDb).isEqualTo(saveInDb);
	 }
    
    @Test
	public void  testAlarmModuleDetailsByPatientId() throws Exception{
    	AlarmModule alarm = getAlarmDetails();
    	AlarmModule saveInDb = testEntityManager.persist(alarm);
    	AlarmModule getInDb = alarmModuleDao.findByPatientId(alarm.getPatientId());
	     assertThat(getInDb).isEqualTo(saveInDb);
	}
    
    @Test
    public void testDeleteAlarmModulesbyId() throws Exception{
    	
    	AlarmModule a1= new AlarmModule();
    	a1.setPatientId(103);
    	a1.setAlarmName("Fever Medicine");
    	a1.setAlarmDate(null);
    	a1.setAlarmTime(null);
    	a1.setAlarmNotes("Take the medicine after Dinner");
    	
    	
    	AlarmModule a2= new AlarmModule();
    	a2.setPatientId(104);
    	a2.setAlarmName("Headache Medicine");
    	a2.setAlarmDate(null);
    	a2.setAlarmTime(null);
    	a2.setAlarmNotes("Take the medicine after 2hrs of breakfast");
    	
    	AlarmModule alarmModule = testEntityManager.persist(a1);
    	testEntityManager.persist(a2);
    	
    	
    	//delete one ticket DB
    	testEntityManager.remove(alarmModule);
    	
    	List<AlarmModule> alarmList = (List<AlarmModule>) alarmModuleDao.findAll();
        Assert.assertEquals(alarmList.size(), 1);
    	
    	
    }
    
    
    
	
}
