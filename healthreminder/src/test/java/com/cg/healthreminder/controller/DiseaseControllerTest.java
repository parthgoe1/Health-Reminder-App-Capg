/*
 * Author-> Shania Dalal
 * This is the Junit Test class that checks all Controller operations performed
 * on the Diseases model
 * 
*/
package com.cg.healthreminder.controller;

import static org.assertj.core.api.Assertions.assertThat;

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

import com.cg.healthreminder.model.Diseases;
import com.cg.healthreminder.services.DiseaseServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DiseaseController.class)
public class DiseaseControllerTest {
	  @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private DiseaseServices diseaseServices;
	    
	    /**
	     * Convert Object into Json String by using Jackson ObjectMapper
	     * @param ticket
	     * @return
	     * @throws JsonProcessingException
	     */
	    private String converttoJson(Object disease) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(disease);
	    }
	    
	    @Test
	    public void testNewDisease() throws Exception{
	        String URI = "/healthreminder/addDisease";
	         Diseases d=new Diseases();
			 d.setDiseaseId(5);
			 d.setDiseaseName("Cough");
			 d.setDiseaseInfo("Throat Irritation");
			 d.setDiseaseKeys("cough");
	        String jsonInput = this.converttoJson(d);

	        Mockito.when(diseaseServices.addDisease(Mockito.any(Diseases.class))).thenReturn(d);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	    }
	    
	    @Test
	    public void testFindByDiseaseId() throws Exception{
	        String URI = "/healthreminder/viewDisease/{id}";
	        Diseases d=new Diseases();
			 d.setDiseaseId(5);
			 d.setDiseaseName("Cough");
			 d.setDiseaseInfo("Throat Irritation");
			 d.setDiseaseKeys("cough");
	        String jsonInput = this.converttoJson(d);

	        Mockito.when(diseaseServices.viewDisease(Mockito.anyInt())).thenReturn(d);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 5).accept(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
	    }
	    
	    @Test
	    public void testUpdateByDiseaseId() throws Exception{
	        String URI = "/healthreminder/updateDisease/{id}/{content}";
	        Diseases d=new Diseases();
			 d.setDiseaseId(5);
			 d.setDiseaseName("Cough");
			 d.setDiseaseInfo("Throat Irritation");
			 d.setDiseaseKeys("cough");

	        Mockito.when(diseaseServices.updateDiseaseInfo(Mockito.anyInt(),Mockito.anyString())).thenReturn(d);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI, 5, "try this").accept(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	    }  
}
