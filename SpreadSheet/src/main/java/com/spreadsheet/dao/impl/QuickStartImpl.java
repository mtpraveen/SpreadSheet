package com.spreadsheet.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spreadsheet.Dao.QuickStartDao;
import com.spreadsheet.model.QuickStartDto;

@Transactional
public class QuickStartImpl implements QuickStartDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveData(QuickStartDto qsDto) {
		Session ses = sessionFactory.getCurrentSession();
		//Transaction tr = ses.beginTransaction();
		try {
			ses.save(qsDto);
			//tr.commit();
		} catch (Exception e) {
			//tr.rollback();
			e.printStackTrace();
		}
	}
	

}
