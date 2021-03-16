package com.brian.uberelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model class for Building
 * 
 */
@XmlRootElement
public class Building {

	private String id;
	private String name;
	private String location;
	private List<Elevator> elevatorList = new ArrayList<Elevator>();
	private Integer maxFloors = 100;
	
	
	/**
	 * Get the building id
	 * 
	 * @return Building identifier
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Set the building id
	 * 
	 * @param id Building identifier
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Get the building name
	 * 
	 * @return Building name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the building name
	 * 
	 * @param name Building name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the building location
	 * 
	 * @return Building location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Set the building location
	 * 
	 * @return Building location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Get a list of the building's elevators
	 * 
	 * @return List of elevators
	 */
	public List<Elevator> getElevators(){
		return elevatorList;
	}
	
	
}
