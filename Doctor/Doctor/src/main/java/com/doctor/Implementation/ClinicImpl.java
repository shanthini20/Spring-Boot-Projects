package com.doctor.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.Entity.ClinicDetails;
import com.doctor.Entity.PatientDetails;
import com.doctor.Repository.ClinicRepo;
import com.doctor.Service.ClinicService;

@Service
public class ClinicImpl implements ClinicService {

	@Autowired
	ClinicRepo clinicRepo;

	@Override
	public List<ClinicDetails> getClinicData(Long docid) {
		List<ClinicDetails> cliniclist = clinicRepo.findBydocid(docid);
		return cliniclist;
	}

}
