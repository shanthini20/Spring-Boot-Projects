package com.doctor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.Entity.ClinicDetails;
import com.doctor.Entity.Docdetails;
import com.doctor.Entity.DoctorDetails;
import com.doctor.Entity.PatientData;
import com.doctor.Entity.PatientDetails;

import com.doctor.Service.ClinicService;
import com.doctor.Service.DocService;
import com.doctor.Service.DoctorService;
import com.doctor.Service.PatientDataService;
import com.doctor.Service.PatientService;
import com.doctor.Service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/book")
public class HospitalController {

	@Autowired
	UserService userService;
	@Autowired
	PatientService patientService;
	@Autowired
	PatientDataService patientDataService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	ClinicService clinicService;
	@Autowired
	DocService docService;

	@PostMapping("/login")
	public Long login(@RequestParam String username, @RequestParam String password, HttpSession session) {
		return userService.login(username, password, session);
	}

	@GetMapping("/patientdata")
	List<PatientDetails> getPatientData(@RequestParam Long userid) {
		return patientService.getPatientData(userid);
	}

	@GetMapping("/singlerow")
	public ResponseEntity<List<PatientData>> getSingleTutorials(@RequestParam(name = "patientid") long patientid) {
		try {
			List<PatientData> singleuser = patientDataService.getSingleuser(patientid);

			if (singleuser.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(singleuser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PostMapping("/patientdata1")

	String insert(@RequestParam(name="userid") long userid,@RequestBody PatientDetails patientDetails) {
		return patientService.insert(userid,patientDetails);
	}
	

	@PostMapping("/update")

	String update(@RequestParam(name = "patientid") Long patientid, @RequestBody PatientData patientData) {
		return patientDataService.update(patientid, patientData);
	}

	@PostMapping("/filter")
	public List<PatientDetails> filterData(@RequestParam(name = "from_date") String from_date,
			@RequestParam(name = "to_date") String to_date) {
		return patientService.filterData(from_date, to_date);
	}

	@GetMapping("/patientall")
	List<PatientData> getPatientData1() {
		return patientDataService.getPatientData1();
	}

	@PostMapping("/filteruser")
	public List<PatientDetails> filterDataforUser(@RequestParam(name = "userid") long userid,
			@RequestParam(name = "from_date") String from_date, @RequestParam(name = "to_date") String to_date) {
		return patientService.filterDataforUser(userid, from_date, to_date);
	}

	@PostMapping("/doctordata")

	String doctorinsert(@RequestBody Docdetails docdetails) {
		return docService.doctorinsert(docdetails);
	}

	@GetMapping("/doctorname")
	public List<String> getNamelists() {
		return doctorService.getNamelists();
	}

	@GetMapping("/doctordetails")
	public List<DoctorDetails> getdoctordetails() {
		return doctorService.getdoctordetails();
	}

	@PutMapping("/approve")
	public String statuswork(@RequestParam(name = "status") String status,
			@RequestParam(name = "patientid") Long patientid) {
		return patientDataService.statuswork(status, patientid);
	}

	@PutMapping("/cancelall")
	public String cancelall(@RequestParam(name = "status") String status, @RequestParam(name = "userid") Long userid) {
		return patientService.cancelall(status, userid);
	}
	
	@GetMapping("/clinicdata")
	List<ClinicDetails> getClinicData(@RequestParam Long docid) {
		return clinicService.getClinicData(docid);
	}
	
	@GetMapping("/search")
	List<PatientData> getdatabysearch(@RequestParam String name) {
		return patientDataService.getdatabysearch(name);
	}

}
