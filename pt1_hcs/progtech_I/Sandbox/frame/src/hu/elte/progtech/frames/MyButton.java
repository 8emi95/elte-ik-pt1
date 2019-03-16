package hu.elte.progtech.frames;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyButton(String text){
		super(text);
	}
	
	@Override
	public void addActionListener(ActionListener l) {
		// TODO Auto-generated method stub
		super.addActionListener(l);
	}
}
