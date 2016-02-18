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
import com.jrecipe.model.services.factory.ServiceFactory;

/**
 * Implementation for RecipeStepService
 *  
 * @author Chris Horlick
 * @version 0.0.2
 * @since 0.0.2
 */
public class RecipeStepServiceImpl implements IRecipeStepService {
	
	/**
	 * Function to save RecipeStep to disk
	 * 
	 * @param rs RecipeStep the user wishes to save
	 * @return Boolean true if saved corectly
	 * @throws IOException 
	 */
	public Boolean saveRecipeStep(RecipeStep rs) throws IOException {
		Boolean ret = true;
		FileOutputStream pfile = null;
		ObjectOutputStream ofile = null;
		String fileName = new String(ServiceFactory.getInstance().getUserHome() + rs.getUid() + ".recipestep");
		File file = new File(fileName);
		File home = new File(ServiceFactory.getInstance().getUserHome());
		if(!home.canWrite()) {
			throw new AccessDeniedException("Cannot write to directory " + fileName);
		}

		try {
			file.createNewFile();
			pfile = new FileOutputStream(fileName);
			ofile = new ObjectOutputStream(pfile);
			ofile.writeObject(rs);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(ofile != null) {
				ofile.close();
			}
	
			if(pfile != null) {
				pfile.close();	
			}
		}
		return ret;	
	}
	
	/**
	 * Attempts to load an RecipeStep from disk.
	 * 
	 * @param id Numerical id of Ingredient.
	 * @return Recipe if loaded from disk correctly. 
	 * @throws RecipeStepNotFoundException 
	 * 	 * @throws IOException
	 * @throws ClassNotFoundException
	 */	
	public RecipeStep loadRecipeStep(Integer id) throws RecipeStepNotFoundException {
		RecipeStep rs = null;
		String fileName = new String(id + ".recipestep");
		File file = new File(fileName);
		ObjectInputStream ios = null;
		if(!file.exists()) {
			throw new RecipeStepNotFoundException("No RecipeStep found matching id(" + id +")");
		}
		
		FileInputStream pfile;
		try {
			pfile = new FileInputStream(fileName);
			ios = new ObjectInputStream(pfile);
			rs  = (RecipeStep) ios.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RecipeStepNotFoundException("RecipeStep was not found");
		}finally {
			try {
				if(ios != null) {
					ios.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
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
	 * @throws AccessDeniedException 
	 */
	public boolean updateRecipeStep(RecipeStep rs) throws RecipeStepNotFoundException, AccessDeniedException {
		Boolean ret = true;
		String fileName = new String(rs.getUid() + ".recipestep");
		File file = new File(fileName);
		FileOutputStream pfile = null;
		ObjectOutputStream ofile = null;
		if(!file.canWrite()) {
			throw new AccessDeniedException("Cannot write to directory");
		}
		
		if(!file.exists()) {
			throw new RecipeStepNotFoundException("RecipeStep cant be updated. id("+rs.getUid()+")");
		}
		
		try {
			pfile = new FileOutputStream(fileName);
			ofile = new ObjectOutputStream(pfile);
			ofile.writeObject(rs);
		} catch (IOException e) {
			e.printStackTrace();
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
			}try {
				ofile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return ret;	
	}
}