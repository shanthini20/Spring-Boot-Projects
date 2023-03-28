package com.team.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.Entity.Userdetails;

@Repository
public interface UserRepository extends JpaRepository<Userdetails, Long> {

	@Query(nativeQuery = true, value = "select*from user_details where userid=?1")
	List<Userdetails> findByUserID(Long userid);

}
