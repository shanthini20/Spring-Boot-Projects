package com.team.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team.Entity.Mem_details;
import com.team.Entity.Memberdetails;

import jakarta.transaction.Transactional;

public interface MemberRepository extends JpaRepository<Memberdetails, Long> {

	@Query(value = "SELECT tm.userid AS userid, tm.teamid AS teamid, tm.memid AS memid, tm.user_ids AS user_ids,up.firstname AS firstname, up.lastname AS lastname "
			+ "FROM member_details AS tm " + "LEFT JOIN user_details AS up ON up.userid = tm.userid "
			+ "WHERE tm.teamid = :teamId", nativeQuery = true)
	List<Memberdetails> findByTeamId(@Param("teamId") long teamId);

	@Query(value = "SELECT userid, firstname, lastname FROM user_details "
			+ "WHERE userid NOT IN (SELECT userid FROM member_details WHERE teamid = :teamid)", nativeQuery = true)
		List<Mem_details> findBySpecTeamId(@Param("teamid") long teamid);
		
		
		@Transactional
		@Modifying
		@Query(value = "INSERT INTO member_details  (teamid, userid) VALUES (:teamid, :userid)", nativeQuery = true)
		void saveMemberDetails(@Param("teamid") Long teamid, @Param("userid") Long userid);
		
		 @Query(value="SELECT td.teamname, COUNT(md.userid) AS user_count\r\n"
		 		+ "FROM user.team_details td\r\n"
		 		+ "LEFT JOIN user.member_details md ON td.teamid = md.teamid\r\n"
		 		+ "GROUP BY td.teamname\r\n"
		 		+ "",nativeQuery = true)
		    List<Object[]> getUserCountByTeam();

		  
	
}
