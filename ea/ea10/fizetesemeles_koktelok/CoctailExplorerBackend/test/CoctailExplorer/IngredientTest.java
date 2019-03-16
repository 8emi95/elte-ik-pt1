package CoctailExplorer;

import java.util.Objects;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dobreff András
 */
public class IngredientTest {
    /**
     * Test of getName method, of class Ingredient.
     */
    @Test
    public void testGetName() {
        Ingredient instance = new Ingredient("Vodka");
        String expResult = "Vodka";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Ingredient.
     */
    @Test
    public void testEquals() {
        Object object1 = new Ingredient("Rum");
        Object object2 = new Ingredient("Tequila");
        Object object3 = new Integer("1");
        Ingredient instance = new Ingredient("Rum");

        assertTrue(instance.equals(object1));
        assertFalse(instance.equals(object2));
        assertFalse(instance.equals(object3));
    }

    /**
     * Test of hashCode method, of class Ingredient.
     */
    @Test
    public void testHashCode() {
        Ingredient instance = new Ingredient("Rum");
        int expResult = 7*89+Objects.hashCode("Rum");
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
}
