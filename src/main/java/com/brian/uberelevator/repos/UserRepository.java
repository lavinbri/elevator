package com.brian.uberelevator.repos;

import java.util.ArrayList;
import java.util.List;

import com.brian.uberelevator.model.User;

/**
 * Repository class for maintaining state of Users 
 *
 */
public class UserRepository {

	private List<User> userList = new ArrayList<User>();
	
	private static UserRepository repository = null;
	private Integer maxId = 0;

	private UserRepository() {
		setup();
	}
	
	/**
	 * Get a single instance of this class
	 * 
	 * @return UserRepository
	 */
	public static UserRepository getInstance() {
		
		if (repository == null) {
			repository = new UserRepository();
		}
		return repository;		
	}
	
	/**
	 * List all users
	 * 
	 * @return List of User
	 */
	public List<User> listUsers(){		
		return userList;
	}
	
	/**
	 * Add a User
	 * 
	 * @param newUser User to add
	 * @return User added
	 */
	public User addUser(User newUser){

		newUser.setId(maxId + 1);
		userList.add(newUser);
		maxId = maxId + 1;
		return newUser;
	}
	
	/**
	 * Get a user
	 * 
	 * @param userId User identifier
	 * @return User
	 */
	public User readUser(Integer userId) {
		
		User foundUser = null;
		
		for (User user: userList) {
			if (user.getId() == userId) {
				foundUser = user;
			}
		}
		return foundUser;
	}
	
	/*
	 * Set up dummy data
	 */
	private void setup() {
		
		userList = new ArrayList<User>();
		
		User user1 = new User();
		user1.setId(1);
		user1.setName("John Smith");
		user1.setBuildingId("B1");
		user1.setFloor(14);
		
		
		User user2 = new User();
		user2.setId(2);
		user2.setName("Jim James");
		user2.setBuildingId("B1");
		user2.setFloor(32);
		
		userList.add(user1);
		userList.add(user2);
		
		maxId = 2;
	}
}
