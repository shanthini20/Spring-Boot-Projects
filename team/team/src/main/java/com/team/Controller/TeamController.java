package com.team.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.Dto.DeleteRequest;
import com.team.Entity.Mem_details;
import com.team.Entity.Memberdetails;
import com.team.Entity.Teamdetails;
import com.team.Service.MemberService;
import com.team.Service.TeamService;

@RestController
@RequestMapping("/team")

public class TeamController {

	@Autowired
	TeamService teamService;
	@Autowired
	MemberService memberService;

	@PostMapping("/newteam")
	String insertteam(@RequestBody Teamdetails teamdetails) {
		return teamService.insertteam(teamdetails);
	}

	@GetMapping("/getteam")
	public List<Teamdetails> getAll() {
		return teamService.getAll();
	}

	@PostMapping("/mem")
	String insertmem(@RequestBody Memberdetails memberdetails) {
		return memberService.insertmem(memberdetails);
	}

	@GetMapping("/teammembers")
	public List<Memberdetails> getTeamMembersName(@RequestParam(name = "teamid") long teamid) {
		return memberService.getTeamMembersName(teamid);
	}

	@GetMapping("/specmem")
	public List<Mem_details> getSpecifiedMembersName(@RequestParam(name = "teamid") long teamid) {
		return memberService.getSpecifiedMembersName(teamid);
	}

	@DeleteMapping("/delete/{memid}")
	String deleteMember(@PathVariable Long memid) {
		return memberService.deleteMember(memid);
	}

	@PostMapping("/insertmem")
	public ResponseEntity<String> addMembersToTeam(@RequestBody Memberdetails memberdetails) {

		Long teamid = memberdetails.getTeamid();
		List<Long> userIds = memberdetails.getUserIds();
		memberService.saveMembers(teamid, userIds);
		return ResponseEntity.ok("Members added to team successfully");
	}

	@DeleteMapping("/memdelete")
	public ResponseEntity<String> deleteEntities(@RequestBody DeleteRequest request) {
	    try {
	        List<Long> memIds = request.getMemIds();
	        memberService.deleteAllById(memIds);
	        return ResponseEntity.ok("Entities deleted successfully");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting entities");
	    }
	}
	
	 @GetMapping("/teamcount")
	    public List<Object[]> getUserCountByTeam() {
	        return memberService.getUserCountByTeam();
	    }



}