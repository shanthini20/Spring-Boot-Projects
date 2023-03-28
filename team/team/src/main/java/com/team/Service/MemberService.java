package com.team.Service;

import java.util.List;

import com.team.Entity.Mem_details;
import com.team.Entity.Memberdetails;

public interface MemberService {

	String insertmem(Memberdetails memberdetails);

	List<Memberdetails> getTeamMembersName(long teamid);

	List<Mem_details> getSpecifiedMembersName(long teamid);

	String deleteMember(Long memid);

	String saveMembers(Long teamid, List<Long> userIds);

	String deleteAllById(List<Long> memIds);

	List<Object[]> getUserCountByTeam();

	
	

}

