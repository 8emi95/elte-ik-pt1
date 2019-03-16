package CoctailExplorer;

import java.util.Arrays;
import java.util.Objects;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dobreff András
 */
public class CoctailTest {

    /**
     * Test of getName method, of class Coctail.
     */
    @Test
    public void testGetName() {
        Coctail instance = new Coctail("Sex on the beach", 
                new Ingredient[]{new Ingredient("Vodka"), new  Ingredient("Narancslé"),
                    new Ingredient("Áfonyalé"), new Ingredient("Baracklikőr")});
        String expResult = "Sex on the beach";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIngredients method, of class Coctail.
     */
    @Test
    public void testGetIngredients() {
        System.out.println("getIngredients");
        Ingredient[] expResult = new Ingredient[]{new Ingredient("Rum"), new Ingredient("Cola")};
        Coctail instance = new Coctail("Rumoskóla", 
                new Ingredient[]{new Ingredient("Rum"), new Ingredient("Cola")});
        Ingredient[] result = instance.getIngredients();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Coctail.
     */
    @Test
    public void testEquals() {
        Coctail c1 = new Coctail("coctail", new Ingredient[]{ 
            new Ingredient("ing1"), new Ingredient("ing2")});
        Coctail c2 = new Coctail("coctail", new Ingredient[]{ 
            new Ingredient("ing1"), new Ingredient("ing2")});
        assertEquals(c1, c2);
    }

    /**
     * Test of hashCode method, of class Coctail.
     */
    @Test
    public void testHashCode() {
        Coctail c1 = new Coctail("coctail", new Ingredient[]{ 
            new Ingredient("ing1"), new Ingredient("ing2")});
        
        int expectedHashCode = 7;
        expectedHashCode = 37 * expectedHashCode + Objects.hashCode("coctail");
        expectedHashCode = 37 * expectedHashCode + Arrays.deepHashCode(new Ingredient[]{ 
            new Ingredient("ing1"), new Ingredient("ing2")});
        
        assertEquals(expectedHashCode, c1.hashCode());
    }
    
}
