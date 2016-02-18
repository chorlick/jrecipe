package com.jrecipe.model.domain;

import java.io.Serializable;
import java.util.List;
import com.jrecipe.model.domain.Recipe;

/**
 * ReceipeGroup is an object that allows {@link Recipe} to be 
 * grouped into groups of recipes. An example might be Soups, Stocks
 * Breads, etc. 
 * 
 * @author Chris Horlick
 * @version 0.0.1
 * @since 0.0.1
 */
public class RecipeGroup implements Serializable {
    
    /**
	 * private unique id for Serializable class.
	 */
	private static final long serialVersionUID = -6939736342916890127L;

	/* uid of the object */
	private Integer uid;
    
	/* display text for this object */
    private String name;
    
	/* list of recipes thta belong to this group*/
    private List<Recipe> recipes;
    
    /**
     * Public null argument constructor.
     */
    public RecipeGroup() { }
    
    
    /**
     * Public constructor that takes all of the 
     * class fields as arguments. 
     * 
     * @param uid This value is the unique id of the Group
     * @param name The textual description of the group.
     * @param recipes The List of {@link Recipe} that belongs to this group
     */
    public RecipeGroup(Integer uid, String name, List<Recipe> recipes) {
        this.uid = uid;
        this.name = name;
        this.recipes = recipes;
    }
    
    /**
     * 
     * @return Returns unique Integer identifier for this instance.
     */
    public Integer getUid() { return this.uid; }
    
    /**
     * Sets the unique Integer identifier for this object.
     * 
     * @param uid {@link RecipeGroup#uid}
     */
    public void setUid(Integer uid ) { this.uid = uid; }
    
    /**
     * @return Returns the String text representation for this RecipeGroup
     */
    public String getName() { return this.name; }
    
    /**
     * Set the textual representation for this recipegroup
     * 
     * @param name {@link RecipeGroup#name}
     */
    public void setName(String name) {this.name = name;}
    
    /**
     * @return List of {@link Recipe} that belong to this group.
     */
    public List<Recipe> getRecipes() { return this.recipes; }
    
    
    /**
     * Sets the List of recipes for this group.
     * 
     * @param recipes {@link RecipeGroup#recipes}
     */
    public void setRecipes(List<Recipe> recipes)  { this.recipes = recipes; }

	/**
	 * Hashcode for class. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((recipes == null) ? 0 : recipes.hashCode());
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
		RecipeGroup other = (RecipeGroup) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recipes == null) {
			if (other.recipes != null)
				return false;
		} else if (!recipes.equals(other.recipes))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	/**
	 *  Used to print the object to a string format
	 */
	@Override
	public String toString() {
		return "RecipeGroup [uid=" + uid + ", name=" + name + ", recipes=" + recipes + "]";
	}

	/**
	 * Validate if the instance variables are valid
	 * 
	 * @return boolean - true if instance variables are valid, else false
	 */
	public Boolean validate() {
		if(this.getUid() == null || this.getUid() < 0) return  false;
		if(this.getName().length() == 0) return false;
		if(this.getRecipes() == null ) return false;
		return true;
			
	}
}