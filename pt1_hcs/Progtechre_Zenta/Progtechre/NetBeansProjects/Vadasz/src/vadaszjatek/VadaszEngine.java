/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vadaszjatek;

/**
 *
 * @author Dávid
 */
public class VadaszEngine {
    
    private JatekosTipusok[][] tabla;
    JatekosPozik preda;
    private JatekosPozik[] vadasz;
    private int lepesszam;
    private JatekosTipusok aktualis;
    
    public VadaszEngine(int size){ //létrehozzuk a játékteret üresen
        tabla = new JatekosTipusok[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tabla[i][j] = JatekosTipusok.SENKI;
            }
        }
        
        aktualis = JatekosTipusok.VADASZ; //a kezdojatekos megadása
        
        preda = new JatekosPozik((size-1)/2,(size-1)/2);    //megadjuk a jatektabla közepét majd ráadjuk a típust
        tabla[preda.getX()][preda.getY()] = JatekosTipusok.PREDA;
        
        vadasz[0] = new JatekosPozik(size,size);    //megadjuk a vadasz poziciojait
        vadasz[1] = new JatekosPozik(size,0);
        vadasz[2] = new JatekosPozik(0,size);
        vadasz[3] = new JatekosPozik(0,0);
        for (int i = 0; i < vadasz.length; i++) {
            tabla[vadasz[i].getX()][vadasz[i].getY()] = JatekosTipusok.VADASZ;
        }
        
        lepesszam = size*4; // megadja a lépsek szamat
    }
    
    public JatekosTipusok[][] getTabla(){
        return tabla.clone();
    }
    
    public int getLepesszam(){
        return lepesszam;
    }
    
    public JatekosTipusok getAktualis(){
        return aktualis;
    }
    
    
}
