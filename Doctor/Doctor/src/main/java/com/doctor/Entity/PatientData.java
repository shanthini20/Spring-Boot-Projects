package com.doctor.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "patient_details")
public class PatientData {

	@Id
	@Column(name = "patientid")
	private long patientid;
	@Column(name = "patientname")
	private String patientname;
	@Column(name = "age")
	private String age;
	@Column(name = "gender")
	private String gender;
	@Column(name = "phoneno")
	private String phoneno;
	@Column(name = "address")
	private String address;
	@Column(name = "enquiry")
	private String enquiry;
	@Column(name = "app_date")
	private String appdate;
	@Column(name = "app_time")
	private String apptime;
	@Column(name = "doctorname")
	private String doctorname;
	@Column(name = "doc_state")
	private String doc_state;
	@Column(name = "doc_city")
	private String doc_city;
	@Column(name = "doc_area")
	private String doc_area;
	@Column(name = "status")
	private String status;

}
