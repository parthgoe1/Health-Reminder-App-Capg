package com.cg.healthreminder.controller;

import com.cg.healthreminder.model.DietInfo;
import com.cg.healthreminder.services.DietInfoServices;
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

import static org.assertj.core.api.Assertions.assertThat;

// Author --> Parth Goel

@RunWith(SpringRunner.class)
@WebMvcTest(value = DietInfoController.class)
public class DietInfoControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private DietInfoServices dietInfoService;
	
	/**
     * Convert Object into Json String by using Jackson ObjectMapper
     * @param ticket
     * @return
     * @throws JsonProcessingException
     */
	
	private String converttoJson(Object dietInfo) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(dietInfo);
    }
	
	@Test
    public void testCreateDiet() throws Exception{
        String URI = "/healthreminder/create_diet";
        DietInfo dietInfo = new DietInfo();
        dietInfo.setBmiValue(1);
        dietInfo.setDietInfo("pizza");
		
        String jsonInput = this.converttoJson(dietInfo);

        Mockito.when(dietInfoService.createDiet(Mockito.any(DietInfo.class))).thenReturn(dietInfo);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
    }
	
//	@Test
//    public void testFindDietByBMI() throws Exception{
//        String URI = "/healthreminder/findAppointmentByPatId/{patientId}";
//        AppointmentDetails apd = new AppointmentDetails();
//        apd.setAppId(1);
//	    apd.setDoctorId(5);
//		apd.setDoctorName("Doctor Astin");
//		apd.setDoctorStartTime(null);
//		apd.setDoctorEndTime(null);
//		apd.setDoctorDate(null); 
//		apd.setPatientName("Sayantan");
//		apd.setPatientId(4);
//
//		String jsonInput = this.converttoJson(apd);
//
//        Mockito.when(appointmentDetailsService.findAppointmentDetailByPatientId(Mockito.anyInt())).thenReturn(apd);
//        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 4).accept(MediaType.APPLICATION_JSON))
//                .andReturn();
//        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
//        String jsonOutput = mockHttpServletResponse.getContentAsString();
//
//        assertThat(jsonInput).isEqualTo(jsonOutput);
//    }


}
