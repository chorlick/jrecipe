package com.jrecipe.model.services.ingredientservice;

import com.jrecipe.model.domain.Ingredient;
import com.jrecipe.model.services.IService;

/**
 * Inteface used to wrap IngredientService objects.
 *  
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public interface IIngredientService extends IService {
	
	/**
	 * This function creates a valid ingredient object. 
	 * @param name Name of the ingreident.
	 * @param unit Units of the ingredient.
	 * @param value Amount of ingredient
	 * 
	 * @return valide empty ingredient object. 
	 */
	public Ingredient createIngredient(String name, String unit, String value);
	
	
}
