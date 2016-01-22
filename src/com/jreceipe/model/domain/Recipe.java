package com.jreceipe.model.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Recipe is a class that uses a number of other classes
 * in aggregate to represent an entire recipes including
 * {@link Ingredient} and {@link RecipeStep}
 * 
 * @author Chris Horlick
 * @version 0.0.1
 * @since 0.0.1
 */
public class Recipe implements Serializable {
    
    private Integer uid;
    
    private String name;
    
    private List<RecipeStep> steps;
    
    private List<Ingredient> ingredients;

	/**
	 * @return returns the id
	 */
	public Integer getUid() {
		return uid;
	}
	
    /**
     * UID setter for Ingredient
     * {@link Recipe#id}
     * 
     * @param id
     */
	public void setUid(Integer id) { 
		this.uid = id;
	}

    /**
     * Getter for ingredient description
     * 
     * @return String Description of ingredient
     */
	public String getName() {
		return name;
	}

    /**
     * Name setter for Ingredient
     * {@link Recipe#name}
     * 
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * Returns the list of {@link RecipeStep} for this {@link Recipe}
	 * 
	 * @return List<RecipeStep> list of {@link RecipeStep}
	 */
	public List<RecipeStep> getSteps() {
		return steps;
	}

	/**
	 * Setter for the steps of this recipe
	 * 
	 * @param steps List<RecipeStep> List of {@link RecipeStep} for this {@link Recipe}
	 */
	public void setSteps(List<RecipeStep> steps) {
		this.steps = steps;
	}

	
	/**
	 * 
	 * @return
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((steps == null) ? 0 : steps.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (steps == null) {
			if (other.steps != null)
				return false;
		} else if (!steps.equals(other.steps))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recipe [uid=" + uid + ", name=" + name + ", steps=" + steps + ", ingredients=" + ingredients + "]";
	}     
}




