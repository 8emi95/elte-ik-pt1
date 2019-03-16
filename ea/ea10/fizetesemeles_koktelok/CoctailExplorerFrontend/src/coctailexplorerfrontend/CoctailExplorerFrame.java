/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coctailexplorerfrontend;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Dobreff András
 */
public class CoctailExplorerFrame extends JFrame{
    private JPanel ingredientsPanel;
    private JPanel selectedingredientsPanel;
    private JPanel exploredCoctailsPanel;
    private JComboBox ingredientsComboBox;
    private JButton addIngreditsButton;
    private JList selectedIngredientsList;
    private JButton removeIngredientButton;
    private JButton checkCoctailButton;
    private JList exploredCoctailsList;
    private ActionListener checkcoctailListener;
 
    public CoctailExplorerFrame(String title) throws HeadlessException {
        super(title);
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    public void setIngredients(String[] ingredients){
        DefaultComboBoxModel model = (DefaultComboBoxModel) ingredientsComboBox.getModel();
        for( String ingredient : ingredients){
            model.addElement(ingredient);
        }
    }
    
    public void addCheckCoctailListener(ActionListener listener){
        this.checkcoctailListener = listener;
    }
    
    public void addExploredCoctail(String coctail){
        DefaultListModel model = ((DefaultListModel) this.exploredCoctailsList.getModel()); 
        model.addElement(coctail);
    }
    
    public void clearSelectedIngredients(){
        DefaultListModel model = ((DefaultListModel) this.selectedIngredientsList.getModel()); 
        model.removeAllElements();
    }
    
    public String[] getSelectedIngredients(){
        DefaultListModel model = ((DefaultListModel) this.selectedIngredientsList.getModel()); 
        String[] result = new String[model.getSize()];
        model.copyInto(result);
        return result;
    }

    private void initComponents() {
        ingredientsPanel = new JPanel();
        selectedingredientsPanel = new JPanel();
        exploredCoctailsPanel = new JPanel();
        
        ingredientsComboBox = new JComboBox();
        addIngreditsButton = new JButton("Add Ingredient");
        
        selectedIngredientsList = new JList();
        removeIngredientButton = new JButton("Remove Ingredient");
        checkCoctailButton = new JButton("Check Coctail");
        
        exploredCoctailsList = new JList();
        
        ingredientsPanel.setBorder(BorderFactory.createTitledBorder("Ingredients"));
        selectedingredientsPanel.setBorder(BorderFactory.createTitledBorder("Selected Ingredients"));
        exploredCoctailsPanel.setBorder(BorderFactory.createTitledBorder("Explored Coctail"));
       
        addPanelLayout();
        addIngredientsPanleLayout();
        addExploredCoctailsLayout();
        addSelectedIngredientsLayout();
        
        ingredientsComboBox.setModel(new DefaultComboBoxModel());
        selectedIngredientsList.setModel(new DefaultListModel());
        exploredCoctailsList.setModel(new DefaultListModel());
        
        addIngreditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoctailExplorerFrame.this.addIngredientButtonClicked();
            }
        });
        
        removeIngredientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoctailExplorerFrame.this.removeIngredientButtonClicked();
            }
        });
        
        checkCoctailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CoctailExplorerFrame.this.checkCoctailButtonClicked();
            }
        });
    }

    @Override
    public void setVisible(boolean b) {
        this.pack(); //A pack függvénnyel kiszámoltatjuk az ablak megfelelő méretét
        super.setVisible(b);
    }
    
    private void addPanelLayout() {
        GroupLayout panelLayout = new GroupLayout(getContentPane());
        this.setLayout(panelLayout);
        
        panelLayout.setHorizontalGroup(panelLayout.createParallelGroup()
                .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ingredientsPanel)
                        .addGap(10)
                        .addComponent(selectedingredientsPanel)
                        .addContainerGap()
                )
                .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exploredCoctailsPanel)
                        .addContainerGap()
                )
                
        );
        
        panelLayout.setVerticalGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup()
                        .addComponent(ingredientsPanel)
                        .addComponent(selectedingredientsPanel)
                )
                .addGap(10)
                .addComponent(exploredCoctailsPanel)
                .addContainerGap()
        );
    }

    private void addIngredientsPanleLayout() {
        GroupLayout ingredLayout = new GroupLayout(ingredientsPanel);
        ingredientsPanel.setLayout(ingredLayout);
        
        ingredLayout.setHorizontalGroup(ingredLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ingredLayout.createParallelGroup()
                    .addComponent(ingredientsComboBox)
                    .addComponent(addIngreditsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                )
                .addContainerGap()
        );
        
        ingredLayout.setVerticalGroup(ingredLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ingredientsComboBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addComponent(addIngreditsButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
    }

    private void addExploredCoctailsLayout() {
        GroupLayout exploredLayout = new GroupLayout(exploredCoctailsPanel);
        exploredCoctailsPanel.setLayout(exploredLayout);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(exploredCoctailsList);
        
        exploredLayout.setHorizontalGroup(exploredLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addContainerGap()
        );
        
        exploredLayout.setVerticalGroup(exploredLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addContainerGap()
        );
    }
    
    private void addSelectedIngredientsLayout(){
        GroupLayout selIngrLayout = new GroupLayout(selectedingredientsPanel);
        selectedingredientsPanel.setLayout(selIngrLayout);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(selectedIngredientsList);
        
        selIngrLayout.setHorizontalGroup(selIngrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selIngrLayout.createParallelGroup()
                        .addComponent(scrollPane)
                        .addGroup(selIngrLayout.createSequentialGroup()
                                .addComponent(checkCoctailButton, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                                .addGap(10)
                                .addComponent(removeIngredientButton, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                        )
                )
                .addContainerGap()
        );
        selIngrLayout.setVerticalGroup(selIngrLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addGap(10)
                .addGroup(selIngrLayout.createParallelGroup()
                        .addComponent(checkCoctailButton)
                        .addComponent(removeIngredientButton)
                )
                .addContainerGap()
        );
    }
    
    private void addIngredientButtonClicked(){
        DefaultListModel model = ((DefaultListModel) this.selectedIngredientsList.getModel());
        Object item = ingredientsComboBox.getSelectedItem();
        if(item != null){
            model.addElement(item);
        }
    }
    
    private void removeIngredientButtonClicked(){
        DefaultListModel model = ((DefaultListModel) this.selectedIngredientsList.getModel());
        int index = selectedIngredientsList.getSelectedIndex();
        if(index >= 0){
            model.remove(index);
        }
    }
    
    private void checkCoctailButtonClicked(){
        checkcoctailListener.actionPerformed(null);
    }
}
