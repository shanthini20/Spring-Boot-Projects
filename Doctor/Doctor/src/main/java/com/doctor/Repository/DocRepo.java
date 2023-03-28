package com.doctor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.Entity.Docdetails;

public interface DocRepo extends JpaRepository<Docdetails, Long> {
	

}
