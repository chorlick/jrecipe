package com.jrecipe.model.domain;

import java.io.Serializable;

/**
 * ShoppingItem is for the most part a wrapper class for the
 * Ingredient but it has a few small differences and holds some
 * extra information about how to display itself such as
 * has it been picked yet. 
 * 
 * @author Chris Horlick
 * @version 0.0.1
 * @since 0.0.1
 *
 */
public class ShoppingItem implements Serializable{
    
    /**
	 * private unique id for Serializable class.
	 */
	private static final long serialVersionUID = 2051113090021030768L;

	/* ingredient for this item. */
	private Ingredient ingredient;
    
	/* indicates if the item has been pick yet. */
    private Boolean picked;

	/**
	 * Set returns the ingredient for this stopping list item. 
	 * 
	 * @return Ingredient 
	 */
	public Ingredient getIngredient() {
		return ingredient;
	}

	/**
	 * Setter for shopping item ingredient. Used to set
	 * the ingredient value. 
	 * 
	 * @param ingredient
	 */
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	
	/**
	 * Returns the value of picked, a field that indicates
	 * if the user has "picked" up the item from the shopping
	 * list already. 
	 * 
	 * @return Boolean whether the item is picked or not.
	 */
	public Boolean getPicked() {
		return picked;
	}

	
	/**
	 * Sets the value of the picked field.
	 * 
	 * @param picked Boolean picked field.
	 */
	public void setPicked(Boolean picked) {
		this.picked = picked;
	}

	/** 
	 * Hashcode for class. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
		result = prime * result + ((picked == null) ? 0 : picked.hashCode());
		return result;
	}

	/** 
	 * The equals method for this object
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingItem other = (ShoppingItem) obj;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		if (picked == null) {
			if (other.picked != null)
				return false;
		} else if (!picked.equals(other.picked))
			return false;
		return true;
	}

	
	/**
	 * Used to print the object to a string format
	 */
	@Override
	public String toString() {
		return "ShoppingItem [ingredient=" + ingredient + ", picked=" + picked + "]";
	}
	
	/**
	 * Validate if the instance variables are valid
	 * 
	 * @return boolean - true if instance variables are valid, else false
	 */
	public Boolean validate() {
		if(this.getPicked() == null) return false;
		if(this.getIngredient() == null || !this.getIngredient().validate()) return false;
		return true;
	}	
}
