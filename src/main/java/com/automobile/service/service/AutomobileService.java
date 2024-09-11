package com.automobile.service.service;

import java.util.List;

import com.automobile.service.dto.AutomobileDto;

public interface AutomobileService {
	AutomobileDto createAutomobile(AutomobileDto automobileDto);
	AutomobileDto getAutomobileById(int autoId);
	List<AutomobileDto> getAllAutomobiles();
	AutomobileDto updateAutomobile(int autoId, AutomobileDto automobileDto);
	void deleteAutomobile(int autoId); 
	
	List<AutomobileDto> getAutomobileByUserId(Long userId);

}
