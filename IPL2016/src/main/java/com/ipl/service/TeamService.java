package com.ipl.service;

import java.util.List;

import com.ipl.model.Team;

public interface TeamService {
	public void addTeam(Team team);
    public List displayAllTeam();
	public List teamInfo(String teamName);
}
