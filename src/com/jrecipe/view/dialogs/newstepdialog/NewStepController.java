package com.jrecipe.view.dialogs.newstepdialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jrecipe.application.entrypoint.Main;
import com.jrecipe.model.business.manager.JRecipeManager;

/**
 * This is the controller for the step dialog box.
 * 
 * @author Chris Horlick
 * @version 0.0.6
 * @since 0.0.6
 */
public class NewStepController implements ActionListener  {

	/** 
	 * Override and called with the action registered is performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JRecipeManager manager = JRecipeManager.getInstance();
		manager.performAction("CreateStep", Main.state);	
	}

}
