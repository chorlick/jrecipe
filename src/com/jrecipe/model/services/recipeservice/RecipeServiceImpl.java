package com.jrecipe.model.services.recipeservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;

import com.jrecipe.model.domain.Ingredient;
import com.jrecipe.model.domain.Recipe;
import com.jrecipe.model.domain.RecipeStep;
import com.jrecipe.model.services.exception.RecipeNotFoundException;

/**
 * Implementation for the RecipeService interface.
 *  
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public class RecipeServiceImpl implements IRecipeService{

	private static Integer count = 0;
	
	@Override
	public Recipe createRecipe() {
		Recipe recipe = new Recipe(count++, new String(), 
				new ArrayList<RecipeStep>(),new ArrayList<Ingredient>() );
		return recipe;
	}
	
	/**
	 * Attempts to load an Recipe from disk.
	 * 
	 * @param id Numerical id of Ingredient.
	 * @return Recipe if loaded from disk correctly. 
	 * @throws RecipeNotFoundException 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */	
	public Recipe loadRecipe(Integer id) throws RecipeNotFoundException, IOException, ClassNotFoundException {
		Recipe recipe = null;
		
		String fileName = new String(id + ".recipe");
		File file = new File(fileName);
		
		if(!file.exists()) {
			throw new RecipeNotFoundException("No Recipe found matching id(" + id +")");
		}
		
		FileInputStream pfile = new FileInputStream(fileName);
		ObjectInputStream ios = new ObjectInputStream(pfile);
		
		recipe = (Recipe) ios.readObject();
		ios.close();
		pfile.close();

		return recipe;
	}
	
	/**
	 * Deletes the Recipe with the given id
	 * from disk. 
	 * 
	 * @param id Id of the Recipe to delete. 
	 * @return Boolean true if deleted succesfully.
	 * @throws RecipeNotFoundException 
	 */
	public boolean deleteRecipe(Integer id) throws RecipeNotFoundException {
		Boolean ret = true;
		String fileName = new String(id + ".ingredient");
		File pfile = new File(fileName);
		if(!pfile.exists()) {
			throw new RecipeNotFoundException("No Recipe found matching id(" + id +")");
		}
		
		pfile.delete();
		return ret;		
	}
	
	/**
	 * Simply updates the information on the disk. 
   	 *
	 * @param recipe Recipe to update
	 * @return Boolean returns true if the RecipeGroup is updated, false if not. 
	 * @throws IOException
	 * @throws RecipeNotFoundException 
	 */
	public boolean updateRecipe(Recipe recipe) throws IOException, RecipeNotFoundException {
		Boolean ret = true;
		String fileName = new String(recipe.getUid() + ".ingredient");
		File file = new File(fileName);
		
		if(!file.canWrite()) {
			throw new AccessDeniedException("Cannot write to directory");
		}
		
		if(!file.exists()) {
			throw new RecipeNotFoundException("Recipe cant be updated. id("+recipe.getUid()+")");
		}
		
		FileOutputStream pfile = new FileOutputStream(fileName);
		ObjectOutputStream ofile = new ObjectOutputStream(pfile);
		ofile.writeObject(recipe);
		ofile.close();
		
		return ret;	
	}

}