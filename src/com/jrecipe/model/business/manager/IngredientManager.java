package com.jrecipe.model.business.manager;

import com.jrecipe.model.business.exception.ServiceLoadException;
import com.jrecipe.model.domain.ApplicationState;
import com.jrecipe.model.services.exception.IngredientNotFoundException;
import com.jrecipe.model.services.exception.IngredientSaveException;
import com.jrecipe.model.services.factory.ServiceFactory;
import com.jrecipe.model.services.ingredientservice.IngredientServiceImpl;
import com.jrecipe.model.services.recipeservice.IRecipeService;

/**
 * Manager for Ingredients
 * 
 * @author Chris Horlick
 * @version 0.0.6
 * @since 0.0.6
 */
public class IngredientManager extends ManagerSuperType {

	/* the instance object for the singleton pattern */
	private static IngredientManager instance;


	/* This is the constructor, we want to keep it hidden
	 * to no one can instantiate because we are using a singleton 
	 * pattern. 
	 */
	private IngredientManager() {}
	
	/**
	 * Singleton get instance object function. Just
	 * returns the object or creates it and returns it. 
	 * 
	 * @return Instance object for the singleton. 
	 */
	public static synchronized IngredientManager getInstance() {
		if (instance == null) {
			instance = new IngredientManager();
		}
		return instance;
	}
	
	/**
	 * Public interface that clients can use to call certain actions. 
	 * 
	 * @param commandString Command the client wants to issue. 
	 * @param app ApplicationState object that is used to represent the application internal state.
	 * @return returns Boolean, true if the action was successful.
	 */
	@Override
	public Boolean performAction(String commandString, ApplicationState app) {
		if (commandString.equals("CreateIngredient")) {
			createIngredient(IRecipeService.NAME, app);
		}
		return true;
	}
	
	private void createIngredient(String name, ApplicationState app) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		IngredientServiceImpl iIngredientServiceImpl;		
		try {
			iIngredientServiceImpl = (IngredientServiceImpl) serviceFactory.getService(name);
			app.ingredient = iIngredientServiceImpl.createIngredient("", "", "");
			iIngredientServiceImpl.saveIngredient(app.ingredient);
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			System.out.println("Error loading service");
		} catch (IngredientNotFoundException e) {
			e.printStackTrace();
		} catch (IngredientSaveException e) {
			e.printStackTrace();
		}
				
	}

}
