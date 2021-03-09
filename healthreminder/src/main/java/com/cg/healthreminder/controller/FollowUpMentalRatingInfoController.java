package com.cg.healthreminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.FollowUpMentalRatingInfo;
import com.cg.healthreminder.services.FollowUpMentalRatingInfoServices;

//Author --> Parth Goel

@RestController
@RequestMapping("/healthreminder")
public class FollowUpMentalRatingInfoController {

	@Autowired
	private FollowUpMentalRatingInfoServices followUpMentalRatingInfoServices;
	
	//To find a particular follow up mental rating using id
	@GetMapping("/followup_mentalrating_find/{patientId}")
	public FollowUpMentalRatingInfo findMentalRatingById(@PathVariable Integer patientId) throws AllCustomException{
		return this.followUpMentalRatingInfoServices.findMentalRatingById(patientId);
	}
	
	//To update follow up mental rating details
	@PutMapping("/followup_mentalrating_update/{patientId}/rating/{MentalRating}")
	public FollowUpMentalRatingInfo updateMentalRatingById(@PathVariable Integer patientId, @PathVariable Integer MentalRating) throws AllCustomException{
		return this.followUpMentalRatingInfoServices.updateMentalRatingById(patientId, MentalRating);
	}
		
	//To create follow up mental rating details
	@PostMapping("/create_followup_mentalrating")
	public FollowUpMentalRatingInfo createMentalRating(@RequestBody FollowUpMentalRatingInfo followUpMentalRatingInfo) {
		return followUpMentalRatingInfoServices.createMentalRating(followUpMentalRatingInfo);
	}
		
	//To delete follow up mental rating details
	@DeleteMapping("/delete_mentalrating_by_id/{patientId}")
    public boolean deleteMentalRating(@PathVariable Integer patientId) throws AllCustomException{
        return followUpMentalRatingInfoServices.deleteMentalRating(patientId);
    }
}
