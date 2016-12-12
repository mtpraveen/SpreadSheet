package com.ipl.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ipl.dao.TeamDao;
import com.ipl.model.Team;

@Repository
@Transactional
public class TeamDaoImpl implements TeamDao {
	@Autowired
	SessionFactory sessionFactory;

	public void addTeam(Team team) {

		Session sess = sessionFactory.getCurrentSession();
		try {
		sess.save(team);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List displayAllTeam() {
		Session sess = sessionFactory.getCurrentSession();
		Query qry=sess.createQuery("from Team");
		List teamsinfo=qry.list();
		return teamsinfo;
	}

	public List teamInfo(String teamName) {
		Session sess = sessionFactory.getCurrentSession();
		Query qry=sess.createQuery("from Team where name=:teamName");
		qry.setParameter("teamName", teamName);
		List teamDetails=qry.list();
		return teamDetails;
	}

	

	

}