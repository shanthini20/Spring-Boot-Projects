package com.doctor.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.Entity.DoctorDetails;
import com.doctor.Repository.DoctorRepo;
import com.doctor.Service.DoctorService;

@Service
public class DoctorImpl implements DoctorService {

	@Autowired
	DoctorRepo doctorRepo;



	@Override
	public List<String> getNamelists() {
		List<String> agentData = doctorRepo.getdocname();

		return agentData;
	}

	@Override
	public List<DoctorDetails> getdoctordetails() {
		List<DoctorDetails> nameList = doctorRepo.findAll();

		return nameList;
	}

}
