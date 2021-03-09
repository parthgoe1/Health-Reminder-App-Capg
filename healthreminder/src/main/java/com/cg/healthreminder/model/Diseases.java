//author->Shania Dalal
package com.cg.healthreminder.model;

import javax.persistence.*;

@Entity 
@Table(name="diseases_info")  //--> table to store all information on diseases
public class Diseases {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "dis_id")
	private Integer diseaseId;
	
	@Column(name = "dis_name")
	private String diseaseName;
	
	@Column(name = "dis_info")
	private String diseaseInfo;
	
	@Column(name = "dis_keys")
	private String diseaseKeys;
	
	public Integer getDiseaseId() {
		return diseaseId;
	}
	
	public void setDiseaseId(Integer diseaseId) {
		this.diseaseId = diseaseId;
	}
	
	public String getDiseaseName() {
		return diseaseName;
	}
	
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	
	public String getDiseaseInfo() {
		return diseaseInfo;
	}
	
	public void setDiseaseInfo(String diseaseInfo) {
		this.diseaseInfo = diseaseInfo;
	}
	
	public String getDiseaseKeys() {
		return diseaseKeys;
	}
	
	public void setDiseaseKeys(String diseaseKeys) {
		this.diseaseKeys = diseaseKeys;
	}
	
	@Override
	public String toString() {
		return "Diseases [diseaseId=" + diseaseId + ", diseaseName=" + diseaseName + ", diseaseInfo=" + diseaseInfo
				+ ", diseaseKeys=" + diseaseKeys + "]";
	}
	
	
}
