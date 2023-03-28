package com.doctor.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doctor.Entity.PatientData;
import com.doctor.Entity.PatientDetails;

@Repository
public interface PatientRepository extends JpaRepository<PatientDetails, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM doctor.patient_details WHERE app_date BETWEEN ?1  AND ?2")

	List<PatientDetails> findAllByFilterDate(String from_date, String to_date);

	@Query(nativeQuery = true, value = "SELECT * FROM doctor.patient_details WHERE userid = ?1 AND app_date BETWEEN ?2 AND ?3")

	List<PatientDetails> findAllByFilterDateforuser(long userid, String from_date, String to_date);

	List<PatientDetails> findByuserid(Long userid);

	List<PatientDetails> findByuseridAndAppdate(Long userid, String appdate);

	List<PatientDetails> findByUseridAndApptimeAndAppdate(long userid, String appointmentTime, String appointmentDate);

}
