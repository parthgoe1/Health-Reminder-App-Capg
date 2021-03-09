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

import com.cg.healthreminder.model.DoctorDetails;


@RunWith(SpringRunner.class)
@DataJpaTest
public class DoctorDetailsDaoTest {

	@Autowired
    private DoctorDetailsDao doctorDetailsDao;

    @Autowired
    private TestEntityManager testEntityManager;
    
    private DoctorDetails getDoctorDetails() {
    	
    	DoctorDetails d= new DoctorDetails();
    	d.setDoctorName("Dr. Ankit");
    	d.setDoctorSpec("Dentist");
    	d.setDoctorCertFile("M.B.B.S");
    	d.setVerfStatus(true);
    	
		return d;
	}
    
    @Test
	public void testNewDoctorDetails() throws Exception{
    	DoctorDetails doctor = getDoctorDetails();
    	DoctorDetails saveInDb = testEntityManager.persist(doctor);
    	DoctorDetails getFromInDb = doctorDetailsDao.findById(saveInDb.getDoctorId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
	}
    
    @Test
    public void testDeleteDoctorbyId() throws Exception{
    	
    	DoctorDetails d1 = new DoctorDetails();
    	d1.setDoctorName("Dr. Suman");
    	d1.setDoctorSpec("Child Spec");
    	d1.setDoctorCertFile("Local University");
    	d1.setVerfStatus(true);
    	
    	DoctorDetails d2 = new DoctorDetails();
    	d2.setDoctorName("Dr. Suman");
    	d2.setDoctorSpec("Child Spec");
    	d2.setDoctorCertFile("Local University");
    	d2.setVerfStatus(true);
    	
    	DoctorDetails doctodetails = testEntityManager.persist(d1);
    	testEntityManager.persist(d2);
    	
    	
    	//delete one ticket DB
    	testEntityManager.remove(doctodetails);
    	
    	List<DoctorDetails> alarmList = (List<DoctorDetails>) doctorDetailsDao.findAll();
        Assert.assertEquals(alarmList.size(), 1);
    	
    	
    }
	
    
	
	
}
