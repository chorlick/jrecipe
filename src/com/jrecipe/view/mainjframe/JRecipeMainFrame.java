package com.jrecipe.view.mainjframe;

import com.jrecipe.view.dialogs.newgroupdialog.NewGroupDialog;
import com.jrecipe.view.dialogs.newingredientdialog.NewIngredientDialog;
import com.jrecipe.view.dialogs.newstepdialog.NewStepDialog;

/**
 * This class is a sipmle dialog
 * for Steps.
 * 
 * @author Chris Horlick
 * @version 0.0.6
 * @since 0.0.6
 */
public class JRecipeMainFrame extends javax.swing.JFrame {

    /* serial id value */
	private static final long serialVersionUID = -4152457686901820272L;
	
	/**
     * Creates new form JRecipe
     */
    public JRecipeMainFrame() {
        initComponents();
        saveRecipeButton.addActionListener(new JRecipeMainFrameController());
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        recipeStepList = new javax.swing.JList<>();
        recipeNameLabel = new javax.swing.JLabel();
        recipeNameTextField = new javax.swing.JTextField();
        recipeStepLabel = new javax.swing.JLabel();
        recipeIngredientLabel = new javax.swing.JLabel();
        newStepButton = new javax.swing.JButton();
        deleteStepButton = new javax.swing.JButton();
        recipeGroupLabel = new javax.swing.JLabel();
        recipeGroupCombo = new javax.swing.JComboBox<>();
        newGroupButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ingredientList = new javax.swing.JList<>();
        newIngredientButton = new javax.swing.JButton();
        deleteIngredientButton = new javax.swing.JButton();
        saveRecipeButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenuItem = new javax.swing.JMenu();
        closeFileMenuOption = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(recipeStepList);

        recipeNameLabel.setText("Recipe Name");

        recipeStepLabel.setText("Recipe Steps");

        recipeIngredientLabel.setText("Recipe Ingredients");

        newStepButton.setText("New Step");
        newStepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStepButtonActionPerformed(evt);
            }
        });

        deleteStepButton.setText("Detele Step");

        recipeGroupLabel.setText("Recipe Group");

        newGroupButton.setText("New Group");
        newGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGroupButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(ingredientList);

        newIngredientButton.setText("New Ingredient");
        newIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newIngredientButtonActionPerformed(evt);
            }
        });

        deleteIngredientButton.setText("Delete Ingredient");

        saveRecipeButton.setText("Save Recipe");

        fileMenuItem.setText("File");

        closeFileMenuOption.setText("Close");
        closeFileMenuOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFileMenuOptionActionPerformed(evt);
            }
        });
        fileMenuItem.add(closeFileMenuOption);

        menuBar.add(fileMenuItem);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveRecipeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(recipeNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                        .addGap(19, 19, 19)
                        .addComponent(recipeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(recipeGroupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(newIngredientButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(deleteIngredientButton))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(newStepButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(deleteStepButton)))
                                        .addGap(0, 283, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newGroupButton)
                                    .addComponent(recipeGroupCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(recipeStepLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(recipeIngredientLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recipeNameLabel)
                    .addComponent(recipeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recipeGroupLabel)
                    .addComponent(recipeGroupCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newGroupButton)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recipeStepLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newStepButton)
                    .addComponent(deleteStepButton))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recipeIngredientLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newIngredientButton)
                    .addComponent(deleteIngredientButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveRecipeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                 

    private void closeFileMenuOptionActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        System.exit(0);
    }                                                   

    @SuppressWarnings("deprecation")
	private void newGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        NewGroupDialog d = new NewGroupDialog();
        d.show();
    }                                              

    @SuppressWarnings("deprecation")
	private void newStepButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        NewStepDialog d = new NewStepDialog();
        d.show();
    }                                             

    @SuppressWarnings("deprecation")
	private void newIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        NewIngredientDialog d = new NewIngredientDialog();
        d.show();
    }                                                   

    private javax.swing.JMenuItem closeFileMenuOption;
    private javax.swing.JButton deleteIngredientButton;
    private javax.swing.JButton deleteStepButton;
    private javax.swing.JMenu fileMenuItem;
    private javax.swing.JList<String> ingredientList;
    private javax.swing.JButton saveRecipeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton newGroupButton;
    private javax.swing.JButton newIngredientButton;
    private javax.swing.JButton newStepButton;
    private javax.swing.JComboBox<String> recipeGroupCombo;
    private javax.swing.JLabel recipeGroupLabel;
    private javax.swing.JLabel recipeIngredientLabel;
    private javax.swing.JLabel recipeNameLabel;
    private javax.swing.JTextField recipeNameTextField;
    private javax.swing.JLabel recipeStepLabel;
    private javax.swing.JList<String> recipeStepList;
}
