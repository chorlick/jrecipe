package com.jrecipe.model.services.recipeservice;

import org.junit.Before;
import org.junit.Test;

import com.jrecipe.model.business.exception.ServiceLoadException;
import com.jrecipe.model.domain.Recipe;
import com.jrecipe.model.services.factory.ServiceFactory;
import junit.framework.TestCase;

/** 
 *	Small unit test to make sure that recipeserviceimpl
 *  class behaves.	
 * 
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public class RecipeServiceImplTest extends TestCase{
	ServiceFactory serviceFactory;
	
	@Before
	public void setUp() throws Exception {
		serviceFactory = ServiceFactory.getInstance();		
	}
	
	/**
	 * TEsts that the recipe reteunred from the service is the correct type
	 * and valid.
	 */
	@Test
	public void testCreateRecipe() {
		RecipeServiceImpl service;
		try {
			service = (RecipeServiceImpl) serviceFactory.getService("RecipeService");
			assertTrue(service.createRecipe() instanceof Recipe);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
