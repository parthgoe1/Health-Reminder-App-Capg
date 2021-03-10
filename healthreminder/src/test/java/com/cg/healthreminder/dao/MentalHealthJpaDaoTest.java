/*
 * Author-> Shania Dalal
 * This is the Test class that checks all CRUD operations performed using JPA properties
 * on the mentalHealth model
 * 
*/
package com.cg.healthreminder.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;



import static org.assertj.core.api.Assertions.assertThat;
import com.cg.healthreminder.model.mentalHealth;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MentalHealthJpaDaoTest {
	 @Autowired
     private TestEntityManager testEntityManager;
	 @Autowired
     private MentalHealthJpaDao mentalJpaDao;
	 
	 private mentalHealth getTips() {
		 mentalHealth m=new mentalHealth();
		 m.setMentalRating(5);
		 m.setMentalTip("You need to eat chocolate");
		 return m;
	 }

	 @Test
	 public void testNewTips() throws Exception{
	     mentalHealth mLocal = getTips();
	     mentalHealth saveInDb = testEntityManager.persist(mLocal);
	     mentalHealth getFromInDb = mentalJpaDao.findById(saveInDb.getMentalRating()).get();
	     assertThat(getFromInDb).isEqualTo(saveInDb);
	     assertThat(getFromInDb.toString()).isEqualTo(saveInDb.toString());
	     assertThat(getFromInDb.getMentalTip()).isEqualTo(saveInDb.getMentalTip());
	 }
	 


} 
