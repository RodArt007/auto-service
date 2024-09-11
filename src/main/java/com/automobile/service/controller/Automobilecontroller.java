package com.automobile.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automobile.service.dto.AutomobileDto;
import com.automobile.service.service.AutomobileService;

@RestController
@RequestMapping("api/v1/automobiles")
public class Automobilecontroller {
	
	@Autowired
	private AutomobileService automobileService;
	
	@PostMapping
	public ResponseEntity<AutomobileDto> createAutomobile(@RequestBody AutomobileDto newAutomobile){
		AutomobileDto savedAutomobile = automobileService.createAutomobile(newAutomobile);
		return new ResponseEntity<>(savedAutomobile, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AutomobileDto> getAutomobileById(@PathVariable("id") Integer automobileId){
		AutomobileDto automobile = automobileService.getAutomobileById(automobileId);
		return  ResponseEntity.ok(automobile);	
	}
	
	@GetMapping
	public ResponseEntity<List<AutomobileDto>> getAllAutomobiles(){
		List<AutomobileDto> automobiles = automobileService.getAllAutomobiles();
		return ResponseEntity.ok(automobiles);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AutomobileDto> updateAutomobile(@PathVariable Integer automobileId,
			                                              @RequestBody AutomobileDto updatedAutomobileDto){
		AutomobileDto updatedAutomobile = automobileService.updateAutomobile(automobileId, updatedAutomobileDto);
		return ResponseEntity.ok(updatedAutomobile);
	}
	
	@DeleteMapping("/id")
	public ResponseEntity<String> deleteAutomobile(@PathVariable Integer automobileId){
		automobileService.deleteAutomobile(automobileId);
		return ResponseEntity.ok("Automobile deleted successfully!");
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<AutomobileDto>> getAllAutomobileByUserId(@PathVariable("userId") Long userId){
		List<AutomobileDto> automobilesByUserId = automobileService.getAutomobileByUserId(userId);
		return  ResponseEntity.ok(automobilesByUserId);	
	}
	
}
