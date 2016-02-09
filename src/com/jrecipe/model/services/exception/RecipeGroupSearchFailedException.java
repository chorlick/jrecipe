package com.jrecipe.model.services.exception;

/**
 * Thrown if the RecipeGroupo a user is searching for
 * is not found.  
 * 
 * @author Chris Horlick
 * @version 0.0.4
 * @since 0.0.4
 */
public class RecipeGroupSearchFailedException extends Exception{

	/**
	 * Generated id for Serializable
	 */
	private static final long serialVersionUID = -2072112529950222625L;

	/**
     * Simple constructor. Just make sure to invoke the super. 
     * 
     * @param inMessage Message to pass to the user
     */    
    public RecipeGroupSearchFailedException(final String inMessage)
    {
        super(inMessage);
    }
}
