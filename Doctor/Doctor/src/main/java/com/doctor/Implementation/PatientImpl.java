package com.doctor.Implementation;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.Entity.PatientDetails;
import com.doctor.Repository.PatientRepository;
import com.doctor.Service.PatientService;

@Service
public class PatientImpl implements PatientService {
	@Autowired
	PatientRepository patientRepository;

	@Override
	public List<PatientDetails> filterData(String from_date, String to_date) {
		List<PatientDetails> filterdata = patientRepository.findAllByFilterDate(from_date, to_date);

		return filterdata;
	}

	@Override
	public List<PatientDetails> getPatientData(Long userid) {
		LocalDate today = LocalDate.now();
		List<PatientDetails> patientlist = patientRepository.findByuseridAndAppdate(userid, today.toString());
		return patientlist;
	}

	@Override
	public List<PatientDetails> filterDataforUser(long userid, String from_date, String to_date) {
		List<PatientDetails> filterdata = patientRepository.findAllByFilterDateforuser(userid, from_date, to_date);

		return filterdata;
	}

	@Override
	public String cancelall(String status, Long userid) {
		List<PatientDetails> retrievepatientDetails = patientRepository.findByuserid(userid);
		if (retrievepatientDetails.size() > 0) {
			for (int i = 0; i < retrievepatientDetails.size(); i++) {
				PatientDetails entry = retrievepatientDetails.get(i);
				entry.setStatus(status);
				patientRepository.save(entry);
			}
			return "cancel";
		}
		return "User not found with userid " + userid;
	}

	@Override
	public String insert(long userid, PatientDetails patientDetails) {

		String appointmentTime = patientDetails.getApptime();
		String appointmentDate = patientDetails.getAppdate();
		List<PatientDetails> existingAppointments = patientRepository.findByUseridAndApptimeAndAppdate(userid,
				appointmentTime, appointmentDate);

		if (!existingAppointments.isEmpty()) {
			return "The selected date and time slot is already booked.";
		}

		patientDetails.setUserid(userid);
		patientRepository.save(patientDetails);
		return "save";

	}

}
