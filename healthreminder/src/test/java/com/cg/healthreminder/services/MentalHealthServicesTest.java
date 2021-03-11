/*
 * Author-> Shania Dalal
 * This is the Junit Test class that checks all Service Class operations performed
 * on the mentalHealth model
 * 
*/
package com.cg.healthreminder.services;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.cg.healthreminder.dao.MentalHealthJpaDao;
import com.cg.healthreminder.model.MentalHealth;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @ShaniaDalal
 * 
 * This is the Test Class for Disease Service Implementation Class
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MentalHealthServicesTest {
	  
	  @MockBean
	  private MentalHealthJpaDao mentalJpaDao;

	  @Autowired
	  private MentalHealthServices mentalServices;
	  
	  /**
	   * To test adding a MentalHealth Tip
	   */
	  @Test
	    public void testAddTips(){
		  MentalHealth m=new MentalHealth();
		  m.setMentalRating(5);
		  m.setMentalTip("You need to eat chocolate");

		  Mockito.when(mentalJpaDao.save(m)).thenReturn(m);
        assertThat(mentalServices.addTips(m)).isEqualTo(m);
	    } 
	  
	  
//	  @Autowired
//	    private TestEntityManager entityManager;
//	  
//	  @Test
//	 // @Rollback(false)
//	    public void testGetDiseaseById() throws Exception{
//		  Diseases d=new Diseases();
//		  d.setDiseaseId(3);
//		  d.setDiseaseName("Fracture");
//		  d.setDiseaseInfo("Broken");
//		  d.setDiseaseKeys("bones");
//		  Diseases dd=diseaseJpaDao.findById(3).get();
//		  System.out.println(dd + "top");
//		  Mockito.when(dd).thenReturn(d);
//		  System.out.println(d+"local");
//		  assertThat(diseaseServices.viewDisease(3)).isEqualTo(d);
//	    } 
	  
	/*  @Test
	    public void testUpdateDisease() throws Exception{
		  Diseases d=new Diseases();
		  d.setDiseaseId(4);
		  d.setDiseaseName("Sinus");
		  d.setDiseaseInfo("Phlegm in head");
		  d.setDiseaseKeys("cold");
		  
		  Mockito.when(diseaseJpaDao.findById(4).get()).thenReturn(d);
		  d.setDiseaseInfo("Too much Phlegm");
		  Mockito.when(diseaseJpaDao.save(d)).thenReturn(d);
		  System.out.println(d);
		  assertThat(diseaseServices.updateDiseaseInfo(4, "Too much Phlegm")).isEqualTo(d);
	    } */	  

	}

