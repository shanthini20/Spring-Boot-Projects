package com.coachingTracker.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coachingTracker.dao.CoaachingTrackerRepository;
import com.coachingTracker.dao.EntryInsertRepository;
//import com.coachingTracker.dao.RoleGetRepository;
import com.coachingTracker.dto.UsernameDetails;
import com.coachingTracker.entity.EntryDetails;
import com.coachingTracker.entity.UserEntity;
import com.coachingTracker.service.CoachingTrackerService;

@Service
public class CoachingTrackerImplementation implements CoachingTrackerService {

	@Autowired
	CoaachingTrackerRepository coaachingTrackerRepository;

	@Override
	public List<String> loginUser(UserEntity userEntity) {
		String username = userEntity.getUsername();
			if (coaachingTrackerRepository.existsByUsername(userEntity.getUsername())) {
				if (coaachingTrackerRepository.existsByPassword(userEntity.getPassword())) {
					String getroleid = coaachingTrackerRepository.getByUsername(username);
					String getuserid =coaachingTrackerRepository.getByUsername1(username);
                    System.out.println(getroleid);
                    System.out.println(getuserid);
                    List<String> getRoleidAndUserid= new ArrayList<>();
                    getRoleidAndUserid.add(getuserid);
                    getRoleidAndUserid.add(getroleid);
                    getRoleidAndUserid.add("Login Success");
                    return getRoleidAndUserid;
                    
				}
				List<String>Invalid= new ArrayList<>();
                Invalid.add("Invalid");
				return Invalid;
			}
			else {
				List<String>Invalid= new ArrayList<>();
                Invalid.add("User Not found");
				return Invalid;
			}
				
			}
		

	@Autowired
	EntryInsertRepository entryInsertRepository;

	@Override
	public EntryDetails insertEntryDetails(EntryDetails entryDetails) {
		if (entryDetails != null) {
			entryInsertRepository.save(entryDetails);
 
		}

		return entryDetails;

	}

	@Override
	public List<EntryDetails> getTableScreenData() {
		List<EntryDetails> entryDetailList = entryInsertRepository.findAll();
		return entryDetailList;
	}

	@Override
	public EntryDetails finalrec(int entryid) {
		Optional<EntryDetails> entrydetailfinal = entryInsertRepository.findById(entryid);
		if (entrydetailfinal.isPresent()) {
			return entrydetailfinal.get();
		}
		throw new RuntimeException("Employee is not found for the id" + entryid);

	}

	@Override
	public List<String> getNamelists() {
		// TODO Auto-generated method stub
//		List<String> agentData =coaachingTrackerRepository.findByUsername();
		List<String> agentData = new ArrayList<>();
		List<UserEntity> getList = coaachingTrackerRepository.findByroleId(1);
		for (UserEntity userEntity : getList) {
			agentData.add(userEntity.getUsername());
		}
		return agentData;
	}

	@Override
	public String agentCommentInsert(String agent_comments, int entryid, String status) {
		Optional<EntryDetails> retrieveEntryDetails = entryInsertRepository.findById(entryid);
		if (retrieveEntryDetails.isPresent()) {
			EntryDetails entry = retrieveEntryDetails.get();
			entry.setAgent_comments(agent_comments);
			entry.setStatus(status);
			entryInsertRepository.save(entry);
		}
		return "updated";
	}

	@Override
	public List<EntryDetails> filterData(String from_date, String to_date, String agent_name) {
		List<EntryDetails> filterdata = entryInsertRepository.findAllByFilterDate(from_date, to_date, agent_name);

		return filterdata;
	}

//	@Override
//	public List<EntryDetails> getTableAgentData(int userid) {
//		List<EntryDetails> newdata=entryInsertRepository.findAllById(userid);
//		return null;
//	}

	@Override
	public List<EntryDetails> getTableAgentData(int userid) {
		List<EntryDetails> newList=entryInsertRepository.findByUserID(userid);
		return newList;
	}
	
	

//	@Override
//	public String getRoleNamelists(String username ,String password) {
//		String roleData =coaachingTrackerRepository.findByRole(username, password);
//		System.out.println(roleData);
//		return roleData;
//	}

}
