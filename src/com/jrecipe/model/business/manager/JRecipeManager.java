package com.jrecipe.model.business.manager;

import java.io.IOException;

import com.jrecipe.model.business.exception.ServiceLoadException;
import com.jrecipe.model.domain.ApplicationState;
import com.jrecipe.model.services.factory.ServiceFactory;
import com.jrecipe.model.services.recipeservice.IRecipeService;
import com.jrecipe.model.services.recipeservice.RecipeServiceImpl;

/**
 * Class that represents the manager for the entire application. 
 * 
 * @author Chris Horlick
 * @version 0.0.5
 * @since 0.0.5
 */
public class JRecipeManager extends ManagerSuperType {
	
	/* the instance object for the singleton pattern */
	private static JRecipeManager instance;


	/* This is the constructor, we want to keep it hidden
	 * to no one can instantiate because we are using a singleton 
	 * pattern. 
	 */
	private JRecipeManager() {}
	
	/**
	 * Singleton get instance object function. Just
	 * returns the object or creates it and returns it. 
	 * 
	 * @return Instance object for the singleton. 
	 */
	public static synchronized JRecipeManager getInstance() {
		if (instance == null) {
			instance = new JRecipeManager();
		}
		return instance;
	}

	/**
	 * Generic method that all clients of this class can call to perform certain
	 * actions. Adapted from homework to work with my use case. 
	 * *Taken from the homework.
	 * 
	 * @author mike prassad
	 * @param commandString Holds the service name to be invoked
	 * @return Recipe the newly created object;
	 */
	@Override
	public Boolean performAction(String commandString, ApplicationState app) {
		Boolean action = false;
		if (commandString.equals("CreateRecipe")) {
			createRecipe(IRecipeService.NAME, app);
		}
		return action;
	}

	private Boolean createRecipe(String name, ApplicationState app) {
		Boolean action = false;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		RecipeServiceImpl iRecipeServiceImpl;		
		try {
			iRecipeServiceImpl = (RecipeServiceImpl) serviceFactory.getService(name);
			app.recipe = iRecipeServiceImpl.createRecipe();
			action = iRecipeServiceImpl.saveRecipeStep(app.recipe);
			return action;
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			System.out.println("Error loading service");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return action;
	}
}
