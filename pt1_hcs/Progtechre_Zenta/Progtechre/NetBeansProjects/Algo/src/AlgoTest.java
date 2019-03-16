/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dávid
 */
public class AlgoTest {

    private int[] szamok = new int[10];
    
    public AlgoTest() {
        for(int i=0; i<10; i++){
            szamok[i] = (int)(Math.random()*100);
        }
        System.out.println("");
        for (int i = 0; i < szamok.length; i++) {
            System.out.print(szamok[i]+" | ");
        }
        System.out.println("");
        new BuborekRendez();
    }
    
    

    public class BuborekRendez {

        public BuborekRendez() {
            for(int j=szamok.length; j>1; j--){
                for(int i=0; i<j-1; i++){
                    int seged=0;
                    if(szamok[i]>szamok[i+1]){
                        seged=szamok[i];
                        szamok[i]=szamok[i+1];
                        szamok[i+1]=seged;
                        for(int k=0; k<szamok.length; k++){
                            System.out.print(szamok[k]+" | ");
                        }
                        System.out.println("");
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new AlgoTest();
    }
}
