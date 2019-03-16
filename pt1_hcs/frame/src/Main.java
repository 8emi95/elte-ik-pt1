import java.awt.FlowLayout;

import hu.elte.progtech.frames.MyButton;
import hu.elte.progtech.frames.MyFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame mf1 = new MyFrame();
		
		mf1.getContentPane().setLayout(new FlowLayout());;
		mf1.getContentPane().add(new MyButton("button"));
		mf1.getContentPane().add(new MyButton("button"));
	}

}
