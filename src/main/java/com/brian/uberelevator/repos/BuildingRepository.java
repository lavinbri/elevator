package com.brian.uberelevator.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.brian.uberelevator.model.Building;
import com.brian.uberelevator.model.Elevator;

/**
 * Singleton Repository class for handling state of buildings 
 *
 */
public class BuildingRepository {

	private static BuildingRepository repository = null;
	private List<Building> buildingList = new ArrayList<Building>();
	
	private BuildingRepository() {
		setup();
	}
	
	/**
	 * Return a single instance of the Repository
	 * 
	 * @return BuildingRepository
	 */
	public static BuildingRepository getInstance() {
		
		if (repository == null) {
			repository = new BuildingRepository();
		}
		return repository;
		
	}
	
	/**
	 * List all buildings
	 * 
	 * @return List of buildings
	 */
	public List<Building> listBuildings(){
		return buildingList;
	}
	
	/**
	 * Read a single building instance
	 * 
	 * @param buildingId Building Identifier
	 * @return Building
	 * @throws NoSuchElementException if no match for that identifier
	 */
	public Building readBuilding(String buildingId) throws NoSuchElementException {
		
		Building foundBuilding = null;
		
		for (Building building: buildingList) {
			if (building.getId().equalsIgnoreCase(buildingId)) {
				foundBuilding = building;
			}
		}
		
		if (foundBuilding == null) {
			throw new NoSuchElementException();
		}
		
		return foundBuilding;
	}
	
	/*
	 * Set up the list with dummy data
	 * 
	 */
	private void setup() {
		
		Building building1 = new Building();
		building1.setId("B1");
		building1.setLocation("Downtown");
		building1.setName("First Building");
		
		Elevator elevatorA = new Elevator();
		elevatorA.setId("EL-A");
		elevatorA.setName("Elevator A");
		elevatorA.setFloor(1);
		
		Elevator elevatorB = new Elevator();
		elevatorB.setId("EL-B");
		elevatorB.setName("Elevator B");
		elevatorA.setFloor(33);
		
		building1.getElevators().add(elevatorA);
		building1.getElevators().add(elevatorB);
		
		buildingList.add(building1);
		
	}
}
