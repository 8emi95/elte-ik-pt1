/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoctailExplorer;

import java.util.Set;
import java.util.Optional;

/**
 *
 * @author Dobreff András
 */
public interface ICoctailExplorer {
    
    /**
     * Searches a Coctail within the stored ones. If found it returns it. If not
     * found it return an empty optional.
     * A coctail cannot be searched with zero or one ingredients. In this case
     * an {@link IllegalArgumentException} will be thrown
     * @param ingredients the ingredient of the searched Coctail
     * @return 
     * @throws IllegalArgumentException 
     */
    public Optional<Coctail> exploreCoctail(Set<Ingredient> ingredients)
            throws IllegalArgumentException;
    
    /**
     * Initializes the explorer with the given Coctails 
     * These Coctails will be stored and can be searched for
     * @param conctails 
     */
    public void init(Coctail[] conctails);
    
    /**
     * Gets all Ingredients of all of the registered Coctails 
     * @return Returns every ingredient that are registered through coctails
     */
    Set<Ingredient> getAllIngredients();
}
