package com.spreadsheet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.spreadsheet.Dao.QuickStartDao;
import com.spreadsheet.model.QuickStartDto;
import com.spreadsheet.services.QuickStartService;



public class QuickStartServiceImpl implements QuickStartService {
	@Autowired
    private QuickStartDao qsDao;
	
    public void saveData(QuickStartDto qsDto) {
    	qsDao.saveData(qsDto);
	}
}
