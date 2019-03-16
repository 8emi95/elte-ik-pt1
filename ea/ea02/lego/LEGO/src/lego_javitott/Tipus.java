/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lego_javitott;

import java.awt.Color;

/**
 *
 * @author Dobreff András
 */
public class Tipus {
    private String név;
    private Color szín;
    private int ár;
   
    public Tipus(String név, Color szín, int ár){
        this.név = név;
        this.szín = szín;
        this.ár = ár;
    }
    
    public String név() { return név; }
    public Color szín(){ return szín; }
    public int ár() { return ár; }
}
