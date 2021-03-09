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

import com.cg.healthreminder.dao.DoctorDetailsDao;
import com.cg.healthreminder.model.DoctorDetails;
import com.cg.healthreminder.services.DoctorDetailsService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorDetailsServiceTest {
	
	@MockBean
    private DoctorDetailsDao doctorDetailsDao;

    @Autowired
    private DoctorDetailsService doctorDetailsService;
	
    @Test
    public void testCreateDoctor(){
    	DoctorDetails doctorDetails = new DoctorDetails();
    	doctorDetails.setDoctorId(210);
    	doctorDetails.setDoctorName("Dr. Kusum");
    	doctorDetails.setDoctorSpec("Surgeon");
    	doctorDetails.setDoctorCertFile("True");
    	doctorDetails.setVerfStatus(true);
    	

        Mockito.when(doctorDetailsDao.save(doctorDetails)).thenReturn(doctorDetails);
        assertThat(doctorDetailsService.createDoctor(doctorDetails)).isEqualTo(doctorDetails);
    }
    
    
}
