package com.jrecipe.model.services.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.jrecipe.model.business.exception.PropertyFileNotFoundException;

/**
 * This class provides some simple tools to help the programmer
 * develop an application internal api. This class exposes a few
 * static functions that make it a little easier to load 
 * properties from the application.properties file. Adapted from
 * homework sample tools.
 * *Note this function is taken from the homework sample code. 
 * 
 * @author Mike Prasad
 * @version 0.0.5
 * @since 0.0.5
 */
public class PropertyManager
{
	private static Properties properties = null;
 
	/**
	 * Load the properties file so its contents are available
	 * for classes in the Model tier.
	 * *Note this function is taken from the homework sample code. 
	 * 
	 * @author Mike Prasad
	 * @param propertyFileLocation
	 * @throws PropertyFileNotFoundException
	 */
	public static void loadProperties(String propertyFileLocation) throws PropertyFileNotFoundException
	{
	    properties = new Properties();
	    FileInputStream sf = null;
	    try
	    {
	      sf = new FileInputStream(propertyFileLocation);
	      properties.load(sf);
     
	      System.out.println("Property file successfully loaded from location: " + propertyFileLocation);
	      System.out.println("Property Contents: " + properties.toString());

	    }
	    catch (FileNotFoundException fnfe) 
		 {
	    	System.out.println("Property file not found.");
	    	throw new PropertyFileNotFoundException ("Property File cannot be found.");
		 }
	    catch (IOException ioe) 
	    {
	    	System.out.println("IOException while loading Properties file.");
	    	throw new PropertyFileNotFoundException ("IOException while loading Properties file.");	    	
	    }
	    catch (Exception excp) 
	    {
	    	System.out.println("Exception while loading Properties file.");
	    	throw new PropertyFileNotFoundException ("Exception while loading Properties file.");	    	
	    }
		finally
		{
			if (sf != null)
			{	
			   try {
 			    sf.close();
			   } catch (IOException e) {
				e.printStackTrace();
			   }
		    }	
		}	    
	} 

	/**
	 * This methods returns the Value for the passed key.
	 * 
	 * *Note this function is taken from the homework sample code. 
	 * @param key - key whose value needs to be returned
	 * @return String - value for the passed key
	 */
    static public String getPropertyValue (String key) {
    	return properties.getProperty(key);
    }
}
