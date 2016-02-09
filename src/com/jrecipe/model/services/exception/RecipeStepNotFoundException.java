package com.jrecipe.model.services.exception;

/**
 * Thrown if the RecipeStep is not found. 
 * 
 * @author Chris Horlick
 * @version 0.0.4
 * @since 0.0.4
 */
public class RecipeStepNotFoundException extends Exception {
	
    /**
	 * UID for serializable
	 */
	private static final long serialVersionUID = 3904295151495120979L;
    
	/**
     * Simple constructor. Just make sure to invoke the super. 
     * 
     * @param inMessage Message to pass to the user
     */
    public RecipeStepNotFoundException(final String inMessage)
    {
        super(inMessage);
    }
}
