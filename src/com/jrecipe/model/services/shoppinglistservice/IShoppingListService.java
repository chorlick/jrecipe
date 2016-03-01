package com.jrecipe.model.services.shoppinglistservice;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import com.jrecipe.model.domain.ShoppingList;
import com.jrecipe.model.services.IService;
import com.jrecipe.model.services.exception.ShoppingListException;
import com.jrecipe.model.services.exception.ShoppingListNotFoundException;

/**
 * Interface used to wrap ShoppingList objects.
 *  
 * @author Chris Horlick
 * @version 0.0.7
 * @since 0.0.7
 */
public interface IShoppingListService extends IService {
	
	/**
	 * Identifier for this service. 
	 */
	public final String NAME = "IShoppingListService";
	
	/**
	 * Function to save ShoppingList to disk
	 * 
	 * @param sl ShoppingList the user wishes to save
	 * @return Boolean true if saved corectly
	 * @throws ShoppingListException 
	 */
	public Boolean saveShoppingList(ShoppingList sl) throws  ShoppingListException;
	
	/**
	 * Attempts to load an ShoppingList from disk.
	 * 
	 * @param id Numerical id of ShoppingList.
	 * @return ShoppingList if loaded from disk correctly. 
	 * @throws ShoppingListNotFoundException 
	 * @throws ClassNotFoundException
	 */	
	public ShoppingList loadShoppingList(Integer id) throws ShoppingListNotFoundException ;
	
	/**
	 * Deletes the ShoppingList with the given id
	 * from disk. 
	 * 
	 * @param id Id of the ShoppingList to delete. 
	 * @return Boolean true if deleted succesfully.
	 * @throws ShoppingListNotFoundException  
	 */
	public boolean deleteShoppingList(Integer id) throws ShoppingListNotFoundException;	

	/**
	 * Simply updates the information on the disk. 
   	 *
	 * @param sl ShoppingList to update
	 * @return Boolean returns true if the ShoppingList is updated, false if not. 
	 * @throws ShoppingListNotFoundException 
	 * @throws ShoppingListException 
	 * @throws AccessDeniedException 
	 */
	public boolean updateShoppingList(ShoppingList sl) throws ShoppingListNotFoundException, ShoppingListException;  
}
