import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements KeyListener{

	static char output; 
	
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(0,0); //change this for size of popup window
		this.setLayout(null);
		this.addKeyListener(this);
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		output = e.getKeyChar();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		output = e.getKeyChar();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("You released key char: " + e.getKeyChar());
		//System.out.println("You released key code: " + e.getKeyCode());
		output = e.getKeyChar(); 
	}
	
	public static char keyPressed1(KeyEvent e) {
		return output;
	}
	
	public static char keyReleased1() {
		return output;
	}
}
