package com.cg.healthreminder.controller;

import java.util.List;

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

import com.cg.healthreminder.model.DietInfo;
import com.cg.healthreminder.services.DietInfoServices;

//Author --> Parth Goel

@RestController
@RequestMapping("/healthreminder")
public class DietInfoController {

	@Autowired
	private DietInfoServices dietInfoService;
	
	//To find a particular diet using bmi
	@GetMapping("/diet_info_find/{bmi}")
	public DietInfo findDietByBMI(@PathVariable Integer bmi) {
		return this.dietInfoService.findDietByBMI(bmi);
	}
	
	//To find list of all diets
	@GetMapping("/diet_info_find_all")
	public Iterable<DietInfo> getAllDiets(){
		return this.dietInfoService.getAllDiets();
	}
	
	//To update diet details
	@PutMapping("/diet_info_update/{bmiValue}/info/{dietInformation}")
	public DietInfo updateDietByBMI(@PathVariable Integer bmiValue, @PathVariable String dietInformation) {
		return this.dietInfoService.updateDietByBMI(bmiValue, dietInformation);
	}
	
	//To delete diet details
	@DeleteMapping("/delete_diet_by_bmi/{bmiValue}")
    public boolean deleteDietByBMI(@PathVariable Integer bmiValue){
        return dietInfoService.deleteDietByBMI(bmiValue);
    }
	
	 @PostMapping("/create_diet")
	    public DietInfo createDiet(@RequestBody DietInfo dietInfo){
	        return dietInfoService.createDiet(dietInfo);
	    }
	
}
