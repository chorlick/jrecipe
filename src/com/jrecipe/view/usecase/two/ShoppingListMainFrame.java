package com.jrecipe.view.usecase.two;

/**
 *	Main interface for the second use case, the shopping list.
 * 
 * @author Chris Horlick
 * @version 0.0.7
 * @since 0.0.7 
 */
public class ShoppingListMainFrame extends javax.swing.JInternalFrame {
    
    /**
	 * Generated id
	 */
	private static final long serialVersionUID = -8886282361089079637L;
	
	/**
     * Creates new form JRecipe
     */
    public ShoppingListMainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        shoppingList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        removeItemButton = new javax.swing.JButton();
        addIngredientButton = new javax.swing.JButton();

        jScrollPane1.setViewportView(shoppingList);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Shopping List");

        removeItemButton.setText("Remove Item");

        addIngredientButton.setText("Add Ingredients");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeItemButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addIngredientButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeItemButton)
                    .addComponent(addIngredientButton))
                .addContainerGap())
        );
        this.setClosable(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        pack();
    }                      

    private javax.swing.JButton addIngredientButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeItemButton;
    private javax.swing.JList<String> shoppingList;
}
