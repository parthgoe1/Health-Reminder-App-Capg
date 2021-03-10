package com.cg.healthreminder.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthreminder.model.FollowUpMentalRatingInfo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Author --> Parth Goel

@RunWith(SpringRunner.class)
@DataJpaTest
public class FollowUpMentalRatingInfoJpaDaoTest {

	@Autowired
    private FollowUpMentalRatingInfoJpaDao followUpMentalRatingInfoJpaDao ;

    @Autowired
    private TestEntityManager testEntityManager;

    private FollowUpMentalRatingInfo getFollowUpMentalRatingInfo() {
    	FollowUpMentalRatingInfo followUpMentalRatingInfo = new FollowUpMentalRatingInfo();
    	followUpMentalRatingInfo.setPatientId(1);
    	followUpMentalRatingInfo.setMentalRating(3);
        return followUpMentalRatingInfo;
    }
    
    @Test
    public void testNewFollowUpMentalRating() throws Exception{
    	FollowUpMentalRatingInfo followUpMentalRatingInfo = getFollowUpMentalRatingInfo();
    	FollowUpMentalRatingInfo saveInDb = testEntityManager.persist(followUpMentalRatingInfo);
    	FollowUpMentalRatingInfo getFromInDb = followUpMentalRatingInfoJpaDao.findById(saveInDb.getPatientId()).get();
        assertThat(getFromInDb).isEqualTo(saveInDb);
    }
    
    @Test
    public void testGetFollowUpMentalRatingById() throws Exception{
    	FollowUpMentalRatingInfo followUpMentalRatingInfo = new FollowUpMentalRatingInfo();
    	followUpMentalRatingInfo.setPatientId(2);
    	followUpMentalRatingInfo.setMentalRating(5);
       
    	FollowUpMentalRatingInfo saveInDb = testEntityManager.persist(followUpMentalRatingInfo);
        
    	FollowUpMentalRatingInfo getInDb = followUpMentalRatingInfoJpaDao.findById(followUpMentalRatingInfo.getPatientId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
    }
    
    @Test
    public void testDeleteFollowUpMentalRatingInfoById() throws Exception{
    	FollowUpMentalRatingInfo followUpMentalRatingInfo1 = new FollowUpMentalRatingInfo();
    	followUpMentalRatingInfo1.setPatientId(2);
    	followUpMentalRatingInfo1.setMentalRating(3);
        
        FollowUpMentalRatingInfo followUpMentalRatingInfo2 = new FollowUpMentalRatingInfo();
        followUpMentalRatingInfo2.setPatientId(3);
        followUpMentalRatingInfo2.setMentalRating(4);

        FollowUpMentalRatingInfo followUpMentalRatingInfo = testEntityManager.persist(followUpMentalRatingInfo1);
        testEntityManager.persist(followUpMentalRatingInfo2);

        //delete one ticket DB
        testEntityManager.remove(followUpMentalRatingInfo);

        List<FollowUpMentalRatingInfo> followUpMentalRatingInfos = (List<FollowUpMentalRatingInfo>) followUpMentalRatingInfoJpaDao.findAll();
        Assert.assertEquals(followUpMentalRatingInfos.size(), 1);

    }
    
    @Test
    public void testUpdateFollowUpMentalRatingInfo(){

    	FollowUpMentalRatingInfo followUpMentalRatingInfo = new FollowUpMentalRatingInfo();
    	followUpMentalRatingInfo.setPatientId(3);
    	followUpMentalRatingInfo.setMentalRating(3);
        
        testEntityManager.persist(followUpMentalRatingInfo);

        FollowUpMentalRatingInfo getFromDb = followUpMentalRatingInfoJpaDao.findById(3).get();
        getFromDb.setMentalRating(2);
        testEntityManager.persist(getFromDb);

        assertThat(getFromDb.getMentalRating()).isEqualTo(2);
    }



}
