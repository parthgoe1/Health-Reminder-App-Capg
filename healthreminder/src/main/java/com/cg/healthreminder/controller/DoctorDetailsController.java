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
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthreminder.exception.AllCustomException;
import com.cg.healthreminder.model.DoctorDetails;
import com.cg.healthreminder.services.DoctorDetailsService;

@RestController
@RequestMapping("/doctor")
public class DoctorDetailsController {
	
	@Autowired
    private DoctorDetailsService doctorDetailsService;
	
	@GetMapping("/getAllDoctors")
    public List<DoctorDetails> getAllDoctors() throws AllCustomException{
        return (List<DoctorDetails>) doctorDetailsService.getAllDoctorDetails();
    }
	
	@GetMapping("/getDoctorById/{doctorId}")
    public DoctorDetails getDoctorById(@PathVariable Integer doctorId) throws AllCustomException{
        return doctorDetailsService.findDoctorById(doctorId);
    }
	
	@GetMapping("/getDoctorByName/{doctorName}")
    public DoctorDetails getDoctorByName(@PathVariable String doctorName) throws AllCustomException{
        return doctorDetailsService.findDoctorByName(doctorName);
    }
	
	@PutMapping("/updateDoctorNamebyId/{doctorName}/doctor/{doctorId}")
    public DoctorDetails updateDoctorById(@PathVariable String doctorName, @PathVariable Integer doctorId) throws AllCustomException{
        return doctorDetailsService.updateDocNameById(doctorId, doctorName);
    }
	
	@PostMapping("/createDoctor")
    public DoctorDetails createDoctor(@RequestBody DoctorDetails doctor){
        return doctorDetailsService.createDoctor(doctor);
    }
	
	@DeleteMapping("/deleteDoctorById/doctor/{doctorId}")
    public DoctorDetails deleteDoctorById(@PathVariable Integer doctorId) throws AllCustomException{
        return doctorDetailsService.deleteDoctorById(doctorId);
    }

	
}
