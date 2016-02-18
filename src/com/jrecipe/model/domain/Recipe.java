package com.jrecipe.model.domain;

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
    
    /**
	 * private unique id for Serializable class.
	 */
	private static final long serialVersionUID = 5054293137257852541L;

	/* unique id of this object */
	private Integer uid;
    
	/* display text for this object */
	private String name;
    
	/* list of steps in the recipe */
    private List<RecipeStep> steps;
    
    /* list of ingredients in the recipe */
    private List<Ingredient> ingredients;

    /**
     * Public void constructor.
     */
    public Recipe() {
    	
    }
    
    /**
     * Public constructor that accepts a set of arguments for fields.
     * 
     * @param id 
     * @param name
     * @param steps
     * @param ingredients
     */
    public Recipe(Integer id, 
    		String name, 
    		List<RecipeStep> steps, 
    		List<Ingredient> ingredients){
    	this.uid = id;
    	this.name = name;
    	this.steps = steps;
    	this.ingredients = ingredients;
    }
    
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
	 * Returns list of {@link Ingredient} for this {@link Recipe}
	 * 
	 * @return List<Ingredient> list of {@link Ingredient}
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	
	/**
	 * Setter for the ingredients of the recipe
	 * 
	 * @param ingredients List<Ingredient> list of {@link Ingredient}
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/** 
	 * Hashcode for class. 
	 */
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

	/**
	 * Used to print the object to a string format
	 * 
	 */
	@Override
	public String toString() {
		return "Recipe [uid=" + uid + ", name=" + name + ", steps=" + steps + ", ingredients=" + ingredients + "]";
	}
	
	/**
	 * Validate if the instance variables are valid
	 * 
	 * @return boolean - true if instance variables are valid, else false
	 */
	public Boolean validate() {
		if(this.getUid() == null || this.getUid() < 0) return  false;
		if(this.getName()== null) return false;
		if(this.getIngredients() == null ) return false;
		if(this.getSteps() == null ) return false;
		return true;
			
	}
}




