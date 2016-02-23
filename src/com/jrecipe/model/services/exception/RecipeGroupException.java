package com.jrecipe.model.services.exception;

/**
 * Thrown if the user attempts to write a recipegroup but encounters file
 * error
 * 
 * @author Chris Horlick
 * @version 0.0.6
 * @since 0.0.6
 */
public class RecipeGroupException extends Exception  {

	/**
	 * Unique value id. 
	 */
	private static final long serialVersionUID = 2912404129739352945L;	

	/**
     * Simple constructor. Just make sure to invoke the super. 
     * 
     * @param inMessage Message to user
     */
	public RecipeGroupException(String inMessage) {
		super(inMessage);
	}
}
