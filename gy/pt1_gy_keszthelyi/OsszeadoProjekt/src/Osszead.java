/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import extra.Console;

/**
 *
 * @author 8emi95
 */
public class Osszead {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Összeadás");
        int a = Console.readInt("1. szám?");
        int b = Console.readInt("2. szám?");
        System.out.println("Összeg: " + (a + b));
    }
    
}
