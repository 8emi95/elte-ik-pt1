package hu.valdar.progtech.zh;

import hu.valdar.progtech.zh.gui.GameFrame;
import hu.valdar.progtech.zh.logic.GameLogic;

public class Boot {

    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(
                () -> new GameFrame(new GameLogic()).setVisible(true)
        );
    }

}
