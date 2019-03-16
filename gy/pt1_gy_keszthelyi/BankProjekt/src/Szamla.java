/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 8emi95
 */

//package bank;

public class Szamla {
    protected int szamlaSzam;
    protected int egyenleg;
    
    public Szamla(int szamlaSzam, int egyenleg) {
        this.szamlaSzam = szamlaSzam;
        this.egyenleg = egyenleg;
    }
    
    public Szamla(int szamlaSzam) {
        this(szamlaSzam, 0);
    }
    
    public int getEgyenleg() {
        return egyenleg;
    }
    
    public void betesz(int osszeg) {
        egyenleg += osszeg;
    }
    
    public boolean kivesz(int osszeg) {
        if (van(osszeg)) {
            egyenleg -= osszeg;
            return true;
        }
        return false;
    }
    
    public boolean van(int osszeg) {
        return egyenleg >= osszeg;
    }
    
    @Override public String toString() {
        return "szamlaszam: " + szamlaSzam + ", egyenleg:" + egyenleg + " Ft";
    }
}