package com.team.Service;

import java.util.List;

import com.team.Entity.Teamdetails;

public interface TeamService {

	String insertteam(Teamdetails teamdetails);

	List<Teamdetails> getAll();

}