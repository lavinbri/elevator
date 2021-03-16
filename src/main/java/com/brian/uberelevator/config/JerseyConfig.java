package com.brian.uberelevator.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.brian.uberelevator.api.BuildingAPI;
import com.brian.uberelevator.api.UserAPI;

@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		
		register(UserAPI.class);
		register(BuildingAPI.class);
		
	}
}
