package com.jrecipe.view.dialogs.newingredientdialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jrecipe.application.entrypoint.Main;
import com.jrecipe.model.business.manager.IngredientManager;

/**
 * Controller for the Ingredient class. 
 * 
 * @author Chris Horlick
 * @version 0.0.6
 * @since 0.0.6
 */
public class NewIngredientController implements ActionListener  {


	/** 
	 * Override and called with the action registered is performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		IngredientManager manager = IngredientManager.getInstance();
		manager.performAction("CreateIngredient", Main.state);
	}

}
