package com.javaweb.model;

public class BuildingDTO {
	private String name;
	private String address;
	private Long numberOfBasement;
	private String nameOfManager;
	private String phoneOfManager;
	private Long floorArea;
	private Long rentPrice;
	private Long serviceFee;
	private Long brokerageFee;
	private String rentArea;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getNameOfManager() {
		return nameOfManager;
	}
	public void setNameOfManager(String nameOfManager) {
		this.nameOfManager = nameOfManager;
	}
	public String getPhoneOfManager() {
		return phoneOfManager;
	}
	public void setPhoneOfManager(String phoneOfManager) {
		this.phoneOfManager = phoneOfManager;
	}
	public Long getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}
	public Long getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}
	public Long getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Long serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Long getBrokerageFee() {
		return brokerageFee;
	}
	public void setBrokerageFee(Long brokerageFee) {
		this.brokerageFee = brokerageFee;
	}
	public String getRentArea() {
		return rentArea;
	}
	public void setRentArea(String rentArea) {
		this.rentArea = rentArea;
	}
	
}
