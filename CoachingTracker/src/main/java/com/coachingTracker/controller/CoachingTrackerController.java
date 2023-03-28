package com.coachingTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coachingTracker.entity.EntryDetails;
import com.coachingTracker.entity.UserEntity;
import com.coachingTracker.service.CoachingTrackerService;

@RestController
@RequestMapping("/coaching")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CoachingTrackerController {
@Autowired 
CoachingTrackerService coachingTrackerService;
	
	@PostMapping("/login")
    List<String> loginUser(@RequestBody UserEntity userEntity)
	{
		return coachingTrackerService.loginUser(userEntity);
		
	}
	@PostMapping("/entrydateinsert")
	public EntryDetails insertEntryDetails(@RequestBody EntryDetails entryDetails)
	{
		return coachingTrackerService.insertEntryDetails(entryDetails);
	}
	@GetMapping("/gettablescreen")
	List<EntryDetails> getTableScreenData()
	{
		return coachingTrackerService.getTableScreenData();
	}
	@GetMapping("/getfinalrec")
	public EntryDetails finalrec(@RequestParam(name="entryid", required = false) int entryid)
	{
	return coachingTrackerService.finalrec(entryid);
	}
	@GetMapping("/agentname")
	public List<String> getNamelists()
	{
		return coachingTrackerService.getNamelists();
	}
	
	@PutMapping("/agentcomments")
	public String agentCommentInsert(@RequestParam(name="agent_comments")String agent_comments,@RequestParam(name="entryid")int entryid ,@RequestParam(name="status")String status)
	{
		return coachingTrackerService.agentCommentInsert(agent_comments,entryid,status);
	}

	@PostMapping("/filter")
	public List<EntryDetails> filterData(@RequestParam(name="from_date")String from_date,@RequestParam(name="to_date")String to_date,@RequestParam(name="agent_name")String agent_name)
	{
		return coachingTrackerService.filterData(from_date,to_date,agent_name);
	}
	
	
//	@GetMapping("/role")
//	public String getRoleNamelists(@RequestParam(name= "username")String username,@RequestParam(name="password")String password)
//	{
//		return coachingTrackerService.getRoleNamelists(username,password);
//	}

	@GetMapping("/agentpage")
	List<EntryDetails> getTableAgentData(@RequestParam(name="userid")int userid)
	{
		return coachingTrackerService.getTableAgentData(userid);
	}
//	
//	
	

}
