package com.coachingTracker.service;

import java.util.List;

import com.coachingTracker.dto.UsernameDetails;
import com.coachingTracker.entity.EntryDetails;
import com.coachingTracker.entity.UserEntity;

public interface CoachingTrackerService {

	List<String> loginUser(UserEntity userEntity);

	EntryDetails insertEntryDetails(EntryDetails entryDetails);

	List<EntryDetails> getTableScreenData();

	EntryDetails finalrec(int entryid);

	List<String> getNamelists();

	String agentCommentInsert(String agent_comments, int entryid,String status);

	List<EntryDetails> filterData(String from_date, String to_date, String agent_name);

	List<EntryDetails> getTableAgentData(int userid);

//	String getRoleNamelists(String username, String password);

	

   


	


}
