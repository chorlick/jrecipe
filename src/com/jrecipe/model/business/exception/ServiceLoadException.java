package com.jrecipe.model.business.exception;

/**
 * Exception thrown if the application.properties file
 * attempts to reference an object that dosent exist. 
 * 
 * @author Chris Horlick
 * @version 0.0.4
 * @since 0.0.4
 */
@SuppressWarnings("serial")
public class ServiceLoadException extends Exception
{
    /**
     * Constructor that references the base Exception class. 
     * 
     * @param inMessage Message to user
     * @param inNestedException nested exception use to throw.
     */
    public ServiceLoadException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
	
} 