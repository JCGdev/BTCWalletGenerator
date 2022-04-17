package main.java.gui.mouseDataCapture;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

import main.java.core.utils.InstancesUtil;

public class MouseCapturePanel extends JPanel {

	private JLabel title = new JLabel("Mouse Coordinates Grabber");
	private JButton startButton = new JButton("Start Capture");
	private JButton cleanCapturePanelButton = new JButton("Clear Capture Panel");
	
	private MouseCaptureArea captureArea = new MouseCaptureArea();
	
	private JTextArea helpMessage = new JTextArea ("[ Instructions ] \n"
							   					 + "\n" 
							   					 + "Once you click the start button, \n"
							   					 + "shake your mouse as randomly as possible. \n");
	
	
	private JTextArea mouseDataViewer = new JTextArea ("[ Gathered Data ] \n");

	private JSpinner sizeOfMouseDataArraySpinner = new JSpinner(new SpinnerNumberModel(50, 20, 500, 1));
	private JSpinner timeToWaitBetweenCalculationsSpinner = new JSpinner(new SpinnerNumberModel(500, 100, 1000, 50));

	private MouseCaptureWorker mouseCaptureWorker = new MouseCaptureWorker(this);
	
	
	public MouseCapturePanel() {
		
		this.setLayout(new BorderLayout());
		
		this.title.setFont(new Font("Serif", Font.BOLD, 25));
		
		this.helpMessage.setEditable(false);
		this.mouseDataViewer.setEditable(false);
		
		
		this.setupActionListeners();
		
		JPanel southPanel = this.setupSouthPanel();
		JPanel westPanel = this.setupWestPanel();
		//JPanel eastPanel = this.setupEastPanel();
		
		
		this.add(InstancesUtil.getJPanelInstance(this.title), BorderLayout.NORTH);
		this.add(this.captureArea, BorderLayout.CENTER);
		
		//this.add(eastPanel, BorderLayout.EAST);
		this.add(westPanel, BorderLayout.WEST);
		this.add(southPanel, BorderLayout.SOUTH);
	}
	
	
	
	private void setupActionListeners() {
		
		this.startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MouseCaptureArea captureArea = getCaptureArea();
				MouseCaptureWorker worker = getMouseCaptureWorker();
				
				worker.execute();	
			}
		});
		
		
		this.cleanCapturePanelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getCaptureArea().repaint();
			}
		});
		
		
	}
	
	
	private JPanel setupWestPanel() {
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		
		westPanel.add(this.helpMessage);
		westPanel.add(Box.createVerticalStrut(10));
		westPanel.add(this.mouseDataViewer);
		
		return westPanel;
		
	}
	
	private JPanel setupEastPanel() {
		JPanel eastPanel  = new JPanel();
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		
		Box sizeOfMouseDataArrayBox  = Box.createHorizontalBox();
		sizeOfMouseDataArrayBox.add(InstancesUtil.getJPanelInstance(new JLabel("Doubles Array Size")));
		sizeOfMouseDataArrayBox.add(Box.createVerticalStrut(10));
		sizeOfMouseDataArrayBox.add(InstancesUtil.getJPanelInstance(this.sizeOfMouseDataArraySpinner));
		
		Box timeToWaitBetweenCalculationsBox = Box.createHorizontalBox();
		timeToWaitBetweenCalculationsBox.add(InstancesUtil.getJPanelInstance(new JLabel("Wait time")));
		timeToWaitBetweenCalculationsBox.add(Box.createVerticalStrut(10));
		timeToWaitBetweenCalculationsBox.add(InstancesUtil.getJPanelInstance(this.timeToWaitBetweenCalculationsSpinner));
		
		
		eastPanel.add(sizeOfMouseDataArrayBox);
		eastPanel.add(timeToWaitBetweenCalculationsBox);
		
		return eastPanel;
		
	}
	
	
	private JPanel setupSouthPanel() {
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		
		southPanel.add(this.startButton);
		southPanel.add(this.cleanCapturePanelButton);
		
		return southPanel;
		
	}
	
	
	
	public JLabel getTitle() {
		return this.title;
	}
	
	public MouseCaptureArea getCaptureArea() {
		return this.captureArea;
	}
	
	public JButton getStartButton() {
		return this.startButton;
	}
	
	public JButton getCleanCapturePanelButton() {
		return this.cleanCapturePanelButton;
	}
	
	public JTextArea getMouseDataViewer() {
		return this.mouseDataViewer;
	}
	
	public MouseCaptureWorker getMouseCaptureWorker() {
		return this.mouseCaptureWorker;
	}
		
}
