package com.team.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team.Entity.Mem_details;

public interface MemRepository extends JpaRepository<Mem_details, Long>{

	
	

	@Query(value = "SELECT userid, firstname, lastname FROM user_details "
			+ "WHERE userid NOT IN (SELECT userid FROM member_details WHERE teamid = :teamid)", nativeQuery = true)
		List<Mem_details> findBySpecTeamId(@Param("teamid") long teamid);

	
}
