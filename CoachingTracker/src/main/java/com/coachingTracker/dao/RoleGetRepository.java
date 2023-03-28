/*package com.coachingTracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coachingTracker.entity.RoleEntity;
@Repository
public interface RoleGetRepository extends JpaRepository<RoleEntity, Integer>{
    
	@Query(nativeQuery = true, value = "select role from userroletbl")
	List<String> findByroleName();

}
*/