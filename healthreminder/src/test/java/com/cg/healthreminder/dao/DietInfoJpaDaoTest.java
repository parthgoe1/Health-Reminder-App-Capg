package com.cg.healthreminder.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthreminder.model.DietInfo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Author --> Parth Goel

@RunWith(SpringRunner.class)
@DataJpaTest
public class DietInfoJpaDaoTest {
	
	@Autowired
    private DietInfoJpaDao dietInfoJpaDao;

    @Autowired
    private TestEntityManager testEntityManager;
    
    private DietInfo getDietInfo() {
    	DietInfo dietInfo = new DietInfo();
    	dietInfo.setBmiValue(1);
    	dietInfo.setDiet("pizza");
        
        return dietInfo;
    }
    
    @Test
    public void testNewDiet() throws Exception{
        DietInfo dietInfo = getDietInfo();
        DietInfo saveInDb = testEntityManager.persist(dietInfo);
        DietInfo getFromInDb = dietInfoJpaDao.findById(saveInDb.getBmiValue()).get();
        assertThat(getFromInDb).isEqualTo(saveInDb);
        assertThat(getFromInDb.toString()).hasToString(saveInDb.toString());
    }
    
    @Test
    public void testGetDietByBMI() throws Exception{
        DietInfo dietInfo = new DietInfo();
        dietInfo.setBmiValue(2);
        dietInfo.setDiet("Burger");
       
        DietInfo saveInDb = testEntityManager.persist(dietInfo);
        
        DietInfo getInDb = dietInfoJpaDao.findById(dietInfo.getBmiValue()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
    }
    
    @Test
    public void testGetAllDietInfo() throws Exception{
        DietInfo dietInfo1  = new DietInfo();
        dietInfo1.setBmiValue(4);
        dietInfo1.setDiet("Tophee");
        
        DietInfo dietInfo2 = new DietInfo();
        dietInfo2.setBmiValue(1);
        dietInfo2.setDiet("Chocolate");

        testEntityManager.persist(dietInfo1);
        testEntityManager.persist(dietInfo2);

        List<DietInfo> dietInfoList = (List<DietInfo>) dietInfoJpaDao.findAll();

        Assert.assertEquals(2, dietInfoList.size());
    }
    
    @Test
    public void testDeleteDietInfoByBMI() throws Exception{
    	DietInfo dietInfo1 = new DietInfo();
    	dietInfo1.setBmiValue(4);
        dietInfo1.setDiet("Tophee");
        
        DietInfo dietInfo2 = new DietInfo();
        dietInfo2.setBmiValue(1);
        dietInfo2.setDiet("Chocolate");

        DietInfo dietInfo = testEntityManager.persist(dietInfo1);
        testEntityManager.persist(dietInfo2);

        //delete one ticket DB
        testEntityManager.remove(dietInfo);

        List<DietInfo> dietInfos = (List<DietInfo>) dietInfoJpaDao.findAll();
        Assert.assertEquals(1, dietInfos.size());

    }
    
    @Test
    public void testUpdateDietInfo(){

        DietInfo dietInfo = new DietInfo();
        dietInfo.setBmiValue(4);
        dietInfo.setDiet("Tophee");
        
        testEntityManager.persist(dietInfo);

        DietInfo getFromDb = dietInfoJpaDao.findById(4).get();
        getFromDb.setDiet("pizza");
        testEntityManager.persist(getFromDb);

        assertThat(getFromDb.getDiet()).isEqualTo("pizza");
    }


	
}
