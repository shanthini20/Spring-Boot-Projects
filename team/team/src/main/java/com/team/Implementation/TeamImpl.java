package com.team.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.Dao.TeamRepository;
import com.team.Entity.Teamdetails;
import com.team.Service.TeamService;

@Service
public class TeamImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepo;

	@Override
	public String insertteam(Teamdetails teamdetails) {
		if (teamdetails != null) {
			teamRepo.save(teamdetails);
			return "save";
		}

		return "wrong";
	}
//
//	@Override
//	public List<String> getAllNames() {
//		List<String> names = new ArrayList<>();
//		List<Teamdetails> nameList = teamRepo.findAll();
//		for (Teamdetails teamname : nameList) {
//			names.add(teamname.getTeamname());
//		}
//		return names;
//
//	}
	
	@Override
	public List<Teamdetails> getAll() {
	
		List<Teamdetails> nameList = teamRepo.findAll();
		
		return nameList;

	}

}
