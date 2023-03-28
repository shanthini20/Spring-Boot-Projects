package com.doctor.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.Entity.PatientData;

@Repository
public interface PatientDataRepo extends JpaRepository<PatientData, Long> {

	

	List<PatientData> findByDoctornameContainingOrPatientnameContaining(String name, String name2);

}
