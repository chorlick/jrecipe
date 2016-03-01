package com.jrecipe.model.services.ingredientservice;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import com.jrecipe.model.domain.Ingredient;
import com.jrecipe.model.services.IService;
import com.jrecipe.model.services.exception.IngredientNotFoundException;
import com.jrecipe.model.services.exception.IngredientSaveException;

/**
 * Inteface used to wrap IngredientService objects.
 *  
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public interface IIngredientService extends IService {
	
	/**
	 * Identifier for this service. 
	 */
	public final String NAME = "IIngredientService";
	
	/**
	 * This function creates a valid ingredient object. 
	 * @param name Name of the ingreident.
	 * @param unit Units of the ingredient.
	 * @param value Amount of ingredient
	 * 
	 * @return valide empty ingredient object. 
	 * Note this does NOT throw any exception. Not any on purpose. there are no exceptions thrown here.
	 */
	public Ingredient createIngredient(String name, String unit, String value);
	
	
	/**
	 * Function to save Ingredient to disk
	 * 
	 * @param in Ingredient the user wishes to save
	 * @return Boolean true if saved corectly
	 * @throws IngredientNotFoundException 
	 * @throws IngredientSaveException 
	 */
	public Boolean saveIngredient(Ingredient in) throws IngredientNotFoundException, IngredientSaveException;
	
	/**
	 * Attempts to load an Ingredient from disk.
	 * 
	 * @param id Numerical id of Ingredient.
	 * @return Ingredient if loaded from disk correctly. 
	 * @throws IngredientNotFoundException
	 * @throws ClassNotFoundException
	 */
	public Ingredient loadIngredient(Integer id) throws IngredientNotFoundException;
	
	/**
	 * Deletes the Ingredient with the given id
	 * from disk. 
	 * 
	 * @param id Id of the Ingredient to delete. 
	 * @return Boolean true if deleted succesfully.
	 * @throws IngredientNotFoundException
	 */
	public Boolean deleteIngredient(Integer id) throws IngredientNotFoundException;
	
	/**
	 * Simply updates the information on the disk. 
	 * 
	 * @param in Ingredient to update
	 * @return Boolean returns true if the ingredient is updated, false if not. 
	 * @throws IngredientNotFoundException
	 * @throws AccessDeniedException 
	 */
	public boolean updateIngredient(Ingredient in) throws IngredientNotFoundException ;
}
