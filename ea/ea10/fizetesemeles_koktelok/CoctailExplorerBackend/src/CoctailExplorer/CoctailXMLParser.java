/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoctailExplorer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author Dobreff András
 */
public class CoctailXMLParser {
   
    public static final String CoctailElem = "Coctail";
    public static final String CoctailNameElem = "Name";
    public static final String CoctailIngredientElem = "Ingredient";
    
    private Coctail[] coctails = new Coctail[]{};
    
    /**
     * 
     * @param file 
     * @throws java.io.FileNotFoundException 
     */
    public void parseXmlFile(File file) throws FileNotFoundException{
        InputStream inputStream= new FileInputStream(file);
        Reader reader = new InputStreamReader(inputStream);
        InputSource is = new InputSource(reader);
        parseXML(is);
    }

    public void parseXMLString(String xml){
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));
        parseXML(is);
    }
    
    private void parseXML(InputSource is){
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document dom = db.parse(is);
            
            Element documentElem = dom.getDocumentElement();
            NodeList nl = documentElem.getElementsByTagName(CoctailElem);
            
            if(nl != null){
            this.coctails = new Coctail[nl.getLength()];
                for(int i = 0; i < nl.getLength(); i++){
                    Node node = nl.item(i);
                    Coctail coctail = getCoctail(node);
                    this.coctails[i] = coctail;
                }
            }
            
        }catch(ParserConfigurationException | SAXException | IOException pce) {
                pce.printStackTrace();
        }
    }
    
    public Coctail[] getCoctails(){
        return this.coctails;
    }
    
    private Coctail getCoctail(Node node) {
        String name = null;
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        NodeList nameNodes = ((Element) node).getElementsByTagName(CoctailNameElem);
        if(nameNodes != null && nameNodes.getLength() > 0){
            Node n = nameNodes.item(0);
            name = n.getFirstChild().getNodeValue();
        }
        
        NodeList ingredientNodes = ((Element) node).getElementsByTagName(CoctailIngredientElem);
        if(ingredientNodes != null){
            for(int i = 0; i < ingredientNodes.getLength(); i++){
                Node n = ingredientNodes.item(i);
                ingredients.add(new Ingredient(n.getFirstChild().getNodeValue()));
            }
        }
        
        Ingredient[] ingredientsArray = new Ingredient[ingredients.size()];
        ingredients.toArray(ingredientsArray);
        
        return new Coctail(name, ingredientsArray);
    }
}
