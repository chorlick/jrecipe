package com.jrecipe.model.services.ingredientservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.AccessDeniedException;

import com.jrecipe.model.domain.Ingredient;
import com.jrecipe.model.services.exception.IngredientNotFoundException;

/**
 * Implementation used to wrap IngredientServiceInterface objects.
 *  
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public class IngredientServiceImpl implements IIngredientService {

	/* internal counter value for id */
	private static Integer count = 0;
	
	/**
	 * Function to get the working directory
	 * from the properties file
	 * 
	 * @return String working directory location
	 * @throws IOException 
	 */
	private String getUserHome() {
		String workspace = "./";
		try {
			java.util.Properties props = new java.util.Properties();
			String propertyFileLocation = System.getProperty("propertyLoc");
			java.io.FileInputStream fis;
			fis = new java.io.FileInputStream(propertyFileLocation);
			props.load(fis);
			workspace = props.getProperty("workspace");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return workspace;
	}
	
	@Override
	public Ingredient createIngredient(String name, String unit, String value) {
		Ingredient ingredient = new Ingredient(count++, name, unit, value);
		return ingredient;
	}
 	
	/**
	 * Function to save Ingredient to disk
	 * 
	 * @param in Ingredient the user wishes to save
	 * @return Boolean true if saved corectly
	 * @throws IOException 
	 */
	public Boolean saveIngredient(Ingredient in) throws IOException {
		Boolean ret = true;
		String fileName = new String(getUserHome() + in.getId() + ".ingredient");
		File file = new File(fileName);
		File home = new File(getUserHome());
		if(!home.canWrite()) {
			throw new AccessDeniedException("Cannot write to directory " + fileName);
		}
		file.createNewFile();
		FileOutputStream pfile = new FileOutputStream(fileName);
		ObjectOutputStream ofile = new ObjectOutputStream(pfile);
		ofile.writeObject(in);
		ofile.close();
		
		return ret;	
	}
	
	/**
	 * Attempts to load an Ingredient from disk.
	 * 
	 * @param id Numerical id of Ingredient.
	 * @return Ingredient if loaded from disk correctly. 
	 * @throws IngredientNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Ingredient loadIngredient(Integer id) throws IngredientNotFoundException, IOException, ClassNotFoundException {
		Ingredient in = null;
		
		String fileName = new String(id + ".ingredient");
		File file = new File(fileName);
		
		if(!file.exists()) {
			throw new IngredientNotFoundException("No ingredient found matching id(" + id +")");
		}
		
		FileInputStream pfile = new FileInputStream(fileName);
		ObjectInputStream ios = new ObjectInputStream(pfile);
		
		in = (Ingredient) ios.readObject();
		ios.close();
		return in;
	}
	
	/**
	 * Deletes the Ingredient with the given id
	 * from disk. 
	 * 
	 * @param id Id of the Ingredient to delete. 
	 * @return Boolean true if deleted succesfully.
	 * @throws IngredientNotFoundException
	 */
	public Boolean deleteIngredient(Integer id) throws IngredientNotFoundException {
		Boolean ret = true;
		String fileName = new String(id + ".ingredient");
		File pfile = new File(fileName);
		if(!pfile.exists()) {
			throw new IngredientNotFoundException("No ingredient found matching id(" + id +")");
		}
		
		pfile.delete();
		return ret;		
	}
	
	/**
	 * Simply updates the information on the disk. 
	 * 
	 * @param in Ingredient to update
	 * @return Boolean returns true if the ingredient is updated, false if not. 
	 * @throws IOException
	 * @throws IngredientNotFoundException
	 */
	public boolean updateIngredient(Ingredient in) throws IOException, IngredientNotFoundException {
		Boolean ret = true;
		String fileName = new String(in.getId() + ".ingredient");
		File file = new File(fileName);
		
		if(!file.canWrite()) {
			throw new AccessDeniedException("Cannot write to directory");
		}
		
		if(!file.exists()) {
			throw new IngredientNotFoundException("Ingredient cant be updated. id("+in.getId()+")");
		}
		
		FileOutputStream pfile = new FileOutputStream(fileName);
		ObjectOutputStream ofile = new ObjectOutputStream(pfile);
		ofile.writeObject(in);
		ofile.close();
		
		return ret;	
	}
}
