package com.jrecipe.model.services.recipeservice;

import com.jrecipe.model.domain.Recipe;
import com.jrecipe.model.services.IService;
import com.jrecipe.model.services.exception.RecipeNotFoundException;

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
	 * Note this does NOT throw any exception. Not any on purpose. there are no exceptions thrown here.
	 */
	public Recipe createRecipe();
	
	/**
	 * Function to save Recipe to disk
	 * 
	 * @param recipe RecipeStep the user wishes to save
	 * @return Boolean true if saved corectly
	 * @throws RecipeNotFoundException 
	 */
	public Boolean saveRecipeStep(Recipe recipe) throws RecipeNotFoundException;
	
	/**
	 * Attempts to load an Recipe from disk.
	 * 
	 * @param id Numerical id of Ingredient.
	 * @return Recipe if loaded from disk correctly. 
	 * @throws RecipeNotFoundException 
	 * @throws ClassNotFoundException
	 */	
	public Recipe loadRecipe(Integer id) throws RecipeNotFoundException;
	
	/**
	 * Deletes the Recipe with the given id
	 * from disk. 
	 * 
	 * @param id Id of the Recipe to delete. 
	 * @return Boolean true if deleted succesfully.
	 * @throws RecipeNotFoundException 
	 */
	public boolean deleteRecipe(Integer id) throws RecipeNotFoundException;
	
	/**
	 * Simply updates the information on the disk. 
   	 *
	 * @param recipe Recipe to update
	 * @return Boolean returns true if the RecipeGroup is updated, false if not. 
	 * @throws RecipeNotFoundException 
	 */
	public boolean updateRecipe(Recipe recipe) throws RecipeNotFoundException ;
}