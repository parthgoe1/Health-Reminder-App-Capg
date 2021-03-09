//AUTHOR --> Ankit Banerjee
package com.cg.healthreminder.model;

import javax.persistence.*;

@Entity
@Table(name = "Doctor_Details")
public class DoctorDetails {
	
	
	@Override
	public String toString() {
		return "DoctorDetails [doctorId=" + doctorId + ", verfStatus=" + verfStatus + ", doctorName=" + doctorName
				+ ", doctorSpec=" + doctorSpec + ", DoctorCertFile=" + DoctorCertFile + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doct_id")
    private Integer doctorId;
	
    @Column(name = "verf_status", nullable = false)
    private boolean verfStatus;
    
    @Column(name = "doc_name", nullable = false)
    private String doctorName;
    
    @Column(name = "doc_spec", nullable = false)
    private String doctorSpec;
    
    @Column(name = "certificate_file", nullable = false)
    private String DoctorCertFile;

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public boolean isVerfStatus() {
		return verfStatus;
	}

	public void setVerfStatus(boolean verfStatus) {
		this.verfStatus = verfStatus;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorSpec() {
		return doctorSpec;
	}

	public void setDoctorSpec(String doctorSpec) {
		this.doctorSpec = doctorSpec;
	}

	public String getDoctorCertFile() {
		return DoctorCertFile;
	}

	public void setDoctorCertFile(String doctorCertFile) {
		DoctorCertFile = doctorCertFile;
	}

	
	
    
	
}
