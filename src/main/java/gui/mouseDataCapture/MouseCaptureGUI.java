package main.java.gui.mouseDataCapture;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MouseCaptureGUI {
	public static MouseCaptureFrame frame = null;
	
	
	public static void createIstanceInEDT() {
			
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				frame = new MouseCaptureFrame();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
		});
		
		return;
		
	}
	
	
	public static MouseCaptureFrame getInstance() {
		return frame;
	}
	
	public static boolean instanceIsNotNull() {
		return frame != null;
	}
	
}
