package com.brian.uberelevator.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model class for Elevator Request
 *
 */
@XmlRootElement
public class ElevatorRequest {

	private String buildingId;
	private Integer floor;

	/**
	 * Get the building id
	 * 
	 * @return Building id
	 */
	public String getBuildingId() {
		return buildingId;
	}
	
	/**
	 * Set the building id
	 * 
	 * @return Building id
	 */
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	
	/**
	 * Get the building floor number
	 * 
	 * @return Building floor number
	 */
	public Integer getFloor() {
		return floor;
	}
	
	/**
	 * Set the building floor number
	 * 
	 * @return Building floor number
	 */
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	
}
