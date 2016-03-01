package com.jrecipe.model.services.factory;

import java.io.IOException;

import com.jrecipe.model.business.exception.ServiceLoadException;
import com.jrecipe.model.services.IService;
import com.jrecipe.model.services.manager.PropertyManager;

/**
 * Basic service factory use to instaitate 
 * a variety of services in the application. 
 * 
 * Now loads from a file.
 * 
 * @author Chris Horlick
 * @version 0.0.4
 * @since 0.0.4
 */
public class ServiceFactory {

	/* want to keep this private so we can use a Singleton pattern */
	private ServiceFactory() {
	}

	/* The instance of the single ton */
	private static ServiceFactory serviceFactory = new ServiceFactory();

	
	/**
	 * This is our handle to the Singleton object
	 * @return Active Singleton instance
	 */
	public static ServiceFactory getInstance() {
		return serviceFactory;
	}
	
	/**
	 * Function that returns the service object. 
	 * 
	 * @param serviceName Service name you wish to request
	 * @return Exception IService The instance of the service.
	 * @throws ServiceLoadException In case the request service dosent exist. 
	 */
	public IService getService(String serviceName) throws ServiceLoadException {
		try {
			String implName = getImplName(serviceName);
			Class<?> c = Class.forName(implName);
			return (IService) c.newInstance();
		} catch (Exception excp) {
			serviceName = serviceName + " not loaded\n";
			throw new ServiceLoadException(serviceName, excp);
		}
	}
	
	/**
	 * Returns the value of a given key for a service name 
	 * from the application.properties 
	 * *Note updated from the week 5 homework example.
	 * 
	 * @param serviceName The name of the key
	 * @return Returns the value from the key
	 * @throws Exception Exception on file io issues
	 */
	private String getImplName (String serviceName)
	{
		return PropertyManager.getPropertyValue(serviceName);
	}
	
	/**
	 * Function to get the working directory
	 * from the properties file. 
	 * Modified to make this funciton return from the propmanager. 
	 * 
	 * @return String working directory location
	 */
	public String getUserHome() {
		String workspace = "./";
		workspace = getImplName("workspace");
		return workspace;
	}
}
