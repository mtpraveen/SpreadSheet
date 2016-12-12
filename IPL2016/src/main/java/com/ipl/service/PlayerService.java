package com.ipl.service;

import java.util.List;

import com.ipl.model.Player;

public interface PlayerService {
	
	public void addPlayer(Player player);
    public List<Player> displayAllPlayer(int teamID);
    public List<Player> displayPlayerInfo(String playerName);
}
