package com.doctor.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "doctor_details")
public class DoctorDetails {

	@Id
	@Column(name = "docid")
	private long docid;
	@Column(name = "docname")
	private String docname;
	@Column(name = "docage")
	private String docage;
	@Column(name = "qualification")
	private String qualification;
	@Column(name = "registerno")
	private String registerno;
	@Column(name = "docaddress")
	private String docaddress;
	@Column(name = "cliniccity")
	private String cliniccity;
	@Column(name = "clinicstate")
	private String clinicstate;
	@Column(name = "clinicarea")
	private String clinicarea;
	@Column(name="userid")
	private long userid;

}
