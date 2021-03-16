package com.brian.uberelevator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.brian.uberelevator.controller.UserController;

/**
 * Test class for User Controller
 *
 */
@SpringBootTest
public class UserControllerTest {

	private UserController controller = new UserController();
	
	@Test
	void test_getUsers() {
		Assert.isTrue(controller.getUsers().size() > 0, "No users found");
	}
	
	void test_getUser_validId() {
		// TODO
		// request user with invalid id
	}
	
	void test_getUser_invalidId() {
		// TODO
		// request user with invalid id
	}
	
	void test_createUser() {
		// TODO
		// create a valid user
	}
	
	void test_changeName() {
		// TODO
		// Change a user name
	}
	
	void test_changeBuilding() {
		// TODO
		// Change a user building		
	}
	
	void test_changeBuilding_invalidBuildingId() {
		// TODO
		// Change a user building but pass an invalid id		
	}
}
