package com.doctor.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "clinic_details")
public class ClinicDetails {

	@Id
	private long clinicid;
	@Column(name = "clinicname")
	private String clinicname;
	@Column(name = "docid")
	private Long docid;
	@Column(name = "doctorName")
	private String doctorName;
	@Column(name = "state1")
	private String state1;
	@Column(name = "state2")
	private String state2;
	@Column(name = "state3")
	private String state3;
	@Column(name = "city1")
	private String city1;
	@Column(name = "city2")
	private String city2;
	@Column(name = "city3")
	private String city3;
	@Column(name = "city4")
	private String city4;
	@Column(name = "Area1")
	private String Area1;
	@Column(name = "Area2")
	private String Area2;
	@Column(name = "Area3")
	private String Area3;
	@Column(name = "Area4")
	private String Area4;
	@Column(name = "Area5")
	private String Area5;
	@Column(name = "Area11")
	private String Area11;
	@Column(name = "Area22")
	private String Area22;
	@Column(name = "Area33")
	private String Area33;
	@Column(name = "Area44")
	private String Area44;
	@Column(name = "Area55")
	private String Area55;
	@Column(name = "Area111")
	private String Area111;
	@Column(name = "Area222")
	private String Area222;
	@Column(name = "Area333")
	private String Area333;
	@Column(name = "Area444")
	private String Area444;
	@Column(name = "Area555")
	private String Area555;
	@Column(name = "Area1111")
	private String Area1111;
	@Column(name = "Area2222")
	private String Area2222;
	@Column(name = "Area3333")
	private String Area3333;
	@Column(name = "Area4444")
	private String Area4444;
	@Column(name = "Area5555")
	private String Area5555;

}
