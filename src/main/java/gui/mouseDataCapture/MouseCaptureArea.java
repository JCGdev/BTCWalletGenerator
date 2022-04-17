package main.java.gui.mouseDataCapture;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MouseCaptureArea extends JPanel {
	
	public MouseCaptureArea() {
		this.setBackground(new Color(216, 215, 214));
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(mouseLocation, this);
		
		int xpos = (int) mouseLocation.getX();
		int ypos = (int) mouseLocation.getY();
		
		
		g2.setColor(Color.RED);
		g2.fillOval(xpos, ypos, 10, 10);
		
	}

}
