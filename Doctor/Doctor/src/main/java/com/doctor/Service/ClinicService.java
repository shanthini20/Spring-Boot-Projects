package com.doctor.Service;

import java.util.List;

import com.doctor.Entity.ClinicDetails;
import com.doctor.Entity.PatientDetails;

public interface ClinicService {

	List<ClinicDetails> getClinicData(Long docid);

}
