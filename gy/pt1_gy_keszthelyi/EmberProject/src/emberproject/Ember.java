/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emberproject;

/**
 *
 * @author 8emi95
 */
public class Ember /*extends Object*/ { // felesleges, fordítóprogram odaképzeli
    private int magassag;
    private String nev;
    
    @Override public boolean equals(Object obj) {
        return false;
    }
    
    public int getMagassag() {
        return magassag;
    }
    
    public String getNev() {
        return nev;
    }
    
    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }
    
    public void setNev(String nev) {
        this.nev = nev;
    }
    
    public String toString() {
        return "magassag: " + magassag + ", nev: " + nev;
    }
    
    public Ember(String nev, int magassag) {
        this.nev = nev;
        this.magassag = magassag;
    }
    
    public Ember(String nev) {
       this. nev = nev;
    }
}
