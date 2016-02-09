package com.jrecipe.model.services.factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jrecipe.model.business.exception.ServiceLoadException;
import com.jrecipe.model.services.ingredientservice.IIngredientService;
import com.jrecipe.model.services.ingredientservice.IngredientServiceImpl;
import com.jrecipe.model.services.recipegroupservice.IRecipeGroupService;
import com.jrecipe.model.services.recipeservice.IRecipeService;
import com.jrecipe.model.services.recipeservice.RecipeServiceImpl;
import com.jrecipe.model.services.recipestepservice.IRecipeStepService;

/** 
 * Simple unit to make sure that the 
 * service factory pumps out and creates the 
 * right services. 
 * 
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public class ServiceFactoryTest {

	/* our class reference to the singleton object */
	ServiceFactory serviceFactory;
		
	/**
	 * Simple setup for the service factory. 
	 * This is run before each test. 
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		serviceFactory = ServiceFactory.getInstance();		
	}

    /**
     * Test Factory to return the ingredientservice and assert it by 
     * checking it is an instance of IngredientServiceImpl
     * 
     * This should be true since IngredientServiceImpl implements IIngredientService
     */
	@Test	
	public void testGetIngredientService() {
 		IIngredientService ingredientService;
		try {
			ingredientService = (IIngredientService)serviceFactory.getService("IngredientService");
	  	    assertTrue(ingredientService instanceof IngredientServiceImpl);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /**
     * Test Factory to return the recipeGroupService and assert it by 
     * checking it is an instance of RecipeServiceImpl
     * 
     * This should be true since RecipeServiceImpl implements IRecipeGroupService
     */
	@Test	
	public void testGetRecipeGroupService() {
 		IRecipeGroupService service;
		try {
			service = (IRecipeGroupService)serviceFactory.getService("RecipeGroupService");
	  	    assertTrue(service instanceof IRecipeGroupService);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /**
     * Test Factory to return the recipeSerivce and assert it by 
     * checking it is an instance of RecipeServiceImpl
     * 
     * This should be true since RecipeServiceImpl implements IRecipeService
     */
	@Test	
	public void testGetRecipeService() {
 	    
  	    IRecipeService service;
		try {
			service = (IRecipeService)serviceFactory.getService("RecipeService");
	  	    assertTrue(service instanceof RecipeServiceImpl);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    /**
     * Test Factory to return the recipeStepService and assert it by 
     * checking it is an instance of RecipeStepServiceImpl
     * 
     * This should be true since RecipeStepServiceImpl implements IRecipeService
     */
	@Test	
	public void testGetRecipeStepService() {
 		IRecipeStepService service;
		try {
			service = (IRecipeStepService)serviceFactory.getService("RecipeStepService");
	  	    assertTrue(service instanceof IRecipeStepService);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
