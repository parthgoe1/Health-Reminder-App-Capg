package com.cg.healthreminder.services;

import com.cg.healthreminder.dao.DietInfoJpaDao;
import com.cg.healthreminder.model.DietInfo;
import com.cg.healthreminder.services.DietInfoServices;

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
public class DietInfoServicesTest {

    @MockBean
    private DietInfoJpaDao dietInfoJpaDao;

    @Autowired
    private DietInfoServices dietInfoServices;
    
    @Test
    public void testCreateDiet(){
        DietInfo dietInfo = new DietInfo();
        dietInfo.setBmiValue(3);
        dietInfo.setDietInfo("Pizza, pizza, pizza");

        Mockito.when(dietInfoJpaDao.save(dietInfo)).thenReturn(dietInfo);
        assertThat(dietInfoServices.createDiet(dietInfo)).isEqualTo(dietInfo);
    }
    
    @Test
    public void testFindDietByBMI() throws Exception{
        DietInfo dietInfo = new DietInfo();
        dietInfo.setBmiValue(2);
        dietInfo.setDietInfo("Burgers, Burgers, Burgers");
        DietInfo di = dietInfoJpaDao.findById(2).get();
        Mockito.when(di).thenReturn(dietInfo);
        assertThat(dietInfoServices.findDietByBMI(2)).isEqualTo(dietInfo);
    }

}
