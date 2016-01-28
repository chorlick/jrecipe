package com.jrecipe.model.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/** 
 * Simple JUnit test class that allows the Recipe
 * validate and equals class to be tested per week 2
 * instructions. 
 * 
 * @author Chris Horlick
 * @version 0.0.1
 * @since 0.0.1
 */
public class RecipeTest {

	/**
	 * Simple function to test validatation
	 * in the Recipe class. 
	 */
	@Test
	public void validateRecipe() {
		
		List<RecipeStep> steps = new ArrayList<RecipeStep>();
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		Recipe recipe =  new Recipe(0, "Baked Chicken", steps, ingredients);
		assertTrue("Validate Recipe true " , recipe.validate());
	}
	
	/**
	 * A simple function to test that valide recipe
	 * fails for a bad recipe.
	 */
	@Test
	public void validateNotRecipe() {
		
		Recipe recipe =  new Recipe();
		assertFalse("Validate Recipe false " , recipe.validate());
	}
	
	/**
	 * A simple tests that determines if two objects are equal.
	 */
	@Test
	public void equalsRecipe() {
		List<RecipeStep> steps = new ArrayList<RecipeStep>();
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		Recipe recipe1 =  new Recipe(0, "Baked Chicken", steps, ingredients);
		Recipe recipe2 =  new Recipe(0, "Baked Chicken", steps, ingredients);

		assertTrue("Validate Recipe true " , recipe1.equals(recipe2));
	}
	
	/**
	 * Simple test to verify that the equals function will comple
	 * recipes correctly.
	 */
	@Test
	public void equalsNotRecipe() {
		List<RecipeStep> steps = new ArrayList<RecipeStep>();
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		Recipe recipe1 =  new Recipe(0, "Baked Chicken", steps, ingredients);
		Recipe recipe2 =  new Recipe(0, "", steps, ingredients);

		assertFalse("Validate Recipe false " , recipe1.equals(recipe2));
	}
}
