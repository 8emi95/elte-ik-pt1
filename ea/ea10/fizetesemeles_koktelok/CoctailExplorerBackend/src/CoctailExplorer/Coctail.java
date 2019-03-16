/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoctailExplorer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author Dobreff András
 */
public class Coctail {
    private final String name;
    private final Ingredient[] ingredients;
    
    Coctail(String name, Ingredient[] ingredients){
        this.name = name;
        this.ingredients = ingredients;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Ingredient[] getIngredients(){
        return this.ingredients;
    }
    
    @Override
    public boolean equals(Object object){
        if(object instanceof Coctail){
            boolean nameEq = this.name.equals(((Coctail)object).name);
            HashSet<Ingredient> set1 = new HashSet<>(Arrays.asList(this.ingredients));
            HashSet<Ingredient> set2 = new HashSet<>(Arrays.asList(((Coctail) object).ingredients));
            
            return nameEq && set1.equals(set2);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Arrays.deepHashCode(this.ingredients);
        return hash;
    }
}
