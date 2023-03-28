package com.coachingTracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coachingTracker.entity.EntryDetails;

public interface EntryInsertRepository extends JpaRepository<EntryDetails, Integer> {
    
	
	
	@Query(nativeQuery = true, value = "select*from coachingtrackerentrytbl where shiftdate between ?1 and ?2 and agent_name= ?3")
	List<EntryDetails> findAllByFilterDate(String from_date,String to_date,String agent_name);
    
	
	
	@Query(nativeQuery = true, value ="select*from coachingtrackerentrytbl where userid=?1")
	List<EntryDetails> findByUserID(int userid);

	

	
	

}
