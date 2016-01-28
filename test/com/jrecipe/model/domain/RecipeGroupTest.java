package com.jrecipe.model.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Recipe is a class that uses a number of other classes
 * in aggregate to represent an entire recipes including
 * {@link Ingredient} and {@link RecipeStep}
 * 
 * @author Chris Horlick
 * @version 0.0.1
 * @since 0.0.1
 */
public class RecipeGroupTest {

	
	/**
	 * Simple test to validate recipe group.
	 */
	@Test
	public void vaildateRecipeGroup() {
		Recipe recipe = new Recipe();
		List<Recipe> recipes = new ArrayList<Recipe>();
		recipes.add(recipe);
		
		RecipeGroup group = new RecipeGroup(0, "Dinner Meals", recipes);
		assertTrue("RecipeGroup validate true", group.validate());
	}
	
	/**
	 * Simple test to validate recipe group, this test
	 * should fail.
	 */
	@Test
	public void vaildateNotRecipeGroup() {
		Recipe recipe = new Recipe();
		List<Recipe> recipes = new ArrayList<Recipe>();
		recipes.add(recipe);
		
		RecipeGroup group = new RecipeGroup(0, "Dinner Meals", null);
		assertFalse("RecipeGroup validate false", group.validate());
	}
	
	/**
	 * Simple test to check for equality testing in 
	 * RecipeGroup function.
	 */
	@Test
	public void equalsRecipeGroup() {
		Recipe recipe = new Recipe();
		List<Recipe> recipes = new ArrayList<Recipe>();
		recipes.add(recipe);
		
		RecipeGroup group1 = new RecipeGroup(0, "Dinner Meals", recipes);
		RecipeGroup group2 = new RecipeGroup(0, "Dinner Meals", recipes);
		assertTrue("RecipeGroup equals true", group1.equals(group2));
	}

	/**
	 * Simple test to check for inequality testing in 
	 * RecipeGroup function.
	 */
	@Test
	public void equalsNotRecipeGroup() {
		Recipe recipe = new Recipe();
		List<Recipe> recipes = new ArrayList<Recipe>();
		recipes.add(recipe);
		
		RecipeGroup group1 = new RecipeGroup(0, "Dinner Meals", recipes);
		RecipeGroup group2 = new RecipeGroup(0, "Breakfast", recipes);
		assertFalse("RecipeGroup equals false", group1.equals(group2));
	}
}
