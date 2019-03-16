/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasz.model;

import java.util.Random;

/**
 *
 * @author Zsoci
 */
public class Engine {
    
    public static final int SIZE = 7;
    
    private int[][] field;
    
    public void startNewGame(){
        field = new int[SIZE][SIZE];
        for(int i =0; i < SIZE;++i){
            for(int j =0; j < SIZE;++j){
                field[i][j] = new Random().nextInt(52);
            }
        }
    }
    
    public void put(int i, int j){
        for(int k =0;k < SIZE;++k){
            if(k != j){
                field[i][k]--;
            }
        }
        for(int l =i;l >=0;--l){
            if(l != i){
                field[l][j]--;
            }
        }
    }
    
    public int get(int i, int j){
        return field[i][j];
    }
    
    public boolean isGameOver(){
        for(int j =0;j < SIZE;++j){
            for(int i =0;i < SIZE-1;++i){
                if(field[i][j]< field[i+1][j]){
                    return false;
                }
            }
            try{
                if(field[SIZE-1][j]< field[0][j+1]){
                return false;
            }
            }catch(ArrayIndexOutOfBoundsException e){
                
            }
            
        }
        return true;
    }
    
}
