package com.ipl.controller;

import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ipl.model.Player;
import com.ipl.service.PlayerService;
@Controller
public class PlayerController {
	@Autowired
	PlayerService playerService;

	/*@RequestMapping(value = "/addPlayer", method = RequestMethod.GET)
	public String addTeam() {

		Player player = new Player();
		JSONParser parser = new JSONParser();
		try {
			Object ob = parser.parse(new FileReader("/home/bridgeit/com/ipl/players/rising_pune_supergiants.json"));
			JSONObject object = (JSONObject) ob;

			JSONArray data = (JSONArray) object.get("Playersinfo");
			String[] str = { "Dhoni", "Ankit", "Baba", "Ravichandran", "Murugan", "Ankush", "Rajat", "Scott", "Deepak",
					"Ashok", "Francois", "Peter", "Jaskaran", "Mitchell", "Albie", "Ishwar", "Irfan",
					"Thisara", "Kevin", "Ajinkya", "Ishant", "RP","Steve", "Saurabh", "Adam", "Usman","George"};
			for (int i = 0; i < data.size(); i++) {
				JSONObject itemObj = (JSONObject) data.get(i);
				JSONArray item = (JSONArray) itemObj.get(str[i]);
				for (int y = 0; y < item.size(); y++) {
					JSONObject itemData = (JSONObject) item.get(y);
					Object nameObj = itemData.get("player_name");
					String playerName = (String) nameObj;
					player.setName(playerName);

					Object imgObject = itemData.get("player_img_url");
					String playerPic = (String) imgObject;
					player.setDisplayPicture(playerPic);

					Object roleObj = itemData.get("player_role");
					String roleName = (String) roleObj;
					player.setRole(roleName);

					Object battingStyleObj = itemData.get("player_batting_style");
					String battingStyleName = (String) battingStyleObj;
					player.setBattingStyle(battingStyleName);

					Object bowlingObj = itemData.get("player_bowling_style");
					String bowlingName = (String) bowlingObj;
					player.setBowlingStyle(bowlingName);

					Object nationalityObj = itemData.get("player_nationality");
					String nationalityName = (String) nationalityObj;
					player.setNationality(nationalityName);

					Object dobObj = itemData.get("player_dob");
					String dobName = (String) dobObj;
					player.setDob(dobName);

					Object teamIdObj = itemData.get("team_id");
					Integer teamIdName = Integer.valueOf((String) teamIdObj);
					player.setTeamId(teamIdName);
					playerService.addPlayer(player);

				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return "login";
	}*/
	/*@RequestMapping(value = "/addPlayer", method = RequestMethod.GET)
	public String newTeam() {

		Player player = new Player();
		JSONParser parser = new JSONParser();
		try {
			Object ob = parser.parse(new FileReader("/home/bridgeit/com/ipl/players/kolkata_knight_riders.json"));
			JSONObject object = (JSONObject) ob;

			JSONArray data = (JSONArray) object.get("Playersinfo");
			for (int i = 0; i < data.size(); i++) {
				JSONObject itemObj = (JSONObject) data.get(i);
					Object nameObj = itemObj.get("player_name");
					String playerName = (String) nameObj;
					player.setName(playerName);

					Object imgObject = itemObj.get("player_img_url");
					String playerPic = (String) imgObject;
					player.setDisplayPicture(playerPic);

					Object roleObj = itemObj.get("player_role");
					String roleName = (String) roleObj;
					player.setRole(roleName);

					Object battingStyleObj = itemObj.get("player_batting_style");
					String battingStyleName = (String) battingStyleObj;
					player.setBattingStyle(battingStyleName);

					Object bowlingObj = itemObj.get("player_bowling_style");
					String bowlingName = (String) bowlingObj;
					player.setBowlingStyle(bowlingName);

					Object nationalityObj = itemObj.get("player_nationality");
					String nationalityName = (String) nationalityObj;
					player.setNationality(nationalityName);

					Object dobObj = itemObj.get("player_dob");
					String dobName = (String) dobObj;
					player.setDob(dobName);

					Object teamIdObj = itemObj.get("team_id");
					Integer teamIdName = Integer.valueOf((String) teamIdObj);
					player.setTeamId(teamIdName);
					playerService.addPlayer(player);

				
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return "login";
	}
	*/

	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public ModelAndView displayAllTeam(@RequestParam("teamId") int teamId)
	{

		List<Player> playerInfo = playerService.displayAllPlayer(teamId);
		return new ModelAndView("players", "playerInfo", playerInfo);
	}
	@RequestMapping(value = "/playerinfo", method = RequestMethod.GET)
	public ModelAndView displayTeamDetails(@RequestParam("playerName")String playerName)
	{
		
        List<Player> playerDeatils=playerService.displayPlayerInfo(playerName);
		return new ModelAndView("playerinfo", "playerDetails", playerDeatils);

	}
}