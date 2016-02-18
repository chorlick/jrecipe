package com.jrecipe.model.services.recipeservice;

import com.jrecipe.model.domain.Recipe;
import com.jrecipe.model.services.IService;

/**
 * Interface used to wrap IRecipeGroupService objects.
 *  
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public interface IRecipeService extends IService{

	/**
	 * Identifier for this service. 
	 */
	public final String NAME = "RecipeService";

	
	/**
	 * Create new valid Recipe object.
	 * @return Recipe object
	 */
	public Recipe createRecipe();
}