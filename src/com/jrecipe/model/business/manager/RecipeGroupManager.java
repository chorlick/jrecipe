package com.jrecipe.model.business.manager;

import com.jrecipe.model.business.exception.ServiceLoadException;
import com.jrecipe.model.domain.ApplicationState;
import com.jrecipe.model.services.exception.RecipeGroupException;
import com.jrecipe.model.services.factory.ServiceFactory;
import com.jrecipe.model.services.recipegroupservice.RecipeGroupServiceImpl;
import com.jrecipe.model.services.recipeservice.IRecipeService;

/**
 * Manager for RecipeGroups.
 * 
 * @author Chris Horlick
 * @version 0.0.6
 * @since 0.0.6
 */
public class RecipeGroupManager  extends ManagerSuperType {

	/**
	 * Public interface that clients can use to call certain actions. 
	 * 
	 * @param commandString Command the client wants to issue. 
	 * @param app ApplicationState object that is used to represent the application internal state.
	 */
	@Override
	public void performAction(String commandString, ApplicationState app) {
		if (commandString.equals("CreateGroup")) {
			createGroup(IRecipeService.NAME, app);
		}
	}

	private void createGroup(String name, ApplicationState app) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		RecipeGroupServiceImpl iRecipeGroupServiceImpl;		
		try {
			iRecipeGroupServiceImpl = (RecipeGroupServiceImpl) serviceFactory.getService(name);
			app.group = iRecipeGroupServiceImpl.createRecipeGroup();
			iRecipeGroupServiceImpl.saveRecipeGroup(app.group);
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			System.out.println("Error loading service");
		} catch (RecipeGroupException e) {
			e.printStackTrace();
		}
				
	}

}
