/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vadaszbead2.model;

/**
 *
 * @author Zsoci
 */
public class Engine {
    public enum field {
        ATTACKER, DEFENDER, WAY;
    }
    
    private field[][] table;
    private int size;
    private int stepCount;
    private int prevX;
    private int prevY;
    private field currentPlayer;
    
    public Engine() {
        
    }
    
    public void newGame(int size) {
        this.size = size;
        this.stepCount = 4*size;
        table = new field[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                table[i][j] = field.WAY;
            }
        }
        
        table[0][0] = field.ATTACKER;
        table[0][size-1] = field.ATTACKER;
        table[size-1][0] = field.ATTACKER;
        table[size-1][size-1] = field.ATTACKER;
        table[size/2][size/2] = field.DEFENDER;
        prevX = -1;
        prevY = -1;
        currentPlayer = field.ATTACKER;
    }
    
    public field getField(int x, int y) {
        return this.table[x][y];
    }
    
    public int getSize() {
        return this.size;
    }
    
    public int getStepCount() {
        return this.stepCount;
    }
    
    public field getCurrentPlayer() {
        return currentPlayer;
    }
    
    public void preStep(int prevX, int prevY) {
        this.prevX = prevX;
        this.prevY = prevY;
    }
    
    public void step(int nextX, int nextY) {
        if(prevX < 0 || prevY < 0) {
            return;
        }
        if(table[prevX][prevY] == field.ATTACKER || table[prevX][prevY] == field.DEFENDER) {
            if(nextX >= 0 && nextY >= 0 && nextX < size && nextY < size && table[nextX][nextY] == field.WAY) {
                if(table[prevX][prevY] == field.ATTACKER) {
                    stepCount--;
                    table[nextX][nextY] = field.ATTACKER;
                    currentPlayer = field.DEFENDER;
                }
                else{
                    table[nextX][nextY] = field.DEFENDER;
                    currentPlayer = field.ATTACKER;
                }
                table[prevX][prevY] = field.WAY;
                prevX = -1;
                prevY = -1;
            }
        }
    }
    
    public boolean isGameOverAttacker() {
        if(stepCount == 0) {
            return true;
        }
        return false;
    }
    
    public boolean isGameOverDefender() {
        boolean b = true;
        int x = 0;
        int y = 0;
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(table[i][j] == field.DEFENDER) {
                    x = i;
                    y = j;
                }
            }
        }
        
        for(int ii = -1; ii <= 1; ii++) {
            for(int jj = -1; jj <= 1; jj++) {
                if(!(ii == 0 && jj == 0) &&
                    ((x + ii) >= 0 && (y+jj)>= 0 && (x + ii) < size &&(y+jj) < size)) {
                     b &= table[x+ii][y+jj] == field.ATTACKER;
                }
            }
        }
        return b;
    }
}
