/*
 * Author-> Shania Dalal
 * This is the Repository Interface for performing JPA operations on Diseases model
 * 
 */
package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.healthreminder.model.Diseases;

@Repository
public interface DiseaseJpaDao extends JpaRepository<Diseases,Integer>{

}
