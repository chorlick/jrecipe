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
import com.jrecipe.model.services.factory.ServiceFactory;

/**
 * Implementation for the RecipeService interface.
 *  
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public class RecipeServiceImpl implements IRecipeService{

	private static Integer count = 0;
	
	/**
	 * Creates new recipe object. 
	 */
	@Override
	public Recipe createRecipe() {
		Recipe recipe = new Recipe(count++, new String(), 
				new ArrayList<RecipeStep>(),new ArrayList<Ingredient>() );
		return recipe;
	}
	
	/**
	 * Function to save Recipe to disk
	 * 
	 * @param recipe RecipeStep the user wishes to save
	 * @return Boolean true if saved corectly
	 * @throws RecipeNotFoundException 
	 */
	public Boolean saveRecipeStep(Recipe recipe) throws RecipeNotFoundException {
		Boolean ret = true;
		FileOutputStream pfile = null;
		ObjectOutputStream ofile = null;
		String fileName = new String(ServiceFactory.getInstance().getUserHome() + recipe.getUid() + ".recipe");
		File file = new File(fileName);
		File home = new File(ServiceFactory.getInstance().getUserHome());
		if(!home.canWrite()) {
			throw new RecipeNotFoundException("Cannot write to directory " + fileName);
		}

		try {
			file.createNewFile();
			pfile = new FileOutputStream(fileName);
			ofile = new ObjectOutputStream(pfile);
			ofile.writeObject(recipe);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RecipeNotFoundException("Cannot write to directory " + fileName);
		}finally {
			if(ofile != null) {
				try {
					ofile.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RecipeNotFoundException("Cannot write to directory " + fileName);
				}
			}
	
			if(pfile != null) {
				try {
					pfile.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RecipeNotFoundException("Cannot write to directory " + fileName);
				}	
			}
		}
		return ret;	
	}	
	
	/**
	 * Attempts to load an Recipe from disk.
	 * 
	 * @param id Numerical id of Ingredient.
	 * @return Recipe if loaded from disk correctly. 
	 * @throws RecipeNotFoundException 
	 * @throws ClassNotFoundException
	 */	
	public Recipe loadRecipe(Integer id) throws RecipeNotFoundException{
		Recipe recipe = null;
		FileInputStream pfile = null;
		ObjectInputStream ios = null;
		String fileName = new String(id + ".recipe");
		File file = new File(fileName);
		
		if(!file.exists()) {
			throw new RecipeNotFoundException("No Recipe found matching id(" + id +")");
		}
		
		try {
			pfile = new FileInputStream(fileName);
			ios = new ObjectInputStream(pfile);
			recipe = (Recipe) ios.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RecipeNotFoundException("Unable to find Recipe");
		}finally {
			if(ios != null ){
				try {
					ios.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
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
		String fileName = new String(id + ".recipe");
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
	 * @throws RecipeNotFoundException 
	 */
	public boolean updateRecipe(Recipe recipe) throws RecipeNotFoundException {
		Boolean ret = true;
		String fileName = new String(recipe.getUid() + ".recipe");
		File file = new File(fileName);
		FileOutputStream pfile = null;
		ObjectOutputStream ofile = null;
		if(!file.canWrite()) {
			throw new RecipeNotFoundException("Cannot write to directory");
		}
		
		if(!file.exists()) {
			throw new RecipeNotFoundException("Recipe cant be updated. id("+recipe.getUid()+")");
		}
		
		try {
			pfile = new FileOutputStream(fileName);
			ofile = new ObjectOutputStream(pfile);
			ofile.writeObject(recipe);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RecipeNotFoundException("Cannot write to directory");
		}finally{
			if(ofile != null) {
				try {
					ofile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(pfile != null) {
				try {
					pfile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}				try {
				ofile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
}