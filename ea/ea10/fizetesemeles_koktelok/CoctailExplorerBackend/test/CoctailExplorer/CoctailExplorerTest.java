package CoctailExplorer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dobreff András
 */
public class CoctailExplorerTest {

    /**
     * Test of exploreCoctail method, of class CoctailExplorer.
     * In this case the Coctail is found.
     */
    @Test
    public void testExploreCoctailFound() {
        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(new Ingredient("Narancslé"));
        ingredients.add(new Ingredient("Grenadine"));
        ingredients.add(new Ingredient("Tequila"));
        Coctail expResult = new Coctail("Tequila Sunrise",
                                            new Ingredient[]{ 
                                                new Ingredient("Tequila"),
                                                new Ingredient("Narancslé"),
                                                new Ingredient("Grenadine")
                                            });
        
        CoctailExplorer instance = new CoctailExplorer();
        instance.init(new Coctail[]{expResult});
        Optional<Coctail> result = instance.exploreCoctail(ingredients);
        
        assertEquals(expResult, result.get());
    }
    
    /**
     * Test of exploreCoctail method, of class CoctailExplorer.
     * In this case the Coctail is not found, because the explorer was not been 
     * initialized.
     */
    @Test
    public void testExporeCoctailNotFound(){
        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(new Ingredient("Tequila"));
        ingredients.add(new Ingredient("Vodka"));
                
        CoctailExplorer instance = new CoctailExplorer();
        
        Optional<Coctail> result = instance.exploreCoctail(ingredients);
        
        //The instance was not initailized
        assertEquals(Optional.empty(), result);
    }
    
    /**
     * Test of exploreCoctail method, of class CoctailExplorer.
     * In this case an exception is thrown, because Coctails cannot be searched 
     * with less than 2 ingtredients.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testExporeCoctailWithOneIngredient(){
        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(new Ingredient("Tequila"));
                
        CoctailExplorer instance = new CoctailExplorer();
        
        instance.exploreCoctail(ingredients);
    }
    
    /**
     * Test of exploreCoctail method, of class CoctailExplorer.
     * In this case an exception is thrown, because Coctails cannot be searched 
     * with less than 2 ingtredients.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testExporeCoctailWithNoIngredient(){
        Set<Ingredient> ingredients = new HashSet<>();
                
        CoctailExplorer instance = new CoctailExplorer();
        
        instance.exploreCoctail(ingredients);
    }
    
    /**
     * Test of exploreCoctail method, of class CoctailExplorer.
     * In this case an exception is thrown. This case is handled as the user
     * would have called the function with an empty set.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testExporeCoctailWithNull(){        
        CoctailExplorer instance = new CoctailExplorer();
        
        instance.exploreCoctail(null);
    }
    
    @Test
    public void testGetAllIngredients(){
        CoctailExplorer instance = new CoctailExplorer();
        instance.init(new Coctail[]{
            new Coctail("Tequila Sunrise", new Ingredient[]{
                new Ingredient("Tequila"),
                new Ingredient("Narancslé"),
                new Ingredient("Grenadine")
            }),
            new Coctail("Sex on the beach", new Ingredient[]{
                new Ingredient("Vodka"),
                new Ingredient("Baracklikőr"),
                new Ingredient("Narancslé"),
                new Ingredient("Áfonyalé")
            }),
            new Coctail("Pink Cadillac", new Ingredient[]{
                new Ingredient("Vodka"),
                new Ingredient("Amaretto"),
                new Ingredient("Eperszirup"),
                new Ingredient("Citromlé")
            })
        });
        
        Set<Ingredient> allIngredients = instance.getAllIngredients();
        Set<Ingredient> expectedIngredients = new HashSet( Arrays.asList(new Ingredient[]{
                new Ingredient("Tequila"),
                new Ingredient("Narancslé"),
                new Ingredient("Grenadine"),
                new Ingredient("Vodka"),
                new Ingredient("Baracklikőr"),
                new Ingredient("Narancslé"),
                new Ingredient("Áfonyalé"),
                new Ingredient("Vodka"),
                new Ingredient("Amaretto"),
                new Ingredient("Eperszirup"),
                new Ingredient("Citromlé")
            }));
        assertEquals(expectedIngredients, allIngredients);
    }
}
