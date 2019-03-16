/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coctailexplorerfrontend;

import CoctailExplorer.Coctail;
import CoctailExplorer.CoctailExplorer;
import CoctailExplorer.CoctailXMLParser;
import CoctailExplorer.Ingredient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dobreff András
 */
public class CoctailExplorerFrontend {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CoctailXMLParser parser = new CoctailXMLParser();
        try {
            parser.parseXmlFile( new File("YOUR_LOCATION\\CoctailExplorerFrontend\\inputfiles\\coctails.xml"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CoctailExplorerFrontend.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Coctail[] coctails = parser.getCoctails();
        
        CoctailExplorer explorer = new CoctailExplorer();
        explorer.init(coctails);
        
        CoctailExplorerFrame frame = new CoctailExplorerFrame("Coctails");
        
        Set<Ingredient> ingreds = explorer.getAllIngredients();
        List<String> ingredientsNames = new ArrayList<>();
        for(Ingredient ingred : ingreds){
            ingredientsNames.add(ingred.getName());
        }
        
        Collections.sort(ingredientsNames);
        
        frame.setIngredients(ingredientsNames.toArray(new String[ingredientsNames.size()]));
        
        frame.addCheckCoctailListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String[] ingredientNames = frame.getSelectedIngredients();
                Set<Ingredient> ingredients = new HashSet<>();
                for(String name : ingredientNames){
                    ingredients.add(new Ingredient(name));
                }
               
                try{
                    Optional<Coctail> exploredCoctail = explorer.exploreCoctail(ingredients);
                     String message;
                    if(exploredCoctail.isPresent()){
                        message = "Új koktélt fedeztél fel: "+exploredCoctail.get().getName()+"!";
                        frame.addExploredCoctail(exploredCoctail.get().getName());
                        frame.clearSelectedIngredients();
                    }else{
                        message = "Ezekből az összetevőkből nem lehet koktélt összeállítani!";
                    }
                    JOptionPane.showMessageDialog(frame, message, "Coctail", JOptionPane.PLAIN_MESSAGE);
                }catch(IllegalArgumentException ex){
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.setVisible(true);
    }
    
}
