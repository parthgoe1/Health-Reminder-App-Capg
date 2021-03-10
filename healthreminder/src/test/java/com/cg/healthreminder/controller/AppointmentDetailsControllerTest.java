/*
 * Author-> Sayantan Das
 * This class is a junit test class for testing the Appointment Details Controller class and services
 */


package com.cg.healthreminder.controller;
import com.cg.healthreminder.model.AppointmentDetails;
import com.cg.healthreminder.services.AppointmentDetailsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AppointmentDetailsController.class)
public class AppointmentDetailsControllerTest {
	  @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private AppointmentDetailsServices appointmentDetailsService;
	    
	    /**
	     * Convert Object into Json String by using Jackson ObjectMapper
	     * @param ticket
	     * @return
	     * @throws JsonProcessingException
	     */
	    private String converttoJson(Object appointmentDetails) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(appointmentDetails);
	    }
	    
	    @Test
	    public void testNewAppointment() throws Exception{
	        String URI = "/healthreminder/createAppointment";
	        AppointmentDetails apd = new AppointmentDetails();
	        apd.setAppId(1);
		    apd.setDoctorId(5);
			apd.setDoctorName("Doctor Astin");
			apd.setDoctorStartTime(null);
			apd.setDoctorEndTime(null);
			apd.setDoctorDate(null); 
			apd.setPatientName("Sayantan");
			apd.setPatientId(4);
	        String jsonInput = this.converttoJson(apd);

	        Mockito.when(appointmentDetailsService.createAppointment(Mockito.any(AppointmentDetails.class))).thenReturn(apd);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	    }
	    
	    @Test
	    public void testFindByPatientId() throws Exception{
	        String URI = "/healthreminder/findAppointmentByPatId/{patientId}";
	        AppointmentDetails apd = new AppointmentDetails();
	        apd.setAppId(1);
		    apd.setDoctorId(5);
			apd.setDoctorName("Doctor Astin");
			apd.setDoctorStartTime(null);
			apd.setDoctorEndTime(null);
			apd.setDoctorDate(null); 
			apd.setPatientName("Sayantan");
			apd.setPatientId(4);

			String jsonInput = this.converttoJson(apd);

	        Mockito.when(appointmentDetailsService.findAppointmentDetailByPatientId(Mockito.anyInt())).thenReturn(apd);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 4).accept(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
	    }

}
