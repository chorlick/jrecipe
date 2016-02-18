package com.jrecipe.model.business.exception;

/**
 * Exception thrown if the applicatoin file is
 * not found.
 * 
 * @author Chris Horlick
 * @version 0.0.5
 * @since 0.0.5
 */
public class PropertyFileNotFoundException extends Exception {
	
	
	/**
	 * Unique id for exception object. 
	 */
	private static final long serialVersionUID = -4031816411120121699L;

	/**
	 * Simple function for dealing with super functions.
	 * 
	 * @param inMessage String message for the user. 
	 */
	public PropertyFileNotFoundException(final String inMessage)
    {
        super(inMessage);
    }
}
