package com.jrecipe.model.services.exception;

/**
 * Thrown if the Recipe is not found. 
 * 
 * @author Chris Horlick
 * @version 0.0.4
 * @since 0.0.4
 */
public class RecipeNotFoundException extends Exception{


    /**
	 * UID for seriablizable
	 */
	private static final long serialVersionUID = -1857962941481053374L;
    
	/**
     * Simple constructor. Just make sure to invoke the super. 
     * 
     * @param inMessage Message to pass to the user
     */
    public RecipeNotFoundException(final String inMessage)
    {
        super(inMessage);
    }
}
