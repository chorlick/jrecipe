package com.jrecipe.model.business.manager;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jrecipe.model.domain.ApplicationState;

/**
 * Small test class to test the functionality of the 
 * recipe manager. 
 */
public class JRecipeManagerTest {
	
	/**
	 * Test that the manager class can create a new recipe.
	 */
	@Test 
	public void testManagerCreateRecipe() {
		JRecipeManager manager = JRecipeManager.getInstance();
		ApplicationState app = new ApplicationState();
		manager.performAction("CreateRecipe", app);
		System.out.println("Valid : " + app.recipe.validate());
		System.out.println("String " + app.recipe.toString());
		assertTrue(app.recipe.validate());
	}

}
