package com.jrecipe.model.services.exception;

/** 
 * This exception is thrown when an Ingredient is 
 * attempted to be loaded from the file system but
 * it isnt found.  
 * 
 * @author Chris Horlick
 * @version 0.0.4
 * @since 0.0.4
 */
public class IngredientNotFoundException extends Exception {

	/**
	 * Unique value id. 
	 */
	private static final long serialVersionUID = 2912404129739352945L;	

	/**
     * Simple constructor. Just make sure to invoke the super. 
     * 
     * @param inMessage Message to user
     */
	public IngredientNotFoundException(String inMessage) {
		super(inMessage);
	}

}
