package com.brian.uberelevator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import com.brian.uberelevator.controller.BuildingController;

/**
 * Test class for Building controller
 *
 */
@SpringBootTest
public class BuildingControllerTest {

	private BuildingController controller = new BuildingController();
	
	@Test
	void test_getBuildings() {
		Assert.isTrue(controller.getBuildings().size() > 0, "No buildings found");
	}
	
	@Test
	void test_getBuilding_validID() {
		// TODO
		// check that valid building is returned
	}
	
	@Test
	void test_getBuilding_invalidID() {
		// TODO
		// check that exception is thrown when invalid identifier
	}
	
	@Test
	void test_getElevators() {
		// TODO
		// check that list of elevators is returned
	}
	
	@Test
	void test_summonElevator_valid() {
		// TODO
		// check that list of elevators is returned
	}
	
	@Test
	void test_summonElevator_none_available() {
		// TODO
		// check that if elevators are out of service then none are returned
	}
	
}
