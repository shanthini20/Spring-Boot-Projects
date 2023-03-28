package com.doctor.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.Entity.PatientData;

import com.doctor.Repository.PatientDataRepo;
import com.doctor.Service.PatientDataService;

@Service
public class PatientDataImpl implements PatientDataService {

	@Autowired
	PatientDataRepo patientDataRepo;

	


	@Override
	public String update(Long patientid, PatientData patientData) {
		
		Optional<PatientData> getdata = patientDataRepo.findById(patientid);
		if (getdata.isPresent()) {
			PatientData newentry = getdata.get();
			newentry.setPatientname(patientData.getPatientname());
			newentry.setAge(patientData.getAge());
			newentry.setGender(patientData.getGender());
			newentry.setPhoneno(patientData.getPhoneno());
			newentry.setAddress(patientData.getAddress());
			newentry.setEnquiry(patientData.getEnquiry());
			newentry.setAppdate(patientData.getAppdate());
			newentry.setApptime(patientData.getApptime());
			newentry.setDoctorname(patientData.getDoctorname());
			newentry.setDoc_state(patientData.getDoc_state());
			newentry.setDoc_city(patientData.getDoc_city());
			newentry.setDoc_area(patientData.getDoc_area());

			patientDataRepo.save(newentry);
		}
		return "updated";
	}

	@Override
	public List<PatientData> getPatientData1() {

		List<PatientData> patientlist = patientDataRepo.findAll();
		return patientlist;
	}

	@Override
	public List<PatientData> getSingleuser(long patientid) {
		Optional<PatientData> newdata = patientDataRepo.findById(patientid);
		if (newdata.isPresent()) {
			newdata.get();
			List<PatientData> newlist = new ArrayList<>();
			newlist.add(newdata.get());
			return newlist;
		}
		return null;
	}

	@Override
	public String statuswork(String status, Long patientid) {
		Optional<PatientData> retrievepatientDetails = patientDataRepo.findById(patientid);
		if (retrievepatientDetails.isPresent()) {
			PatientData entry = retrievepatientDetails.get();

			entry.setStatus(status);
			patientDataRepo.save(entry);
		}
		return "updated";
	}

	@Override
	public List<PatientData> getdatabysearch(String name) {
	
		return patientDataRepo.findByDoctornameContainingOrPatientnameContaining(name,name);
	}

}
