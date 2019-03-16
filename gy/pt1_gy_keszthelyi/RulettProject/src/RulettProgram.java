/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 8emi95
 */
public class RulettProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Rulett");
        int nyeroSzam = (int)(Math.random() * 37);
        System.out.println("A nyeroszam: " + nyeroSzam);
        if (nyeroSzam == 0) {
            System.out.println("Zero, mindent a bank nyert");
        } else {
            if (nyeroSzam <= 12) {
            System.out.println("1. tucat");
            } else if (nyeroSzam <= 24) {
            System.out.println("2. tucat");
            } else {
            System.out.println("3. tucat");
            }
            
            if (nyeroSzam % 2 == 0) {
                System.out.println("A nyeroszam paros.");
            } else {
                System.out.println("A nyeroszam paratlan.");
            }
        }
        

    }
    
}
