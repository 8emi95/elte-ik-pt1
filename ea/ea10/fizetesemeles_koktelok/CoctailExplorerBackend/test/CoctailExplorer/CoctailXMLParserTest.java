/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoctailExplorer;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Dobreff András
 */
public class CoctailXMLParserTest {

    /**
     * Test of parseXMLString method, of class CoctailXMLParser.
     */
    @Test
    public void testParseXMLString() {
        Coctail[] expected = new Coctail[]{
                                new Coctail("Coctail_1", new Ingredient[]{
                                    new Ingredient("Ingredient_1"),
                                    new Ingredient("Ingredient_2")
                                }),
                                new Coctail("Coctail_2", new Ingredient[]{
                                    new Ingredient("Ingredient_3"),
                                    new Ingredient("Ingredient_4"),
                                    new Ingredient("Ingredient_5")
                                })
                    };
        String xml = "<?xml version=\"1.0\"?>"
                    + "<Coctails>"
                        + "<Coctail>"
                            + "<Name>Coctail_1</Name>"
                            + "<Ingredient>Ingredient_1</Ingredient>"
                            + "<Ingredient>Ingredient_2</Ingredient>"
                        + "</Coctail>"
                        + "<Coctail>"
                            + "<Name>Coctail_2</Name>"
                            + "<Ingredient>Ingredient_3</Ingredient>"
                            + "<Ingredient>Ingredient_4</Ingredient>"
                            + "<Ingredient>Ingredient_5</Ingredient>"
                        + "</Coctail>"
                    +"</Coctails>";
        CoctailXMLParser instance = new CoctailXMLParser();
        instance.parseXMLString(xml);
        Coctail[] coctails = instance.getCoctails();
        
        Assert.assertArrayEquals(expected, coctails);
    }

    /**
     * Test of getCoctails method, of class CoctailXMLParser.
     */
    @Test
    public void testGetCoctailsWithoutParse() {
        CoctailXMLParser instance = new CoctailXMLParser();
        Coctail[] expResult = new Coctail[0];
        Coctail[] result = instance.getCoctails();
        Assert.assertArrayEquals(expResult, result);
    }
    
}
