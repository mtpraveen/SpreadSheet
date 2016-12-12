package com.ipl.dao;

import java.util.List;

import com.ipl.model.Player;

public interface PlayerDao {
	void addPlayer(Player player);
	List<Player> displayAllPlayer(int teamId);
	List<Player> displayPlayerInfo(String playerName);
}