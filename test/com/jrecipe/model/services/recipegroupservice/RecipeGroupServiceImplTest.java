package com.jrecipe.model.services.recipegroupservice;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.jrecipe.model.business.exception.ServiceLoadException;
import com.jrecipe.model.domain.Ingredient;
import com.jrecipe.model.domain.Recipe;
import com.jrecipe.model.domain.RecipeGroup;
import com.jrecipe.model.services.exception.RecipeGroupNotFoundException;
import com.jrecipe.model.services.exception.RecipeGroupSearchFailedException;
import com.jrecipe.model.services.factory.ServiceFactory;
import com.jrecipe.model.services.recipeservice.RecipeServiceImpl;

import junit.framework.TestCase;

/** 
 * Simple JUnit test class to test the functionality
 * of the RecipeGroupServiceImplTest class. 
 * 
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public class RecipeGroupServiceImplTest extends TestCase {
	ServiceFactory serviceFactory;
	
	@Before
	public void setUp() throws Exception {
		serviceFactory = ServiceFactory.getInstance();		
	}
	
	/**
	 * Searches the group for a single recipe.
	 */
	@Test
	public void testSearchGroup() {
		RecipeGroupServiceImpl service;
		RecipeGroup group;
		RecipeGroup load;
		try {
			service = (RecipeGroupServiceImpl) serviceFactory.getService("RecipeGroupService");
			group = service.createRecipeGroup();
			group.setName("Breakfast");
			service.saveRecipeGroup(group);
			load = service.loadRecipeGroup(group.getUid());
			assertTrue(load.equals(group));	
		} catch (ServiceLoadException | IOException e) {
			e.printStackTrace();
			fail("Service load issue");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail("Class not found");
		} catch (RecipeGroupNotFoundException e) {
			e.printStackTrace();
			fail("Recipe group not found");
		}
	}
	
}
