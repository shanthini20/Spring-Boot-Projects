package com.team.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.Entity.Teamdetails;

public interface TeamRepository extends JpaRepository<Teamdetails, Long> {

}
