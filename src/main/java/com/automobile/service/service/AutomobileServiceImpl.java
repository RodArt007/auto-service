package com.automobile.service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automobile.service.dto.AutomobileDto;
import com.automobile.service.entity.Automobile;
import com.automobile.service.exception.ResourceNotFoundException;
import com.automobile.service.mapper.AutomobileMapper;
import com.automobile.service.repository.AutomobileRepository;

@Service
public class AutomobileServiceImpl implements AutomobileService {

	@Autowired
	AutomobileRepository automobileRepository;
	
	@Override
	public AutomobileDto createAutomobile(AutomobileDto automobileDto) {
		
		Automobile automobile = AutomobileMapper.mapToAutomobile(automobileDto);
		return AutomobileMapper.
				mapToAutomobileDto(automobileRepository.save(automobile));
	}

	@Override
	public AutomobileDto getAutomobileById(int autoId) {
		
		Automobile automobile = automobileRepository.findById(autoId)
				.orElseThrow(()-> new ResourceNotFoundException(
						"Automobile does not exist with id given: " + autoId));
		
		return AutomobileMapper.mapToAutomobileDto(automobile);
	}

	@Override
	public List<AutomobileDto> getAllAutomobiles() {
		
		List<Automobile> automobiles = automobileRepository.findAll();
		return automobiles.stream().map((automobile)-> AutomobileMapper.mapToAutomobileDto(automobile))
				.collect(Collectors.toList());
	}
	
	@Override
	public AutomobileDto updateAutomobile(int autoId, AutomobileDto automobileDto) {
		
		Automobile automobile = automobileRepository.findById(autoId)
				.orElseThrow(()-> new ResourceNotFoundException(
						"Automobile does not exist with id given: " + autoId));
		
		automobile.setBrand(automobileDto.getBrand());
		automobile.setModel(automobileDto.getModel());
		automobile.setType(automobileDto.getType());
		automobile.setUserId(automobileDto.getUserId());
		
		return AutomobileMapper.mapToAutomobileDto(automobileRepository.save(automobile));
	}

	@Override
	public void deleteAutomobile(int autoId) {

		Automobile automobile = automobileRepository.findById(autoId)
				.orElseThrow(()-> new ResourceNotFoundException(
						"Automobile does not exist with id given: " + autoId));
		
		automobileRepository.deleteById(automobile.getId());
		
	}
	
	@Override
	public List<AutomobileDto> getAutomobileByUserId(Long userId) {

		List<Automobile> automobiles = automobileRepository.findByUserId(userId);
		return automobiles.stream().map((automobile)-> AutomobileMapper.mapToAutomobileDto(automobile))
				.collect(Collectors.toList());
		
	}	
	
}
