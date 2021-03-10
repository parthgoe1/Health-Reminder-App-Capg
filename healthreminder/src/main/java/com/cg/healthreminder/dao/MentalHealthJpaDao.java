/*
 * Author-> Shania Dalal
 * This is the Repository Interface for performing JPA operations on mentalHealth model
 * 
 */
package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthreminder.model.MentalHealth;

@Repository
public interface MentalHealthJpaDao extends JpaRepository<MentalHealth,Integer>{

}

