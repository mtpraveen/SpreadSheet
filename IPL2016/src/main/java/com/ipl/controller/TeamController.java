package com.ipl.controller;

import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ipl.model.Team;
import com.ipl.service.TeamService;

@Controller
public class TeamController {
	@Autowired
	TeamService teamService;

	/*@RequestMapping(value = "/addTeam", method = RequestMethod.GET)
	public String addTeam() {

		Team tem = new Team();
		JSONParser parser = new JSONParser();
		try {
			Object ob = parser.parse(new FileReader("/home/bridgeit/com/ipl/team_info.json"));
			JSONObject object = (JSONObject) ob;

			JSONArray data = (JSONArray) object.get("teaminfo");
			String[] str = { "DD", "GL", "KP", "KKR", "MU", "RPS", "RCB", "SH" };
			for (int i = 0; i < data.size(); i++) {
				JSONObject itemObj = (JSONObject) data.get(i);
				JSONArray item = (JSONArray) itemObj.get(str[i]);
				for (int y = 0; y < item.size(); y++) {
					JSONObject itemData = (JSONObject) item.get(y);
					Object nameObj = itemData.get("team_name");
					String teamName = (String) nameObj;
					tem.setName(teamName);

					Object coachObj = itemData.get("team_coach");
					String coachName = (String) coachObj;
					tem.setCoach(coachName);

					Object capatainObj = itemData.get("team_captain");
					String capatainName = (String) capatainObj;
					tem.setCaptain(capatainName);

					Object venueObj = itemData.get("team_home_venue");
					String venueName = (String) venueObj;
					tem.setHomeVenue(venueName);

					Object ownerObj = itemData.get("team_owner");
					String ownerName = (String) ownerObj;
					tem.setOwner(ownerName);

					Object logoObj = itemData.get("team_img_url");
					String logoName = (String) logoObj;
					tem.setLogo(logoName);
					teamService.addTeam(tem);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return "login";
	}
	*/
	
	/*@RequestMapping(value = "/addTeam", method = RequestMethod.GET)
	public String newTeam() {

		Team tem = new Team();
		JSONParser parser = new JSONParser();
		try {
			Object ob = parser.parse(new FileReader("/home/bridgeit/com/ipl/team_info.json"));
			JSONObject object = (JSONObject) ob;

			JSONArray data = (JSONArray) object.get("teaminfo");
			String[] str = { "DD", "GL", "KP", "KKR", "MU", "RPS", "RCB", "SH" };
			for (int i = 0; i < data.size(); i++) {
				JSONObject itemObj = (JSONObject) data.get(i);
				JSONArray item = (JSONArray) itemObj.get(str[i]);
				for (int y = 0; y < item.size(); y++) {
					JSONObject itemData = (JSONObject) item.get(y);
					Object nameObj = itemData.get("team_name");
					String teamName = (String) nameObj;
					tem.setName(teamName);

					Object coachObj = itemData.get("team_coach");
					String coachName = (String) coachObj;
					tem.setCoach(coachName);

					Object capatainObj = itemData.get("team_captain");
					String capatainName = (String) capatainObj;
					tem.setCaptain(capatainName);

					Object venueObj = itemData.get("team_home_venue");
					String venueName = (String) venueObj;
					tem.setHomeVenue(venueName);

					Object ownerObj = itemData.get("team_owner");
					String ownerName = (String) ownerObj;
					tem.setOwner(ownerName);

					Object logoObj = itemData.get("team_img_url");
					String logoName = (String) logoObj;
					tem.setLogo(logoName);
					teamService.addTeam(tem);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return "login";
	}*/
	
	@RequestMapping(value = "/teamList", method = RequestMethod.GET)
	public ModelAndView displayAllTeam() {
		List teamInfo = teamService.displayAllTeam();

		return new ModelAndView("display", "teamInfo", teamInfo);

	}
	@RequestMapping(value = "/teamDetails", method = RequestMethod.GET)
	public ModelAndView displayTeamDetails(@RequestParam("teamName")String teamName,Model model) {
		List teamDetails = teamService.teamInfo(teamName);
        model.addAttribute("msg", teamName);
		return new ModelAndView("teaminfo", "teamDetails", teamDetails);

	}

}
