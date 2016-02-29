package com.jrecipe.model.domain;

import java.io.Serializable;
import java.util.List;

/**
 * ShoppingList is an object that represents the shopping list
 * of the user. Essentially its a list of ingredients that
 * does not belong to a {@link Recipe}
 * 
 * @author Chris Horlick
 * @version 0.0.1
 * @since 0.0.1
 */
public class ShoppingList implements Serializable {
	
    /**
	 * private unique id for Serializable class.
	 */
	private static final long serialVersionUID = 3307237536696728304L;
	
	/* unique id of the object */
	private Integer uid;
	
	/* list of ingredients in shopping list*/
	private List<Ingredient> ingredients;

	/**
	 * Returns the private id of the object.
	 * 
	 * @return Integer Id of object.
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * Sets the value of the id. 
	 * 
	 * @param uid Integer {@link RecipeStep#uid}
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	/**
	 * Returns the List of ingredients currently in the 
	 * shopping list. 
	 * 
	 * @return List<Ingredient> list of ingredients for shopping. 
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * Sets the list of ingredients for the ShoppingList
	 * 
	 * @param ingredients List<Ingredient> list of ingredients. 
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * Hash code for the shopping list object. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		return result;
	}

	/**
	 * Used to evaulate equality of an object. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingList other = (ShoppingList) obj;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		return true;
	}

	/**
	 * Prints the object to a string. 
	 */
	@Override
	public String toString() {
		return "ShoppingList [ingredients=" + ingredients + "]";
	}
	
	/**
	 * Validate if the instance variables are valid
	 * 
	 * @return boolean - true if instance variables are valid, else false
	 */
	public Boolean validate() {
		if(this.getIngredients()== null) return false;
		return true;
	}
}