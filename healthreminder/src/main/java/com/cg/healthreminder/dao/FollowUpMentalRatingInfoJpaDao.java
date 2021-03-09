package com.cg.healthreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthreminder.model.FollowUpMentalRatingInfo;

//Author --> Parth Goel

@Repository
public interface FollowUpMentalRatingInfoJpaDao extends JpaRepository<FollowUpMentalRatingInfo,Integer>{

}
