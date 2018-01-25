package com.jfeather.ColorSchemes;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorDisplay extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JPanel dialog = new JPanel();
	
	public JButton color1 = new JButton();
	public JButton color2 = new JButton();
	public JButton color3 = new JButton();
	public JButton color4 = new JButton();
	public JButton color5 = new JButton();
	public JButton color6 = new JButton();

	
	public ColorDisplay() {
		dialog.setPreferredSize(new Dimension(500, 100));
		dialog.setLayout(null);
		
		color1.setBounds(10, 15, 80, 60);
		color2.setBounds(90, 15, 80, 60);
		color3.setBounds(170, 15, 80, 60);
		color4.setBounds(250, 15, 80, 60);
		color5.setBounds(330, 15, 80, 60);
		color6.setBounds(410, 15, 80, 60);

		color1.setEnabled(false);
		color2.setEnabled(false);
		color3.setEnabled(false);
		color4.setEnabled(false);
		color5.setEnabled(false);
		color6.setEnabled(false);
		
		dialog.add(color1);
		dialog.add(color2);
		dialog.add(color3);
		dialog.add(color4);
		dialog.add(color5);
		dialog.add(color6);

	}
}

	
