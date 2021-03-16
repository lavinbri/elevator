package com.brian.uberelevator.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.brian.uberelevator.controller.UserController;
import com.brian.uberelevator.model.User;
import com.brian.uberelevator.repos.UserRepository;

/**
 * Resource class for User API requests
 *
 */
@Path("/users")
public class UserAPI {

	private UserController controller = new UserController();
	
	/**
	 * Get the list of users
	 * 
	 * If there are no users then an empty list will be returned
	 * 
	 * @return List of User
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
				
		return controller.getUsers();
	}
	
	/**
	 * Get a user based on a user id
	 * 
	 * If the user is not available it will return a 404
	 * 
	 * @param id User identifier
	 * @return User
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") Integer id) {
		
		User user = controller.getUser(id);
		
		if (user == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return user;
		
	}
	
	
	/**
	 * Create a user
	 * 
	 * Creates a user and assigns it an Id. If one was passed in with the request
	 * it will be ignored.
	 * 
	 * @param user Valid user
	 * @return User created
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public User createUser(User user) {
		
		return controller.createUser(user);
	}
	
	/**
	 * Changes a users name
	 * 
	 * The body of this request takes a full User but it will ignore all fields
	 * other than the name one
	 * 
	 * @param id User identifier
	 * @param user A user object
	 * @return The updated user
	 */
	@POST
	@Path("/{id}/changeName")
	@Consumes(MediaType.APPLICATION_JSON)
	public User changeName(@PathParam("id") Integer id, User user) {
		
		User targetUser = controller.changeName(id, user.getName());
		return targetUser;
	}
	
	/**
	 * Changes a users building
	 * 
	 * The body of this request takes a full User but it will ignore all fields
	 * other than the buildingId.
	 * 
	 * If the buildingId is invalid it will throw a 400 code.
	 * 
	 * @param id User identifier
	 * @param user A user object
	 * @return The updated user
	 */
	@POST
	@Path("/{id}/changeBuilding")
	@Consumes(MediaType.APPLICATION_JSON)
	public User changeBuilding(@PathParam("id") Integer id, User user) {
		
		User targetUser = null;
		
		try{
			targetUser = controller.changeBuilding(id, user.getBuildingId());
		}
		catch(IllegalArgumentException ex) {
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		
		return targetUser;
	}
	
}
