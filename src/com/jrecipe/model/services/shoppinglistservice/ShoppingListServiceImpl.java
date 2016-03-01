package com.jrecipe.model.services.shoppinglistservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.AccessDeniedException;

import com.jrecipe.model.domain.ShoppingList;
import com.jrecipe.model.services.exception.ShoppingListException;
import com.jrecipe.model.services.exception.ShoppingListNotFoundException;
import com.jrecipe.model.services.factory.ServiceFactory;

/**
 * Implementation for ShoppingListServiceImpl
 *  
 * @author Chris Horlick
 * @version 0.0.7
 * @since 0.0.7
 */
public class ShoppingListServiceImpl implements IShoppingListService{

	/**
	 * Function to save ShoppingList to disk
	 * 
	 * @param sl ShoppingList the user wishes to save
	 * @return Boolean true if saved corectly
	 * @throws ShoppingListException 
	 */
	public Boolean saveShoppingList(ShoppingList sl) throws  ShoppingListException {
		Boolean ret = true;
		FileOutputStream pfile = null;
		ObjectOutputStream ofile = null;
		String fileName = new String(ServiceFactory.getInstance().getUserHome() + sl.getUid() + ".shoppinglist");
		File file = new File(fileName);
		File home = new File(ServiceFactory.getInstance().getUserHome());
		if(!home.canWrite()) {
			throw new ShoppingListException("Cannot write to directory " + fileName);
		}

		try {
			file.createNewFile();
			pfile = new FileOutputStream(fileName);
			ofile = new ObjectOutputStream(pfile);
			ofile.writeObject(sl);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ShoppingListException("Unable to save file");
		}finally {
			if(ofile != null) {
				try {
					ofile.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new ShoppingListException("Unable to save file");
				}
			}
	
			if(pfile != null) {
				try {
					pfile.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new ShoppingListException("Unable to save file");
				}	
			}
		}
		return ret;	
	}
	
	/**
	 * Attempts to load an ShoppingList from disk.
	 * 
	 * @param id Numerical id of ShoppingList.
	 * @return ShoppingList if loaded from disk correctly. 
	 * @throws ShoppingListNotFoundException 
	 * @throws ClassNotFoundException
	 */	
	public ShoppingList loadShoppingList(Integer id) throws ShoppingListNotFoundException {
		ShoppingList sl = null;
		String fileName = new String(id + ".shoppinglist");
		File file = new File(fileName);
		ObjectInputStream ios = null;
		if(!file.exists()) {
			throw new ShoppingListNotFoundException("No ShoppingList found matching id(" + id +")");
		}
		
		FileInputStream pfile;
		try {
			pfile = new FileInputStream(fileName);
			ios = new ObjectInputStream(pfile);
			sl  = (ShoppingList) ios.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ShoppingListNotFoundException("ShoppingList was not found");
		}finally {
			try {
				if(ios != null) {
					ios.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sl;
	}
	
	/**
	 * Deletes the ShoppingList with the given id
	 * from disk. 
	 * 
	 * @param id Id of the ShoppingList to delete. 
	 * @return Boolean true if deleted succesfully.
	 * @throws ShoppingListNotFoundException  
	 */
	public boolean deleteShoppingList(Integer id) throws ShoppingListNotFoundException {
		Boolean ret = true;
		String fileName = new String(id + ".shoppinglist");
		File pfile = new File(fileName);
		if(!pfile.exists()) {
			throw new ShoppingListNotFoundException("No ShoppingList found matching id(" + id +")");
		}
		
		pfile.delete();
		return ret;		
	}
	
	/**
	 * Simply updates the information on the disk. 
   	 *
	 * @param sl ShoppingList to update
	 * @return Boolean returns true if the ShoppingList is updated, false if not. 
	 * @throws ShoppingListNotFoundException 
	 * @throws ShoppingListException 
	 * @throws AccessDeniedException 
	 */
	public boolean updateShoppingList(ShoppingList sl) throws ShoppingListNotFoundException, ShoppingListException  {
		Boolean ret = true;
		String fileName = new String(sl.getUid() + ".shoppinglist");
		File file = new File(fileName);
		FileOutputStream pfile = null;
		ObjectOutputStream ofile = null;
		if(!file.canWrite()) {
			throw new ShoppingListException("Cannot write to directory");
		}
		
		if(!file.exists()) {
			throw new ShoppingListNotFoundException("ShoppingList cant be updated. id("+sl.getUid()+")");
		}
		
		try {
			pfile = new FileOutputStream(fileName);
			ofile = new ObjectOutputStream(pfile);
			ofile.writeObject(sl);
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
