package com.jrecipe.model.services.ingredientservice;

import org.junit.Before;
import org.junit.Test;

import com.jrecipe.model.business.exception.ServiceLoadException;
import com.jrecipe.model.domain.Recipe;
import com.jrecipe.model.services.factory.ServiceFactory;
import com.jrecipe.model.services.recipegroupservice.RecipeGroupServiceImpl;

import junit.framework.TestCase;

/** 
 * Simple JUnit test class to test the functionality
 * of the IngredientServiceImpl class. 
 * 
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public class IngredientServiceImplTest extends TestCase {


	ServiceFactory serviceFactory;
	
	@Before
	public void setUp() throws Exception {
		serviceFactory = ServiceFactory.getInstance();		
	}
	
	/**
	 * TEsts that the object returned from the create ingrediate
	 * service function is valid.
	 */
	@Test
	public void testCreatedIngredienttest() {
		IngredientServiceImpl service;
		try {
			service = (IngredientServiceImpl) serviceFactory.getService("IngredientService");
			assertTrue(service.createIngredient("Black Pepper", "Tablespoon", "1.0").validate());
		} catch (ServiceLoadException e) {
			fail();
			e.printStackTrace();
		}
	}
}
