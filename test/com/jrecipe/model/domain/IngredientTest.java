package com.jrecipe.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * Simple JUnit test class that allows the Ingredient
 * validate and equals class to be tested per week 2
 * instructions. 
 * 
 * @author Chris Horlick
 * @version 0.0.1
 * @since 0.0.1
 */
public class IngredientTest {

	/**
	 * Simple test to test that valide function is 
	 * validating the object correctly.
	 */
	@Test
	public void validateIngredient() {
		Ingredient ingredient = new Ingredient(0, "Basil", "Tblspn", "1.00");
		assertTrue("IngredientTest valid", ingredient.validate());
	}
	
	/**
	 *  Simple test to check that validate function
	 *  successfully tests for invalid functions.
	 */
	@Test
	public void validateNotIngredient() {
		Ingredient ingredient = new Ingredient();
		assertFalse("IngredientTest invalid", ingredient.validate());
	}
	
	/**
	 * Simple test to check that the equals function works
	 * correctly.
	 */
	@Test
	public void equalsIngredient() {
		Ingredient ingredient1 = new Ingredient(0, "Basil", "Tblspn", "1.00");
		Ingredient ingredient2 = new Ingredient(0, "Basil", "Tblspn", "1.00");
		assertTrue("IngredientTest equals " , ingredient1.equals(ingredient2));
	}
	
	/**
	 * Simple test to verify that equals function successfully compares
	 * two objects. This test should fail.
	 */
	@Test
	public void equalsNotIngredient() {
		Ingredient ingredient1 = new Ingredient(0, "Basil", "Tblspn", "1.00");
		Ingredient ingredient2 = new Ingredient(0, "Basil", "Tblspn", "2.00");
		assertFalse("IngredientTest !equals " , ingredient1.equals(ingredient2));
	}
}
