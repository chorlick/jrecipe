package com.jrecipe.model.services.recipegroupservice;

import static org.junit.Assert.*;

import org.junit.Before;
import com.jrecipe.model.business.exception.ServiceLoadException;
import com.jrecipe.model.domain.RecipeGroup;
import com.jrecipe.model.services.exception.RecipeGroupException;
import com.jrecipe.model.services.exception.RecipeGroupNotFoundException;
import com.jrecipe.model.services.factory.ServiceFactory;

/** 
 * Simple JUnit test class to test the functionality
 * of the RecipeGroupServiceImplTest class. 
 * 
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public class RecipeGroupServiceImplTest {
	
	/**
	 * Singleton reference object for testing
	 */
	ServiceFactory serviceFactory;
	
	/**
	 * Sets up the service factory object for testing.
	 * @throws Exception Throws exception on unable to get instance. 
	 */
	@Before
	public void setUp() throws Exception {
		serviceFactory = ServiceFactory.getInstance();		
	}
	
	/**
	 * Searches the group for a single recipe.
	 */
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
		} catch (ServiceLoadException e ) {
			e.printStackTrace();
			fail("Service load issue");
		} catch (RecipeGroupNotFoundException e) {
			e.printStackTrace();
			fail("Recipe group not found");
		} catch (RecipeGroupException e) {
			e.printStackTrace();
			fail("Recipe group not found");
		}
	}
	
}
