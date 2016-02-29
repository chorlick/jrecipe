package com.jrecipe.model.services.exception;

/**
 * Thrown if the ShoppingList is not found. 
 * 
 * @author Chris Horlick
 * @version 0.0.7
 * @since 0.0.7
 */
public class ShoppingListNotFoundException extends Exception {
	   /**
		 * UID for serializable
		 */
		private static final long serialVersionUID = 3904212315120979L;
	    
		/**
	     * Simple constructor. Just make sure to invoke the super. 
	     * 
	     * @param inMessage Message to pass to the user
	     */
	    public ShoppingListNotFoundException(final String inMessage)
	    {
	        super(inMessage);
	    }
}
