package com.doctor.Service;

import java.util.List;

import com.doctor.Entity.PatientData;
import com.doctor.Entity.PatientDetails;

public interface PatientDataService {

	

	String update(Long patientid, PatientData patientData);

	List<PatientData> getPatientData1();

	List<PatientData> getSingleuser(long patientid);

	String statuswork(String status, Long patientid);

	List<PatientData> getdatabysearch(String name);

}
