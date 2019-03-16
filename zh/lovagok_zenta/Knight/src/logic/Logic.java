package logic;

import java.awt.Color;
import java.util.Random;
import logic.Player.PlayerType;

public class Logic {
    private int n = 8;
    private Player[][] table;
    private Player knight;
    private Player volt;
    
    public Logic(){
        Random rnd = new Random();
        Random rnd2 = new Random();
        knight = new Player(rnd.nextInt(n),rnd2.nextInt(n), PlayerType.KNIGHT);
        volt = new Player(0,0, PlayerType.VOLT);
        table = new Player[n][n];
        table[knight.getX()][knight.getY()] = knight;
        
    }
    
    public void step(int row, int column) {
        if ((table[row][column] == null)) {
                if(Math.abs(row-knight.getX())==1 && Math.abs(column-knight.getY())==2 ||
                   Math.abs(row-knight.getX())==2 && Math.abs(column-knight.getY())==1){
                    table[knight.getX()][knight.getY()] = volt;
                    
                    knight.setX(row);
                    knight.setY(column);
                    table[row][column] = knight;
                }
            
        } else{
            knight = table[row][column];
        }
    }
    public PlayerType findWinner() {
        int counter = 0;
        int db = 0;
        for (int i = 0; i <n; i++) {
            for(int j = 0; j < n; j++) {
              if (table[i][j] != null && table[i][j].getType()==PlayerType.VOLT ) {
                  counter = counter+1;
              }
            }
        }
      if (counter == 63){
          return PlayerType.KNIGHT;
      }else{
        try{
            if((table[knight.getX()+1][knight.getY()+2])!= null &&(table[knight.getX()+1][knight.getY()+2].getType())== (Player.PlayerType.VOLT)){
                db++;
            }
        }catch(IndexOutOfBoundsException e  ){ db++ ;}
        try{
            if((table[knight.getX()-1][knight.getY()+2])!= null &&(table[knight.getX()-1][knight.getY()+2].getType())== (Player.PlayerType.VOLT)){
                db++;
            }
        }catch(IndexOutOfBoundsException e){ db++ ;}
        try{
            if((table[knight.getX()+1][knight.getY()-2])!= null &&(table[knight.getX()+1][knight.getY()-2].getType())== (Player.PlayerType.VOLT)){
                db++;
            }
        }catch(IndexOutOfBoundsException e){ db++ ;}
        try{
            if((table[knight.getX()-1][knight.getY()-2])!= null &&(table[knight.getX()-1][knight.getY()-2].getType())== (Player.PlayerType.VOLT)){
                db++;
            }
        }catch(IndexOutOfBoundsException e){ db++ ;}
        try{
            if((table[knight.getX()+2][knight.getY()+1])!= null &&(table[knight.getX()+2][knight.getY()+1].getType())== (Player.PlayerType.VOLT)){
            db++;
        }
        }catch(IndexOutOfBoundsException e  ){ db++ ;}
        try{
            if((table[knight.getX()+2][knight.getY()-1])!= null &&(table[knight.getX()+2][knight.getY()-1].getType())== (Player.PlayerType.VOLT)){
                db++;
            }
        }catch(IndexOutOfBoundsException e){ db++ ;}
        try{
            if((table[knight.getX()-2][knight.getY()+1])!= null &&(table[knight.getX()-2][knight.getY()+1].getType())== (Player.PlayerType.VOLT)){
                db++;
            }
        }catch(IndexOutOfBoundsException e){ db++ ;}
        try{
            if((table[knight.getX()-2][knight.getY()-1])!= null &&(table[knight.getX()-2][knight.getY()-1].getType())== (Player.PlayerType.VOLT)){
                db++;
            }
        }catch(IndexOutOfBoundsException e){ db++ ;}
        
        if(db == 8){
            return PlayerType.VOLT;
        }
      }
    return PlayerType.NOBODY;
    }
    
    public PlayerType getTypeAt(int i, int j){
        if(table[i][j]!=null)
            return table[i][j].getType();
        return null;
    }
}

