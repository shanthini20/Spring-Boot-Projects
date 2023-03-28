package com.doctor.Service;

import java.util.List;

import com.doctor.Entity.PatientDetails;

public interface PatientService {

	List<PatientDetails> getPatientData(Long userid);

	List<PatientDetails> filterData(String from_date, String to_date);

	List<PatientDetails> filterDataforUser(long userid, String from_date, String to_date);

	String cancelall(String status, Long userid);

	String insert(long userid, PatientDetails patientDetails);

	
	

}
