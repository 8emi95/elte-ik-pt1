/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import extra.Console;
/**
 *
 * @author zentaidavid
 */
public class Osszead {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Osszeadas: ");
        int a = Console.readInt("1. szam? ");
        int b = Console.readInt("2. szam? ");
        System.out.println("Osszeg: " + (a+b));
    }
    
}
