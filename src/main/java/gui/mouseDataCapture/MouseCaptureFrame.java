package main.java.gui.mouseDataCapture;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MouseCaptureFrame extends JFrame {
	
	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	
	private int xpos = (int) screen.getWidth()/4;
	private int ypos = (int) screen.getHeight()/4;
	
	private int height = (int) screen.getHeight()/2;
	private int width = (int) screen.getWidth()/2;
	
	private MouseCapturePanel panel;
	
	public MouseCaptureFrame() {
		this.setTitle("Random Seed Provider");
		this.setBounds(xpos, ypos, this.width, this.height);
		
		
		this.panel = new MouseCapturePanel();
		this.add(panel);
	}

	
	public MouseCapturePanel getPanel() {
		return this.panel;
	}
	
}
