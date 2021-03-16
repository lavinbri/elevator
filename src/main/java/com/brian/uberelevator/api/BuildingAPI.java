package com.brian.uberelevator.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.brian.uberelevator.controller.BuildingController;
import com.brian.uberelevator.model.Building;
import com.brian.uberelevator.model.Elevator;
import com.brian.uberelevator.model.ElevatorRequest;

/**
 * Resource class for Building API
 * 
 * Class to handle all building API requests
 */
@Path("/buildings")
public class BuildingAPI {

	private BuildingController controller = new BuildingController();
	
	
	/**
	 * Gets a list of all available buildings
	 * 
	 * If no buildings are found it will return an empty list
	 * 
	 * @return List of buildings
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Building> getBuildings(){
		return controller.getBuildings();
	}
	
	/**
	 * Gets a building based on its building id
	 * 
	 * If no building is found this will generate a 404 response code
	 * 
	 * @param id Identifier of a building
	 * @return Building
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Building getBuilding(@PathParam("id") String id) {
		
		Building building = controller.getBuilding(id);
		
		if (building == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return building;
	}
	
	/**
	 * Gets list of all elevators in a building
	 * 
	 * If no elevators are found then this will return an empty list
	 * 
	 * @param id Identifier of a building
	 * @return List of elevators
	 */
	@GET
	@Path("/{id}/elevators")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Elevator> getElevators(@PathParam("id") String id) {
		
		return controller.getElevators(id);
	}
	
	/**
	 * Command to summon an elevator
	 * 
	 * If no elevator is available then this will return a 503 code
	 * 
	 * @param id Identifier of a building
	 * @param request Elevator request
	 * @return Elevator
	 */
	@POST
	@Path("/{id}/summonElevator")
	@Produces(MediaType.APPLICATION_JSON)
	public Elevator summonElevator(@PathParam("id") String id, ElevatorRequest request) {
		
		Elevator elevator = controller.summonElevator(id, request.getFloor());
		
		if (elevator == null) {
			throw new WebApplicationException(Response.Status.SERVICE_UNAVAILABLE);
		}
		return elevator;			
		
	}
	
}
