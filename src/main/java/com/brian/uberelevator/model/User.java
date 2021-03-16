package com.brian.uberelevator.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * User
 *
 */
@XmlRootElement
public class User {

	private Integer id;
	private String name;
	private String buildingId;
	private Integer currentFloor;
	

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	
	public Integer getFloor() {
		return this.currentFloor;
	}
	
	public void setFloor(Integer floor) {
		this.currentFloor = floor;
	}
	
}
