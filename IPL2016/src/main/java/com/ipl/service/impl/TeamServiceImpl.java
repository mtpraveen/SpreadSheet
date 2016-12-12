package com.ipl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipl.dao.TeamDao;
import com.ipl.model.Team;
import com.ipl.service.TeamService;

public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamDao teamDao;

	public void addTeam(Team team) {
		teamDao.addTeam(team);

	}

	public List displayAllTeam() {
	       List teamInfo=teamDao.displayAllTeam();
		
		return teamInfo;
		
		
		
	}
	public List teamInfo(String teamName) {
		List teamDetails=teamDao.teamInfo(teamName);
		return teamDetails;
	}

}
