package com.jrecipe.model.business.manager;

import com.jrecipe.model.business.exception.PropertyFileNotFoundException;
import com.jrecipe.model.domain.ApplicationState;
import com.jrecipe.model.services.manager.PropertyManager;

/**
 * Exception thrown if the application.properties file attempts to reference an
 * object that dosent exist.
 * 
 * @author Chris Horlick
 * @version 0.0.5
 * @since 0.0.5
 */
public abstract class ManagerSuperType {

	/*
	 * Static block to load the properties file or exit the app. Just like in
	 * c/c++ static values are established in the binary before any other run
	 * time events.
	 */
	static {
		try {
			ManagerSuperType.loadProperties();
		} catch (PropertyFileNotFoundException propertyFileNotFoundException) {
			System.out.println("Application Properties failed to be loaded - Application exiting...");
			System.exit(1); 
		}
	}

	/**
	 * This class simply load the properties file into memory. It functions
	 * similar to a singleton by keeping a static global reference available to
	 * other classes.
	 * 
	 * @throws PropertyFileNotFoundException
	 *             Thrown when the propertyLoc value is not provided. This means
	 *             that the application.properties file cant be loaded.
	 */
	public static void loadProperties() throws PropertyFileNotFoundException {
		String propertyFileLocation = System.getProperty("propertyLoc");
		if (propertyFileLocation != null) {
			PropertyManager.loadProperties(propertyFileLocation);
		} else {
			System.out.println("Property file location not set. Passed in value is: " + propertyFileLocation + ".");
			throw new PropertyFileNotFoundException("Property file location not set");
		}
	}

	/**
	 * Public interface that clients can use to call certain actions. 
	 * 
	 * @param commandString Command the client wants to issue. 
	 * @param app ApplicationState object that is used to represent the application internal state.
	 * @return returns Boolean, true if the action was successful.
	 */
	public abstract Boolean performAction(String commandString, ApplicationState app);
}
