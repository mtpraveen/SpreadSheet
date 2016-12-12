package com.ipl.dao;

import java.util.List;

import com.ipl.model.Team;

public interface TeamDao {
	void addTeam(Team team);
	List displayAllTeam();
	List teamInfo(String teamName);
}
