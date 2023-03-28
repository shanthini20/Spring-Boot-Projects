package com.doctor.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doctor.Entity.DoctorDetails;

@Repository
public interface DoctorRepo extends JpaRepository<DoctorDetails, Long> {

	@Query(nativeQuery = true, value = "select docname from  doctor.doctor_details")

	List<String> getdocname();

}
