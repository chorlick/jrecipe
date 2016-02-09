package com.jrecipe.model.services.recipegroupservice;

import com.jrecipe.model.domain.Recipe;
import com.jrecipe.model.domain.RecipeGroup;
import com.jrecipe.model.services.IService;
import com.jrecipe.model.services.exception.RecipeGroupSearchFailedException;

/**
 * Interface used to wrap RecipeGroup objects.
 *  
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public interface IRecipeGroupService extends IService {
	
	/**
	 * Creates recipegroup
	 * @return Valide recipe group
	 * 
	 */
	public RecipeGroup createRecipeGroup();
	
	
	/**
	 * Used to find the recipe group that you are missing returns the
	 * group on match. 
	 * 
	 * @return RecipeGroup that matches search
	 * @param name String of group you are searching for. 
	 * @param insensitive Boolean case insensitive search or not. 
	 * @throws RecipeGroupSearchFailedException 
	 */
	public RecipeGroup searchGroups(String name) throws RecipeGroupSearchFailedException;
}