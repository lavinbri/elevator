package com.brian.uberelevator.model;

/**
 * Model class for Elevator
 * 
 */
public class Elevator {

	enum ElevatorState {
		MOVING_UP,
		MOVING_DOWN,
		STOPPED,
		OUT_OF_SERVICE
	}
	private String id;	
	private String name;	
	private Integer floor = 1;
	private ElevatorState elevatorState = ElevatorState.STOPPED;
	

	/**
	 * Get Elevator ID
	 * 
	 * @return Elevator identifier
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Set Elevator ID
	 * 
	 * @return Elevator identifier
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Get Elevator Name
	 * 
	 * @return Elevator identifier
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set Elevator Name
	 * 
	 * @return Elevator identifier
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get Elevator Floor
	 * 
	 * @return Elevator floor number
	 */
	public Integer getFloor() {
		return floor;
	}
	
	/**
	 * Set the elevator floor
	 * 
	 * @param targetFloor Floor to move to
	 */
	public void setFloor(Integer targetFloor) {
		
		if (targetFloor > this.floor) {
			this.elevatorState = ElevatorState.MOVING_UP;
		}
		else if (targetFloor < this.floor) {
			this.elevatorState = ElevatorState.MOVING_DOWN;
		}
		else {
			this.elevatorState = ElevatorState.STOPPED;
		}
		
		this.floor = targetFloor;
		this.elevatorState = ElevatorState.STOPPED;
	}
	
	
	/**
	 * Get the state of the elevator
	 * 
	 * @return Elevator state
	 */
	public ElevatorState getElevatorState() {
		return elevatorState;
	}
	
	/**
	 * Set the state of the Elevator
	 * 
	 * @param elevatorState Elevator state
	 */
	public void setElevatorState(ElevatorState elevatorState) {
		this.elevatorState = elevatorState;
	}
	
	/**
	 * Check if the elevator is available to summon
	 * 
	 * @return Boolean - true if available
	 */
	public Boolean isAvailable() {
		return (elevatorState == ElevatorState.STOPPED);
	}
	
	
}
