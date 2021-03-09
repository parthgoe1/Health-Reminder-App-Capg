package com.cg.healthreminder.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthreminder.model.DietInfo;
import com.cg.healthreminder.model.FollowUpDietStatusInfo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Author --> Parth Goel

@RunWith(SpringRunner.class)
@DataJpaTest
public class FollowUpDietStatusInfoJpaDaoTest {

	@Autowired
    private FollowUpDietStatusInfoJpaDao followUpDietStatusInfoJpaDao ;

    @Autowired
    private TestEntityManager testEntityManager;

    private FollowUpDietStatusInfo getFollowUpDietStatusInfo() {
    	FollowUpDietStatusInfo followUpDietStatusInfo = new FollowUpDietStatusInfo();
    	followUpDietStatusInfo.setPatientId(1);
    	followUpDietStatusInfo.setDietStatus(true);
        return followUpDietStatusInfo;
    }
    
    @Test
    public void testNewFollowUpDiet() throws Exception{
    	FollowUpDietStatusInfo followUpDietStatusInfo = getFollowUpDietStatusInfo();
    	FollowUpDietStatusInfo saveInDb = testEntityManager.persist(followUpDietStatusInfo);
    	FollowUpDietStatusInfo getFromInDb = followUpDietStatusInfoJpaDao.findById(saveInDb.getPatientId()).get();
        assertThat(getFromInDb).isEqualTo(saveInDb);
    }
    
}
