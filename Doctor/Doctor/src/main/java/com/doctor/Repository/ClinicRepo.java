package com.doctor.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.Entity.ClinicDetails;

@Repository
public interface ClinicRepo extends JpaRepository<ClinicDetails, Long>{

	List<ClinicDetails> findBydocid(Long docid);

}
