package com.doctor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.Entity.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

	UserDetails findByUsername(String username);

}
