/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aknakereso.model;

import java.util.Random;

/**
 *
 * @author thalyzsofia
 */

public class Engine {
    public enum field {
        FIELD, BOMB;
    }

    private field[][] table;
    private int size;
    private int life;
    int remainSteps = 2;

    public Engine() {}

    public void newGame(int size) {
        this.size = size;

        if(size == 9) {
            this.life = 2;
            this.remainSteps = 2;

            table = new field[size][size];
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    table[i][j] = field.FIELD;
                }
            }

            for(int i = 0; i < size; i++) {
                int remainBombs = 2;
                for(int j = 0; j < size; j++) {
                    if(remainBombs > 0) {
                        int random = new Random().nextInt(size);
                        if(table[i][random] != field.BOMB) {
                           table[i][random] = field.BOMB;
                            remainBombs--; 
                        }
                    }
                }
            }
        }

        if(size == 12) {
            this.life = 3;
            this.remainSteps = 3;

            table = new field[size][size];
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    table[i][j] = field.FIELD;
                }
            }

            for(int i = 0; i < size; i++) {
                int remainBombs = 4;
                for(int j = 0; j < size; j++) {
                    if(remainBombs > 0) {
                        int random = new Random().nextInt(size);
                        if(table[i][random] != field.BOMB) {
                            table[i][random] = field.BOMB;
                            remainBombs--; 
                        }
                    }
                }
            }
        }
    }

    public field getField(int x, int y) {
        return this.table[x][y];
    }

    public int getSize() {
        return this.size;
    }

    public int getLife() {
        return this.life;
    }

    public int getRemainSteps() {
        return this.remainSteps;
    }

    public boolean isGameOverLife() {
        if(life == 0) {
            return true;
        }
        return false;
    }

    public boolean isGameOverWin(){
        if(life > 0 && remainSteps == 0) {
            return true;
        }
        return false;
    }

    public void step(int x, int y) {
        if(table[x][y] == field.BOMB) {
            life--;
            remainSteps--;
        }
        if(table[x][y] == field.FIELD) {
            remainSteps--;
        }
    }

    public void remainStepRepair() {
        if(size == 9) {
            if(remainSteps == 0) {
                remainSteps = 2;
            }
        }

        if(size == 12) {
            if(remainSteps == 0) {
                remainSteps = 3;
            }
        }
    }
}
