package com.jrecipe.model.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/** 
 * Simple JUnit test class that allows the ShoppingList
 * validate and equals class to be tested per week 7
 * instructions. 
 * 
 * @author Chris Horlick
 * @version 0.0.7
 * @since 0.0.7
 */
public class ShoppingListTest {

	/**
	 * Simple function to test validatation
	 * in the ShoppingList class. 
	 */
	@Test
	public void validateShoppingList() {
		ShoppingList list = new ShoppingList();
		ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
		list.setUid(0);
		ingredientList.add(new Ingredient(0, "Basil", "Tblspn", "1.00"));
		list.setIngredients(ingredientList);
		assertTrue("Validate ShoppingList true " , list.validate());
	}
	
	/**
	 * A simple function to test that validate ShoppingList
	 * fails for a bad ShoppingList.
	 */
	@Test
	public void validateNotShoppingList() {
		
		ShoppingList list =  new ShoppingList();
		assertFalse("Validate ShoppingList false " , list.validate());
	}
	
	/**
	 * A simple tests that determines if two objects are equal.
	 */
	@Test
	public void equalsShoppingList() {
		ShoppingList list1 = new ShoppingList();
		ShoppingList list2 = new ShoppingList();
		ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
		list1.setUid(0);
		ingredientList.add(new Ingredient(0, "Basil", "Tblspn", "1.00"));
		list1.setIngredients(ingredientList);

		list2.setUid(0);
		list2.setIngredients(ingredientList);
		assertTrue("Validate ShoppingList true " , list1.equals(list2));
	}
	
	/**
	 * Simple test to verify that the equals function will comple
	 * ShoppingList correctly.
	 */
	@Test
	public void equalsNotShoppingList() {
		ShoppingList list1 = new ShoppingList();
		ShoppingList list2 = new ShoppingList();
		ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
		list1.setUid(0);
		ingredientList.add(new Ingredient(0, "Basil", "Tblspn", "1.00"));
		list1.setIngredients(ingredientList);

		list2.setUid(0);
		
		assertFalse("Validate Recipe false " , list1.equals(list2));
	}
}
