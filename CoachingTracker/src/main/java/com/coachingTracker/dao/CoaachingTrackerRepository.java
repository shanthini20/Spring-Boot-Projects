package com.coachingTracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coachingTracker.dto.UsernameDetails;
import com.coachingTracker.entity.UserEntity;

@Repository
public interface CoaachingTrackerRepository extends JpaRepository<UserEntity, Integer> {

	boolean existsByPassword(String password);

	boolean existsByUsername(String username);

	boolean existsByRole(String role);

	@Query(nativeQuery = true, value = "select username from usertbl where roleid=1")
	List<String> findByUsername();
	
	List<UserEntity> findByroleId(int id);
    
	@Query(nativeQuery = true, value = "select roleid from usertbl where username=:uname")
	String getByUsername1(@Param("uname")String username);

	@Query(nativeQuery = true, value = "select userid from usertbl where username=:uname")
	String getByUsername(@Param("uname")String username);

	
    
	//@Query(nativeQuery = true, value = "select role from usertbl where username=?1 and password=?2")
	//String findByRole(String username,String password);
    
//	@Query(nativeQuery = true, value = "select roleid from usertbl where username=:uname")
//	List<String> getByUsername(@Param("uname")String username);
//	
//	@Query(nativeQuery = true, value = "select userid from usertbl where username=:uname")
//	List<String> getByUsername1(@Param("uname")String username);
//	
	



}
