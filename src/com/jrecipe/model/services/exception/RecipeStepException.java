package com.jrecipe.model.services.exception;

/**
 * Thrown if the user attempts to write a RecipeStep but encounters file
 * error
 * 
 * @author Chris Horlick
 * @version 0.0.6
 * @since 0.0.6
 */
public class RecipeStepException extends Exception  {

	/**
	 * Unique value id. 
	 */
	private static final long serialVersionUID = 29124023739352945L;	

	/**
     * Simple constructor. Just make sure to invoke the super. 
     * 
     * @param inMessage Message to user
     */
	public RecipeStepException(String inMessage) {
		super(inMessage);
	}
}