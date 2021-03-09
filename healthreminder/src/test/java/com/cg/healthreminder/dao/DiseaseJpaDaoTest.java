//author->Shania Dalal
/*package com.cg.healthreminder.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;



import static org.assertj.core.api.Assertions.assertThat;

import com.cg.healthreminder.model.AppointmentDetails;
import com.cg.healthreminder.model.Diseases;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DiseaseJpaDaoTest {
	 @Autowired
     private TestEntityManager testEntityManager;
	 @Autowired
     private DiseaseJpaDao diseaseJpaDao;
	 
	 private Diseases getDiseases() {
		 Diseases d=new Diseases();
		 d.setDiseaseId(5);
		 d.setDiseaseInfo("Cough");
		 d.setDiseaseInfo("Throat Irritation");
		 d.setDiseaseKeys("cough");
		 
		 return d;
	 }

	 @Test
	 public void testNewDiseases() throws Exception{
	     Diseases dLocal = getDiseases();
	     Diseases saveInDb = testEntityManager.merge(dLocal);
	     Diseases getFromInDb = diseaseJpaDao.findById(saveInDb.getDiseaseId()).get();
	     assertThat(getFromInDb).isEqualTo(saveInDb);
	 }
	 
	 @Test
	 public void testGetDiseasesByDiseaseId() throws Exception{
		 Diseases dLocal = getDiseases();
	     Diseases saveInDb = testEntityManager.persist(dLocal);
	     Diseases getFromInDb = diseaseJpaDao.findById(dLocal.getDiseaseId()).get();
	     assertThat(getFromInDb).isEqualTo(saveInDb);
	    }
	 
	 


} */
