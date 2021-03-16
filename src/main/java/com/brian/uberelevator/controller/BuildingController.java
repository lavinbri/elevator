package com.brian.uberelevator.controller;

import java.util.Comparator;
import java.util.List;

import com.brian.uberelevator.model.Building;
import com.brian.uberelevator.model.Elevator;
import com.brian.uberelevator.repos.BuildingRepository;

/**
 * Controller class for building interactions
 * 
 *
 */
public class BuildingController {

	/**
	 * Get a list of buildings
	 * 
	 * @return List of available buildings
	 */
	public List<Building> getBuildings(){
		return BuildingRepository.getInstance().listBuildings();
	}
	
	/**
	 * Get a building
	 * 
	 * @param id Identifier of a building
	 * @return Building
	 */
	public Building getBuilding(String id) {
		return BuildingRepository.getInstance().readBuilding(id);	
	}
	
	/**
	 * Get a list of elevators in a building
	 * 
	 * @param buildingId Identifier of a building
	 * @return List of elevators
	 */
	public List<Elevator> getElevators(String buildingId) {
		
		Building building = this.getBuilding(buildingId);
		
		if (building != null) {
			return building.getElevators();
		}
		return null;
	}

	/**
	 * Summon an elevator to a floor
	 * 
	 * This method filters the available elevators from the list and then chooses
	 * the one which has the least number of floors to travel
	 * 
	 * @param buildingId Identifier of a building
	 * @param requestedFloor Floor number
	 * @return Elevator 
	 */
	public Elevator summonElevator(String buildingId, Integer requestedFloor) {
		
		// Get the list of elevators for this building
		List<Elevator> elevatorList = this.getElevators(buildingId);

		
		// Filter and find the one that is closest
		Elevator targetElevator  = elevatorList.stream()
				.filter(Elevator::isAvailable)
				.min(Comparator.comparing(Elevator::getFloor))
				.orElse(null);
		
		targetElevator.setFloor(requestedFloor);
		
		return targetElevator;
	}
}
