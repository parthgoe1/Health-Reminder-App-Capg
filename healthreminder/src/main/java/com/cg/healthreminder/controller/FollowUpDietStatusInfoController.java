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
import com.cg.healthreminder.model.FollowUpDietStatusInfo;
import com.cg.healthreminder.services.FollowUpDietStatusInfoServices;

//Author --> Parth Goel

@RestController
@RequestMapping("/healthreminder")
public class FollowUpDietStatusInfoController {

	@Autowired
	private FollowUpDietStatusInfoServices followUpDietStatusInfoServices;
	
	//To find a particular follow up diet status using id
	@GetMapping("/followup_dietstatus_find/{patientId}")
	public FollowUpDietStatusInfo findDietStatusById(@PathVariable Integer patientId) throws AllCustomException{
		return this.followUpDietStatusInfoServices.findDietStatusById(patientId);
	}
	
	//To update follow up diet details
	@PutMapping("/followup_dietstatus_update/{patientId}/status/{dietStatus}")
	public FollowUpDietStatusInfo updateDietStatusById(@PathVariable Integer patientId, @PathVariable Boolean dietStatus) throws AllCustomException{
		return this.followUpDietStatusInfoServices.updateDietStatusById(patientId, dietStatus);
	}
	
	//To create follow up diet details
	@PostMapping("/create_followup_dietstatus")
	public FollowUpDietStatusInfo createDietStatus(@RequestBody FollowUpDietStatusInfo followUpDietStatusInfo) {
		return followUpDietStatusInfoServices.createDietStatus(followUpDietStatusInfo);
	}
	
	//To delete follow up diet details
	@DeleteMapping("/delete_dietstatus_by_id/{patientId}")
    public boolean deleteDietStatus(@PathVariable Integer patientId) throws AllCustomException{
        return followUpDietStatusInfoServices.deleteDietStatus(patientId);
    }

	
}
