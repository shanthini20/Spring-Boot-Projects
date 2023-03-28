package com.doctor.Service;

import java.util.List;

import com.doctor.Entity.DoctorDetails;

public interface DoctorService {

	
	List<String> getNamelists();

	List<DoctorDetails> getdoctordetails();

}
