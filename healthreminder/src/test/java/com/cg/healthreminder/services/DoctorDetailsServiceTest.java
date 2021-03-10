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

import com.cg.healthreminder.dao.DoctorDetailsDao;
import com.cg.healthreminder.model.DietInfo;
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
    
//    @Test
//    public void testGetDoctorById() throws Exception{
//    	DoctorDetails doctorDetails = new DoctorDetails();
//    	doctorDetails.setDoctorId(210);
//    	doctorDetails.setDoctorName("Dr. Kusum");
//    	doctorDetails.setDoctorSpec("Surgeon");
//    	doctorDetails.setDoctorCertFile("True");
//    	doctorDetails.setVerfStatus(true);
//    	
//    	DoctorDetails d2 = doctorDetailsDao.findById(210).get();
//        Mockito.when(d2).thenReturn(doctorDetails);
//        assertThat(doctorDetailsService.findDoctorById(null)).isEqualTo(doctorDetails);
//    }
    
    
    @Test
    public void testFindByDoctorSpec() throws Exception{
    	DoctorDetails doctorDetails = new DoctorDetails();
    	doctorDetails.setDoctorId(210);
    	doctorDetails.setDoctorName("Dr. Kusum");
    	doctorDetails.setDoctorSpec("Surgeon");
    	doctorDetails.setDoctorCertFile("True");
    	doctorDetails.setVerfStatus(true);
	  
	  Mockito.when(doctorDetailsDao.findDoctorBySpec("Surgeon")).thenReturn(doctorDetails);
      assertThat(doctorDetailsService.findDoctorBySpec("Surgeon")).isEqualTo(doctorDetails);
    }
    
    @Test
    public void testGetAllDoctors() throws Exception{
    	DoctorDetails d1 = new DoctorDetails();
    	d1.setDoctorId(210);
    	d1.setDoctorName("Dr. Kusum");
    	d1.setDoctorSpec("Surgeon");
    	d1.setDoctorCertFile("M.B.B.S");
    	d1.setVerfStatus(true);

    	DoctorDetails d2 = new DoctorDetails();
    	d2.setDoctorId(212);
    	d2.setDoctorName("Dr. Kamlesh");
    	d2.setDoctorSpec("Neuro Surgeon");
    	d2.setDoctorCertFile("General");
    	d2.setVerfStatus(true);
        
        List<DoctorDetails> doctorList = new ArrayList<>();
        doctorList.add(d1);
        doctorList.add(d2);

        Mockito.when(doctorDetailsDao.findAll()).thenReturn(doctorList);
        assertThat(doctorDetailsService.getAllDoctorDetails()).isEqualTo(doctorList);
    
    }
    
//    @Test
//    public void testDeleteDoctorById() throws Exception{
//    	DoctorDetails doctorDetails = new DoctorDetails();
//    	doctorDetails.setDoctorId(210);
//    	doctorDetails.setDoctorName("Dr. Kusum");
//    	doctorDetails.setDoctorSpec("Surgeon");
//    	doctorDetails.setDoctorCertFile("True");
//    	doctorDetails.setVerfStatus(true);
//        
//        Mockito.when(doctorDetailsDao.save(doctorDetails)).thenReturn(doctorDetails);
//        Mockito.when(doctorDetailsDao.findById(210).get()).thenReturn(doctorDetails);
//        doctorDetailsDao.deleteById(doctorDetails.getDoctorId());
//        Mockito.when(doctorDetailsDao.findById(210).get()).thenReturn(doctorDetails);
//        Assert.assertNotEquals(doctorDetails, new DoctorDetails());
//        Assert.assertEquals(doctorDetailsService.deleteDoctorById(210), false);
//    }
    
    
}
