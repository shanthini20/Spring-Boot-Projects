package com.team.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.Dao.MemRepository;
import com.team.Dao.MemberRepository;
import com.team.Entity.Mem_details;
import com.team.Entity.Memberdetails;
import com.team.Service.MemberService;

@Service
public class MemberImpl implements MemberService{

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemRepository memRepository;

	@Override
	public String insertmem(Memberdetails memberdetails) {
		if (memberdetails != null) {
			memberRepository.save(memberdetails);
			return "save";
		}

		return "wrong";
	}

	@Override
	public List<Memberdetails> getTeamMembersName(long teamid) {
		List<Memberdetails> newList=memberRepository.findByTeamId(teamid);
		return newList;
	}

	@Override
	public List<Mem_details> getSpecifiedMembersName(long teamid) {
		List<Mem_details> newList=memRepository.findBySpecTeamId(teamid);
		System.out.println(newList);
		return newList; 
	}

	@Override
	public String deleteMember(Long memid) {
		memberRepository.deleteById(memid);
		return "delete";
	}

	@Override
	public String saveMembers(Long teamid, List<Long> userIds) {
		 for (Long userid : userIds) {
		      memberRepository.saveMemberDetails(teamid, userid);
		   }
		
       return "save";
	}

	@Override
	public String deleteAllById(List<Long> memIds) {
		memberRepository.deleteAllById(memIds);
		
		return "delete";
	}

	@Override
	public List<Object[]> getUserCountByTeam() {
		return memberRepository.getUserCountByTeam();
	}
}
