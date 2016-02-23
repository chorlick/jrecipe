package com.jrecipe.model.services.recipegroupservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.jrecipe.model.domain.Recipe;
import com.jrecipe.model.domain.RecipeGroup;
import com.jrecipe.model.services.exception.RecipeGroupException;
import com.jrecipe.model.services.exception.RecipeGroupNotFoundException;
import com.jrecipe.model.services.exception.RecipeGroupSearchFailedException;
import com.jrecipe.model.services.factory.ServiceFactory;

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
	 *  Overrides the interface object and create a new RecipeGroup.
	 * @return RecipeGroup newly created valid RecipeGroup
	 */
	public RecipeGroup createRecipeGroup(){
		RecipeGroup group = new RecipeGroup(count++,"", new ArrayList<Recipe>());
		return group;
	}

	/**
	 * Overrides and implements the search group function.
	 */
	@Override
	public RecipeGroup searchGroups(String name) throws RecipeGroupSearchFailedException {
		RecipeGroup group;
		for(int i = 0; i < count; i++ ) {
			try {
				group = loadRecipeGroup(i);
				if(group.getName().equals(name)) {
					return group;
				}
			} catch (RecipeGroupNotFoundException e) {
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
	 * @throws RecipeGroupException 
	 * @throws IOException 
	 */
	public Boolean saveRecipeGroup(RecipeGroup rg) throws RecipeGroupException  {
		Boolean ret = true;
		FileOutputStream pfile = null;
		ObjectOutputStream ofile = null;
		String fileName = new String(ServiceFactory.getInstance().getUserHome() + rg.getUid() + ".recipegroup");
		File file = new File(fileName);
		File home = new File(ServiceFactory.getInstance().getUserHome());
		if(!home.canWrite()) {
			throw new RecipeGroupException("Cannot write to directory " + fileName);
		}

		try {
			file.createNewFile();
			pfile = new FileOutputStream(fileName);
			ofile = new ObjectOutputStream(pfile);
			ofile.writeObject(rg);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
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
			}
		}
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
	public RecipeGroup loadRecipeGroup(Integer id) throws RecipeGroupNotFoundException {
		RecipeGroup rg = null;
		FileInputStream pfile = null;
		ObjectInputStream ios = null;
		String fileName = new String(ServiceFactory.getInstance().getUserHome() + id + ".recipegroup");
		File file = new File(fileName);
		
		if(!file.exists()) {
			throw new RecipeGroupNotFoundException("No RecipeGroup found matching id(" + id +")");
		}
		

		try {
			pfile = new FileInputStream(fileName);
			ios = new ObjectInputStream(pfile);
			rg  = (RecipeGroup) ios.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RecipeGroupNotFoundException("Unable to load the recipe.");
		}finally{

			try {
				if(pfile != null) {
					pfile.close();
				}
				if(ios != null) {
					ios.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
	 * @throws RecipeGroupException 
	 */
	public boolean updateRecipeGroup(RecipeGroup rg) throws RecipeGroupNotFoundException, RecipeGroupException {
		Boolean ret = true;
		String fileName = new String(rg.getUid() + ".ingredient");
		File file = new File(fileName);
		FileOutputStream pfile = null;
		ObjectOutputStream ofile = null;
		if(!file.canWrite()) {
			throw new RecipeGroupException("Cannot write to directory");
		}
		
		if(!file.exists()) {
			throw new RecipeGroupNotFoundException("RecipeGroup cant be updated. id("+rg.getUid()+")");
		}

		try {
			pfile = new FileOutputStream(fileName);
			ofile = new ObjectOutputStream(pfile);
			ofile.writeObject(rg);
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
			}				try {
				ofile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;	
	}
}