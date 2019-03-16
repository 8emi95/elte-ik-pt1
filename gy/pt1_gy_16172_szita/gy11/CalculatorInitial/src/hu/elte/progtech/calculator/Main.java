package hu.elte.progtech.calculator;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new CalculatorFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

}
