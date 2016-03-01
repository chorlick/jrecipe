package com.jrecipe.model.services.recipegroupservice;

import java.io.IOException;

import com.jrecipe.model.domain.RecipeGroup;
import com.jrecipe.model.services.IService;
import com.jrecipe.model.services.exception.RecipeGroupException;
import com.jrecipe.model.services.exception.RecipeGroupNotFoundException;
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
	 * Identifier for this service. 
	 */
	public final String NAME = "IRecipeGroupService";
	
	/**
	 * Creates recipegroup
	 * @return Valide recipe group
	 *  *Note this does NOT throw any exception. Not any on purpose. there are no exceptions thrown here.
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
	
	/**
	 * Function to save RecipeGroup to disk
	 * 
	 * @param in RecipeGroup the user wishes to save
	 * @return Boolean true if saved corectly
	 * @throws RecipeGroupException 
	 */
	public Boolean saveRecipeGroup(RecipeGroup in) throws RecipeGroupException;
	
	/**
	 * Attempts to load an RecipeGroup from disk.
	 * 
	 * @param id Numerical id of RecipeGroup.
	 * @return RecipeGroup if loaded from disk correctly. 
	 * @throws RecipeGroupNotFoundException
	 * @throws ClassNotFoundException
	 */
	public RecipeGroup loadRecipeGroup(Integer id) throws RecipeGroupNotFoundException;
	
	/**
	 * Deletes the RecipeGroup with the given id
	 * from disk. 
	 * 
	 * @param id Id of the RecipeGroup to delete. 
	 * @return Boolean true if deleted succesfully.
	 * @throws RecipeGroupNotFoundException
	 */
	public boolean deleteRecipeGroup(Integer id) throws RecipeGroupNotFoundException;
	
	/**
	 * Simply updates the information on the disk. 
	 * @param rg 
	 * 
	 * @param in RecipeGroup to update
	 * @return Boolean returns true if the RecipeGroup is updated, false if not. 
	 * @throws RecipeGroupNotFoundException
	 * @throws RecipeGroupException 
	 */
	public boolean updateRecipeGroup(RecipeGroup rg) throws RecipeGroupNotFoundException, RecipeGroupException;
}