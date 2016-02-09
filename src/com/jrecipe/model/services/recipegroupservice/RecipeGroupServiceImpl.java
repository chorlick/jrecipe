package com.jrecipe.model.services.recipegroupservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;

import com.jrecipe.model.domain.Ingredient;
import com.jrecipe.model.domain.Recipe;
import com.jrecipe.model.domain.RecipeGroup;
import com.jrecipe.model.services.exception.IngredientNotFoundException;
import com.jrecipe.model.services.exception.RecipeGroupNotFoundException;
import com.jrecipe.model.services.exception.RecipeGroupSearchFailedException;

/**
 * Inteface used to wrap IngredientService objects.
 *  
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public class RecipeGroupServiceImpl implements IRecipeGroupService {
	
	/* internal count used to help create ids */
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
	
	public RecipeGroup createRecipeGroup(){
		RecipeGroup group = new RecipeGroup(count++,"", new ArrayList<Recipe>());
		return group;
	}

	@Override
	public RecipeGroup searchGroups(String name) throws RecipeGroupSearchFailedException {
		RecipeGroup group;
		for(int i = 0; i < count; i++ ) {
			try {
				group = loadRecipeGroup(i);
				if(group.getName().equals(name)) {
					return group;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (RecipeGroupNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		throw new RecipeGroupSearchFailedException("No RecipeGroup by name of : " + name);
	}

	/**
	 * Function to save RecipeGroup to disk
	 * 
	 * @param rg RecipeGroup the user wishes to save
	 * @return Boolean true if saved corectly
	 * @throws IOException 
	 */
	public Boolean saveRecipeGroup(RecipeGroup rg) throws IOException {
		Boolean ret = true;
		String fileName = new String(getUserHome() + rg.getUid() + ".recipegroup");
		File file = new File(fileName);
		File home = new File(getUserHome());
		if(!home.canWrite()) {
			throw new AccessDeniedException("Cannot write to directory " + fileName);
		}
		file.createNewFile();
		FileOutputStream pfile = new FileOutputStream(fileName);
		ObjectOutputStream ofile = new ObjectOutputStream(pfile);
		ofile.writeObject(rg);
		ofile.close();
		
		return ret;	
	}
	
	/**
	 * Attempts to load an RecipeGroup from disk.
	 * 
	 * @param id Numerical id of Ingredient.
	 * @return RecipeGroup if loaded from disk correctly. 
	 * @throws RecipeGroupNotFoundException 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */	
	public RecipeGroup loadRecipeGroup(Integer id) throws RecipeGroupNotFoundException, IOException, ClassNotFoundException {
		RecipeGroup rg = null;
		
		String fileName = new String(getUserHome() + id + ".recipegroup");
		File file = new File(fileName);
		
		if(!file.exists()) {
			throw new RecipeGroupNotFoundException("No RecipeGroup found matching id(" + id +")");
		}
		
		FileInputStream pfile = new FileInputStream(fileName);
		ObjectInputStream ios = new ObjectInputStream(pfile);
		
		rg  = (RecipeGroup) ios.readObject();
		ios.close();
		return rg;
	}
	
	/**
	 * Deletes the RecipeGroup with the given id
	 * from disk. 
	 * 
	 * @param id Id of the RecipeGroup to delete. 
	 * @return Boolean true if deleted succesfully.
	 * @throws RecipeGroupNotFoundException
	 */
	public boolean deleteRecipeGroup(Integer id) throws RecipeGroupNotFoundException {
		Boolean ret = true;
		String fileName = new String(id + ".recipegroup");
		File pfile = new File(fileName);
		if(!pfile.exists()) {
			throw new RecipeGroupNotFoundException("No recipegroup found matching id(" + id +")");
		}
		
		pfile.delete();
		return ret;		
	}

	/**
	 * Simply updates the information on the disk. 
   	 *
	 * @param rg RecipeGroup to update
	 * @return Boolean returns true if the RecipeGroup is updated, false if not. 
	 * @throws IOException
	 * @throws RecipeGroupNotFoundException
	 */
	public boolean updateRecipeGroup(RecipeGroup rg) throws IOException, RecipeGroupNotFoundException {
		Boolean ret = true;
		String fileName = new String(rg.getUid() + ".ingredient");
		File file = new File(fileName);
		
		if(!file.canWrite()) {
			throw new AccessDeniedException("Cannot write to directory");
		}
		
		if(!file.exists()) {
			throw new RecipeGroupNotFoundException("RecipeGroup cant be updated. id("+rg.getUid()+")");
		}
		
		FileOutputStream pfile = new FileOutputStream(fileName);
		ObjectOutputStream ofile = new ObjectOutputStream(pfile);
		ofile.writeObject(rg);
		ofile.close();
		
		return ret;	
	}
}