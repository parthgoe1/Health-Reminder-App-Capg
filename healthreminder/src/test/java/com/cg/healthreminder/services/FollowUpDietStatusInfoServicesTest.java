package com.cg.healthreminder.services;

import com.cg.healthreminder.dao.FollowUpDietStatusInfoJpaDao;
import com.cg.healthreminder.model.DietInfo;
import com.cg.healthreminder.model.FollowUpDietStatusInfo;
import com.cg.healthreminder.services.FollowUpDietStatusInfoServices;


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

import static org.assertj.core.api.Assertions.assertThat;

// Author --> Parth Goel

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowUpDietStatusInfoServicesTest {

	@MockBean
    private FollowUpDietStatusInfoJpaDao followUpDietStatusInfoJpaDao;

    @Autowired
    private FollowUpDietStatusInfoServices followUpDietStatusInfoServices;
    
    @Test
    public void testCreateDietStatus(){
        FollowUpDietStatusInfo followUpDietStatusInfo = new FollowUpDietStatusInfo();
        followUpDietStatusInfo.setPatientId(3);
        followUpDietStatusInfo.setDietStatus(true);

        Mockito.when(followUpDietStatusInfoJpaDao.save(followUpDietStatusInfo)).thenReturn(followUpDietStatusInfo);
        assertThat(followUpDietStatusInfoServices.createDietStatus(followUpDietStatusInfo)).isEqualTo(followUpDietStatusInfo);
    }

}
