package com.jrecipe.model.services.recipestepservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.AccessDeniedException;

import com.jrecipe.model.domain.RecipeStep;
import com.jrecipe.model.services.exception.RecipeStepNotFoundException;

/**
 * Implementation for RecipeStepService
 *  
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public class RecipeStepServiceImpl implements IRecipeStepService {
	
	/**
	 * Attempts to load an RecipeStep from disk.
	 * 
	 * @param id Numerical id of Ingredient.
	 * @return Recipe if loaded from disk correctly. 
	 * @throws RecipeStepNotFoundException 
	 * 	 * @throws IOException
	 * @throws ClassNotFoundException
	 */	
	public RecipeStep loadRecipeStep(Integer id) throws RecipeStepNotFoundException, IOException, ClassNotFoundException {
		RecipeStep rs = null;
		
		String fileName = new String(id + ".recipestep");
		File file = new File(fileName);
		
		if(!file.exists()) {
			throw new RecipeStepNotFoundException("No RecipeStep found matching id(" + id +")");
		}
		
		FileInputStream pfile = new FileInputStream(fileName);
		ObjectInputStream ios = new ObjectInputStream(pfile);
		
		rs  = (RecipeStep) ios.readObject();
		ios.close();
		return rs;
	}
	
	/**
	 * Deletes the RecipeStep with the given id
	 * from disk. 
	 * 
	 * @param id Id of the RecipeStep to delete. 
	 * @return Boolean true if deleted succesfully.
	 * @throws RecipeStepNotFoundException  
	 */
	public boolean deleteRecipeStep(Integer id) throws RecipeStepNotFoundException {
		Boolean ret = true;
		String fileName = new String(id + ".recipestep");
		File pfile = new File(fileName);
		if(!pfile.exists()) {
			throw new RecipeStepNotFoundException("No RecipeStep found matching id(" + id +")");
		}
		
		pfile.delete();
		return ret;		
	}
	
	/**
	 * Simply updates the information on the disk. 
   	 *
	 * @param rs RecipeStep to update
	 * @return Boolean returns true if the RecipeSTep is updated, false if not. 
	 * @throws IOException
	 * @throws RecipeStepNotFoundException 
	 */
	public boolean updateRecipeStep(RecipeStep rs) throws IOException, RecipeStepNotFoundException {
		Boolean ret = true;
		String fileName = new String(rs.getUid() + ".recipestep");
		File file = new File(fileName);
		
		if(!file.canWrite()) {
			throw new AccessDeniedException("Cannot write to directory");
		}
		
		if(!file.exists()) {
			throw new RecipeStepNotFoundException("RecipeStep cant be updated. id("+rs.getUid()+")");
		}
		
		FileOutputStream pfile = new FileOutputStream(fileName);
		ObjectOutputStream ofile = new ObjectOutputStream(pfile);
		ofile.writeObject(rs);
		ofile.close();
		return ret;	
	}
	
	
}