package com.automobile.service.dto;

public class AutomobileDto {
	private int id;
	private String brand;
	private String model;
	private String type;
	private Long userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public AutomobileDto () {
		super();
	}
	
	public AutomobileDto(int id, String brand, String model, String type, Long userId) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.type= type;
		this.userId = userId;
	}
	
}
