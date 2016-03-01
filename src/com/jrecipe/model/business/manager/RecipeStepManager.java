package com.jrecipe.model.business.manager;

import com.jrecipe.model.domain.ApplicationState;

/**
 * Manger for RecipeSteps.
 * 
 * @author Chris Horlick
 * @version 0.0.6
 * @since 0.0.6
 */
public class RecipeStepManager extends ManagerSuperType {
	
	/* the instance object for the singleton pattern */
	private static RecipeStepManager instance;


	/* This is the constructor, we want to keep it hidden
	 * to no one can instantiate because we are using a singleton 
	 * pattern. 
	 */
	private RecipeStepManager() {}
	
	/**
	 * Singleton get instance object function. Just
	 * returns the object or creates it and returns it. 
	 * 
	 * @return Instance object for the singleton. 
	 */
	public static synchronized RecipeStepManager getInstance() {
		if (instance == null) {
			instance = new RecipeStepManager();
		}
		return instance;
	}

	/**
	 * Public interface that clients can use to call certain actions. 
	 * 
	 * @param commandString Command the client wants to issue. 
	 * @param app ApplicationState object that is used to represent the application internal state.
	 */
	@Override
	public void performAction(String commandString, ApplicationState app) {
		return ;
	}


}
