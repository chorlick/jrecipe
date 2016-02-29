package com.jrecipe.view.usecase.one;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jrecipe.application.entrypoint.Main;
import com.jrecipe.model.business.manager.JRecipeManager;

/**
 * This class is a sipmle dialog
 * for Steps.
 * 
 * @author Chris Horlick
 * @version 0.0.6
 * @since 0.0.6
 */
public class JRecipeMainFrameController implements ActionListener  {

	/**
	 * Public interface that clients can use to call certain actions. 
	 * 
	 * @param commandString Command the client wants to issue. 
	 * @param app ApplicationState object that is used to represent the application internal state.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JRecipeManager manager = JRecipeManager.getInstance();
		manager.performAction("CreateRecipe", Main.state);
	}
}
