package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthreminder.model.mentalHealth;

@Repository
public interface MentalHealthJpaDao extends JpaRepository<mentalHealth,Integer>{

}

