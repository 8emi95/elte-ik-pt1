/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoctailExplorer;

import java.util.Objects;

/**
 *
 * @author Dobreff András
 */
public class Ingredient {
    /*
    Vodka("Vodka"), Tequila("Tequila"), Rum("Rum"), Fehér_rum("Fehér rum"),
    Narancslé("Narancslé"), Grenadine("Grenadine"), Áfonyalé("Áfonyalé"),
    Baracklikőr("Baracklikőr"), Cola("Kóla"), Lime("Lime"), Amaretto("Amaretto"),
    Eperszirup("Eperszirup");
    */
    private final String name;
    
    public Ingredient(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    @Override
    public boolean equals(Object object){
        if(object instanceof Ingredient){
            return this.name.equals(((Ingredient) object).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }
}
