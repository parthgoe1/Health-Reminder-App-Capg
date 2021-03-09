package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthreminder.model.FollowUpDietStatusInfo;

//Author --> Parth Goel

@Repository
public interface FollowUpDietStatusInfoJpaDao extends JpaRepository<FollowUpDietStatusInfo,Integer>{

}
