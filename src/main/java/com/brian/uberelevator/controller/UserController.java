package com.brian.uberelevator.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.brian.uberelevator.model.User;
import com.brian.uberelevator.repos.UserRepository;

/**
 * Controller class for User interactions
 *
 */
public class UserController {

	/**
	 * Get a list of users
	 * 
	 * @return List of users
	 */
	public List<User> getUsers() {		
		return UserRepository.getInstance().listUsers();
	}
	
	
	/**
	 * Get a user
	 * 
	 * @param id User identifier
	 * @return User
	 */
	public User getUser(Integer id) {
		
		return UserRepository.getInstance().readUser(id);
	}
	
	/**
	 * Create a user
	 * 
	 * @param user User to create
	 * @return Created user
	 */
	public User createUser(User user) {
		
		UserRepository.getInstance().addUser(user);
		return user; 
	}
	
	/**
	 * Change the name of a user
	 * 
	 * @param userId User identifier
	 * @param newName Name to change to
	 * @return Updated user
	 */
	public User changeName(Integer userId, String newName) {
		
		User foundUser = this.getUser(userId);
		foundUser.setName(newName);
		
		return foundUser;
		
	}
	
	/**
	 * Change the building of a user
	 * 
	 * This method checks that there is a building with that id. If not
	 * then it will throw an exception.
	 * 
	 * @param userId User identifier
	 * @param newBuildingId Building identifier
	 * @return Updated user
	 */
	public User changeBuilding(Integer userId, String newBuildingId) {
		
		User foundUser = this.getUser(userId);
		
		BuildingController buildingController = new BuildingController();
		
		try {
			buildingController.getBuilding(newBuildingId);
		}
		catch(NoSuchElementException ex) {
			throw new IllegalArgumentException("No such building id");
		}
		
		foundUser.setBuildingId(newBuildingId);
		return foundUser;
		
	}
}
