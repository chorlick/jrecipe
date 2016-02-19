package com.jrecipe.view.mainjframe;
/**
 *
 * @author chorl_000
 */
public class JRecipeMainFrame extends javax.swing.JFrame {

    /**
     * Creates new form JRecipe
     */
    public JRecipeMainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
        menuBar = new javax.swing.JMenuBar();
        fileMenuItem = new javax.swing.JMenu();
        closeFileMenuOption = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        recipeStepList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(recipeStepList);

        recipeNameLabel.setText("Recipe Name");

        recipeStepLabel.setText("Recipe Steps");

        recipeIngredientLabel.setText("Recipe Ingredients");

        newStepButton.setText("New Step");

        deleteStepButton.setText("Detele Step");

        recipeGroupLabel.setText("Recipe Group");

        recipeGroupCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        newGroupButton.setText("New Group");

        ingredientList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(ingredientList);

        newIngredientButton.setText("New Ingredient");

        deleteIngredientButton.setText("Delete Ingredient");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void closeFileMenuOptionActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        System.exit(0);
    }                                                   

    

    // Variables declaration - do not modify                     
    private javax.swing.JMenuItem closeFileMenuOption;
    private javax.swing.JButton deleteIngredientButton;
    private javax.swing.JButton deleteStepButton;
    private javax.swing.JMenu fileMenuItem;
    private javax.swing.JList<String> ingredientList;
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
    // End of variables declaration    
   
}