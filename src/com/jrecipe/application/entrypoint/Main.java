package com.jrecipe.application.entrypoint;

import com.jrecipe.model.domain.ApplicationState;
import com.jrecipe.view.recipedesktopview.RecipeDesktopPane;
/**
 * @author chorl_000
 *
 */
public class Main {

	/**
	 * Application state;
	 */
	public static ApplicationState state = new ApplicationState();
    /**
     * @param args
     */
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
    	RecipeDesktopPane desktop= new RecipeDesktopPane();
    	desktop.show();
	}
}
