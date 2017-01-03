package com.spreadsheet.services;

import org.springframework.stereotype.Repository;

import com.spreadsheet.model.QuickStartDto;

@Repository
public interface QuickStartService {
	public void saveData(QuickStartDto qsDto);
}