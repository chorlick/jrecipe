package com.jrecipe.model.services.recipestepservice;

import java.nio.file.AccessDeniedException;

import com.jrecipe.model.domain.RecipeStep;
import com.jrecipe.model.services.IService;
import com.jrecipe.model.services.exception.RecipeStepException;
import com.jrecipe.model.services.exception.RecipeStepNotFoundException;
import com.jrecipe.model.services.exception.RecipeStepSaveException;

/**
 * Interface used to wrap RecipeGroup objects.
 *  
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public interface IRecipeStepService extends IService {

	/**
	 * Identifier for this service. 
	 */
	public final String NAME = "IRecipeStepService";
	
	/**
	 * Function to save RecipeStep to disk
	 * 
	 * @param rs RecipeStep the user wishes to save
	 * @return Boolean true if saved corectly
	 * @throws RecipeStepSaveException 
	 */
	public Boolean saveRecipeStep(RecipeStep rs) throws RecipeStepSaveException;
	
	/**
	 * Attempts to load an RecipeStep from disk.
	 * 
	 * @param id Numerical id of Ingredient.
	 * @return Recipe if loaded from disk correctly. 
	 * @throws RecipeStepNotFoundException 
	 * @throws ClassNotFoundException
	 */	
	public RecipeStep loadRecipeStep(Integer id) throws RecipeStepNotFoundException;
	
	/**
	 * Deletes the RecipeStep with the given id
	 * from disk. 
	 * 
	 * @param id Id of the RecipeStep to delete. 
	 * @return Boolean true if deleted succesfully.
	 * @throws RecipeStepNotFoundException  
	 */
	public boolean deleteRecipeStep(Integer id) throws RecipeStepNotFoundException;
	
	/**
	 * Simply updates the information on the disk. 
   	 *
	 * @param rs RecipeStep to update
	 * @return Boolean returns true if the RecipeSTep is updated, false if not. 
	 * @throws RecipeStepNotFoundException 
	 * @throws RecipeStepException 
	 * @throws AccessDeniedException 
	 */
	public boolean updateRecipeStep(RecipeStep rs) throws RecipeStepNotFoundException, RecipeStepException ;
}