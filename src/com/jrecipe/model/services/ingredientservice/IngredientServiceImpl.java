package com.jrecipe.model.services.ingredientservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.AccessDeniedException;

import com.jrecipe.model.domain.Ingredient;
import com.jrecipe.model.services.exception.IngredientNotFoundException;
import com.jrecipe.model.services.exception.IngredientSaveException;
import com.jrecipe.model.services.factory.ServiceFactory;

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
	 *Overrides the interface function, used to create
	 * a new Ingredient. This does NOT throw any exception. Not any.
	 */
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
	 * @throws IngredientNotFoundException 
	 * @throws IngredientSaveException 
	 */
	public Boolean saveIngredient(Ingredient in) throws IngredientNotFoundException, IngredientSaveException  {
		Boolean ret = true;
		FileOutputStream pfile = null;
		ObjectOutputStream ofile = null;
		String fileName = new String(ServiceFactory.getInstance().getUserHome() + in.getId() + ".ingredient");
		File file = new File(fileName);
		File home = new File(ServiceFactory.getInstance().getUserHome());
		if(!home.canWrite()) {
			throw new IngredientSaveException("Cannot write to directory " + fileName);
		}
		
		try {
			file.createNewFile();
			pfile = new FileOutputStream(fileName);
			ofile = new ObjectOutputStream(pfile);
			ofile.writeObject(in);
		} catch (IOException e) {
			e.printStackTrace();
			throw  new IngredientNotFoundException("Unable to write object");
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
	 * Attempts to load an Ingredient from disk.
	 * 
	 * @param id Numerical id of Ingredient.
	 * @return Ingredient if loaded from disk correctly. 
	 * @throws IngredientNotFoundException
]	 * @throws ClassNotFoundException
	 */
	public Ingredient loadIngredient(Integer id) throws IngredientNotFoundException {
		Ingredient in = null;
		String fileName = new String(id + ".ingredient");
		File file = new File(fileName);
		ObjectInputStream ios = null;
		if(!file.exists()) {
			throw new IngredientNotFoundException("No ingredient found matching id(" + id +")");
		}
		
		FileInputStream pfile;
		try {
			pfile = new FileInputStream(fileName);
			ios = new ObjectInputStream(pfile);
			in = (Ingredient) ios.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new IngredientNotFoundException("Unable to find Ingredient");
		}finally {
			if(ios != null ){
				try {
					ios.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
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
	 * @throws IngredientNotFoundException
	 * @throws AccessDeniedException 
	 */
	public boolean updateIngredient(Ingredient in) throws IngredientNotFoundException   {
		Boolean ret = true;
		String fileName = new String(in.getId() + ".ingredient");
		File file = new File(fileName);
		ObjectOutputStream ofile = null;
		FileOutputStream pfile = null;
		if(!file.canWrite()) {
			throw new IngredientNotFoundException("Cannot write to directory");
		}
		
		if(!file.exists()) {
			throw new IngredientNotFoundException("Ingredient cant be updated. id("+in.getId()+")");
		}
		
		try {
			pfile = new FileOutputStream(fileName);
			ofile = new ObjectOutputStream(pfile);
			ofile.writeObject(in);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IngredientNotFoundException("Ingredient cant be updated. id("+in.getId()+")");
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
