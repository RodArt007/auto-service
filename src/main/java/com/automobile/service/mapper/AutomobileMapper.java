package com.automobile.service.mapper;

import com.automobile.service.dto.AutomobileDto;
import com.automobile.service.entity.Automobile;

public class AutomobileMapper {
	
	public static AutomobileDto mapToAutomobileDto(Automobile automobile) {
		return new AutomobileDto(
				automobile.getId(),
				automobile.getBrand(),
				automobile.getModel(),
				automobile.getType(),
				automobile.getUserId()				
				);
	}
	
	public static Automobile mapToAutomobile(AutomobileDto automobileDto) {
		return new Automobile(
				automobileDto.getId(),
				automobileDto.getBrand(),
				automobileDto.getModel(),
				automobileDto.getType(),
				automobileDto.getUserId()
				);
	}

}
