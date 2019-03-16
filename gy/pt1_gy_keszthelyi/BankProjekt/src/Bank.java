/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 8emi95
 */

import extra.Console;

public class Bank {
    private Szamla szamla;
    
    public Bank() {
        szamla = new Szamla(100, 1000);
    }
    
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.menu();
    }
    
    public void menu() {
        char valasz;
        do {
            System.out.println("e-egyenleg b-betesz k-kivesz v-vege");
            valasz = Console.readChar();
            int osszeg;
            switch(valasz) {
                case 'e':
                    System.out.println(szamla);
                    break;
                case 'b':
                    osszeg = Console.readInt("osszeg? ");
                    szamla.betesz(osszeg);
                    System.out.println(szamla);
                    break;
                case 'k':
                    osszeg = Console.readInt("osszeg? ");
                    if (!szamla.kivesz(osszeg)) {
                        System.out.println("Nincs fedezet!");
                    }
                    System.out.println(szamla);
                    break;
            }
        } while (valasz != 'v');
    }
}
