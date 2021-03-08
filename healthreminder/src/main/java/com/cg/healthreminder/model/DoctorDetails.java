package com.cg.healthreminder.model;

import javax.persistence.*;

@Entity
@Table(name = "Doctor_Details")
public class DoctorDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doct_id")
    private Integer doct_id;
	
    @Column(name = "verf_status", nullable = false)
    private boolean verf_status;
    
    @Column(name = "doc_name", nullable = false)
    private String doc_name;
    
    @Column(name = "doc_spec", nullable = false)
    private String doc_spec;
    
    @Column(name = "certificate_file", nullable = false)
    private String certificate_file;

	public Integer getDoct_id() {
		return doct_id;
	}

	public void setDoct_id(Integer doct_id) {
		this.doct_id = doct_id;
	}

	public boolean isVerf_status() {
		return verf_status;
	}

	public void setVerf_status(boolean verf_status) {
		this.verf_status = verf_status;
	}

	public String getDoc_name() {
		return doc_name;
	}

	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public String getDoc_spec() {
		return doc_spec;
	}

	public void setDoc_spec(String doc_spec) {
		this.doc_spec = doc_spec;
	}

	public String getCertificate_file() {
		return certificate_file;
	}

	public void setCertificate_file(String certificate_file) {
		this.certificate_file = certificate_file;
	}

	@Override
	public String toString() {
		return "DoctorDetails [doct_id=" + doct_id + ", verf_status=" + verf_status + ", doc_name=" + doc_name
				+ ", doc_spec=" + doc_spec + ", certificate_file=" + certificate_file + "]";
	}

    
	
}
