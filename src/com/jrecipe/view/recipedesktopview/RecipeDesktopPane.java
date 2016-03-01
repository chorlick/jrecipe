package com.jrecipe.view.recipedesktopview;

import com.jrecipe.view.usecase.one.JRecipeMainFrame;
import com.jrecipe.view.usecase.two.ShoppingListMainFrame;

/**
 * Main desktop MDI object for the application. 
 * Created in the main() entrypoint. 
 * 
 * @author Chris Horlick
 * @version 0.0.7
 * @since 0.0.7
 */
public class RecipeDesktopPane extends javax.swing.JFrame {

    /**
	 * Generated id for serializable.
	 */
	private static final long serialVersionUID = 7738431620497423767L;

	/**
     * Creates new form RecipeDesktopPane
     */
    public RecipeDesktopPane() {
        initComponents();
    }

    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Use Case");

        jMenuItem2.setText("Use Case 1");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Use Case 2");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        
        pack();
    }
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {  
    	if(shopping == null) {
    		shopping = new ShoppingListMainFrame();
            this.jDesktopPane1.add(shopping);
    	}
    	shopping.show();
    }                                          

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {   

    	if(recipe == null) {
    		recipe = new JRecipeMainFrame();
            this.jDesktopPane1.add(recipe);
    	}
    	System.out.println(recipe);
        recipe.show();
    }                                          

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        System.exit(0);
    }                                          

    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    
	/**
	 * This is the main recipe frame view object. We can keep it here to help make it easier to 
	 * work with in the view. 
	 */
	JRecipeMainFrame recipe = null;
	
	/**
	 * This is the shopping list main view object. We can keep it here to help make it easier to 
	 * work with in the view. 
	 */
	ShoppingListMainFrame shopping = null;
               
}

