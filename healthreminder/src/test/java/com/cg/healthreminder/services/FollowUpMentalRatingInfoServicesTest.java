package com.cg.healthreminder.services;

import com.cg.healthreminder.dao.FollowUpMentalRatingInfoJpaDao;
import com.cg.healthreminder.model.DietInfo;
import com.cg.healthreminder.model.FollowUpMentalRatingInfo;
import com.cg.healthreminder.services.FollowUpMentalRatingInfoServices;


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
public class FollowUpMentalRatingInfoServicesTest {

	@MockBean
    private FollowUpMentalRatingInfoJpaDao followUpMentalRatingInfoJpaDao;

    @Autowired
    private FollowUpMentalRatingInfoServices followUpMentalRatingInfoServices;
    
    @Test
    public void testCreateMentalRating(){
        FollowUpMentalRatingInfo followUpMentalRatingInfo = new FollowUpMentalRatingInfo();
        followUpMentalRatingInfo.setPatientId(3);
        followUpMentalRatingInfo.setMentalRating(5);

        Mockito.when(followUpMentalRatingInfoJpaDao.save(followUpMentalRatingInfo)).thenReturn(followUpMentalRatingInfo);
        assertThat(followUpMentalRatingInfoServices.createMentalRating(followUpMentalRatingInfo)).isEqualTo(followUpMentalRatingInfo);
    }

}
