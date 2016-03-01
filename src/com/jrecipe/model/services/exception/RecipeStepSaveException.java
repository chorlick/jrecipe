package com.jrecipe.model.services.exception;

/**
 * Thrown if the user attempts to write a RecipeStepSaveException but encounters file
 * error
 * 
 * @author Chris Horlick
 * @version 0.0.7
 * @since 0.0.7
 */
public class RecipeStepSaveException extends Exception{
	/**
	 * Unique value id. 
	 */
	private static final long serialVersionUID = -9124023739352945L;	

	/**
     * Simple constructor. Just make sure to invoke the super. 
     * 
     * @param inMessage Message to user
     */
	public RecipeStepSaveException(String inMessage) {
		super(inMessage);
	}
}
