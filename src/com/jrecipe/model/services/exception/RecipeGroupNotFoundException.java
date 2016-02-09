package com.jrecipe.model.services.exception;

/**
 * Thrown if the user attempts to add a recipe to a group that dosent
 * exist 
 * 
 * @author Chris Horlick
 * @version 0.0.4
 * @since 0.0.4
 */
public class RecipeGroupNotFoundException extends Exception {
	
    /**
	 * Unique value id. 
	 */
	private static final long serialVersionUID = 3409773341791035325L;

	/**
     * Simple constructor. Just make sure to invoke the super. 
     * 
     * @param inMessage Message to pass to the user
     */    
    public RecipeGroupNotFoundException(final String inMessage)
    {
        super(inMessage);
    }
}
