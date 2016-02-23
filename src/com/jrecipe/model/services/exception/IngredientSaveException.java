package com.jrecipe.model.services.exception;

/**
 * Thrown if the user attempts to write an ingredient but encounters file
 * error
 * 
 * @author Chris Horlick
 * @version 0.0.4
 * @since 0.0.4
 */
public class IngredientSaveException extends Exception {
	
    /**
	 * Unique value id. 
	 */
	private static final long serialVersionUID = 3409773341791035325L;

	/**
     * Simple constructor. Just make sure to invoke the super. 
     * 
     * @param inMessage Message to pass to the user
     */    
    public IngredientSaveException(final String inMessage)
    {
        super(inMessage);
    }
}