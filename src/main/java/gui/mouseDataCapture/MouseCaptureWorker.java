package main.java.gui.mouseDataCapture;

import java.awt.MouseInfo;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MouseCaptureWorker extends SwingWorker<Double[], Double>{
	
	private static Logger logger = LogManager.getLogger(MouseCaptureWorker.class.getName());
	
	private int doubleArraySize = 50;
	private int timeToSleepBetweenCalculation = 500;
	
	MouseCapturePanel parent;
	
	public MouseCaptureWorker(MouseCapturePanel parent) {
		this.parent = parent;
	}
	
	@Override
	protected Double[] doInBackground() throws Exception {
		logger.info("Mouse data gathering worker started");
		Double[] mouseData = new Double[this.doubleArraySize];
		
		for(int i=0 ; i<mouseData.length ; i++) {

			double xpos = MouseInfo.getPointerInfo().getLocation().getX();
			double ypos = MouseInfo.getPointerInfo().getLocation().getY();
			
			mouseData[i] = xpos * ypos * Math.PI;
			
			JTextArea dataViewer = this.parent.getMouseDataViewer();
			dataViewer.setText(dataViewer.getText() + "\n" + mouseData[i]);
			
			this.parent.repaint();
			this.handledSleep(this.timeToSleepBetweenCalculation);
			
		}
		
		return mouseData;
		
	}
	
	
	@Override 
	protected void done() {
		logger.info("Mouse data gathering finished");
		JOptionPane.showMessageDialog(null, "gathering finished!");
		
	}
	

	
	public Double[] getResults() {
		Double[] data = null;
		
		try {
			data = this.get();
		} catch (Exception e) { e.printStackTrace(); } 
		
		return data;
	}
	
	
	
	
	public void setDoubleArraySize(int size) {
		this.doubleArraySize = size;
	}
	
	public void setTimeToSleep(int ms) {
		this.timeToSleepBetweenCalculation = ms;
	}
	
	public int getDoubleArraySize() {
		return this.doubleArraySize;
	}
	
	public int getTimeToSleep() {
		return this.timeToSleepBetweenCalculation;
	}
	
	
	
	public void handledSleep(int ms) {
		try {
			Thread.sleep(ms);
		}catch(Exception e) {e.printStackTrace();}
	}
		
	
	
}
