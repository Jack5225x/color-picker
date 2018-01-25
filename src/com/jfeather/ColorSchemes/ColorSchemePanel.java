package com.jfeather.ColorSchemes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.jfeather.Other.*;

public class ColorSchemePanel {

	public JPanel dialog = new JPanel();
	
	public JToggleButton btnPrevColor = new JToggleButton("Use current color");
	
	public JToggleButton btnNewColor = new JToggleButton("Select new color");
	
	public ButtonGroup colorSelect = new ButtonGroup();
	
	public JToggleButton btnRed = new JToggleButton();
	public JToggleButton btnOrange = new JToggleButton();
	public JToggleButton btnOrangeYellow = new JToggleButton();
	public JToggleButton btnYellow = new JToggleButton();
	public JToggleButton btnBrightYellow = new JToggleButton();
	public JToggleButton btnYellowGreen = new JToggleButton();
	public JToggleButton btnGreen = new JToggleButton();
	public JToggleButton btnCyan = new JToggleButton();
	public JToggleButton btnBlue = new JToggleButton();
	public JToggleButton btnIndigo = new JToggleButton();
	public JToggleButton btnViolet = new JToggleButton();
	public JToggleButton btnPurple = new JToggleButton();
	
	public ButtonGroup colors = new ButtonGroup();
	
	public ColorSchemePanel() {
		
		dialog.setPreferredSize(new Dimension(320, 240));
		dialog.setLayout(null);
		btnPrevColor.setBounds(0, 20, 145, 30);
		dialog.add(btnPrevColor);
		
		btnNewColor.setBounds(165, 20, 145, 30);
		dialog.add(btnNewColor);
		
		colorSelect.add(btnNewColor);
		colorSelect.add(btnPrevColor);
		
		colors.add(btnRed);
		colors.add(btnOrange);
		colors.add(btnOrangeYellow);
		colors.add(btnYellow);
		colors.add(btnBrightYellow);
		colors.add(btnYellowGreen);
		colors.add(btnGreen);
		colors.add(btnCyan);
		colors.add(btnBlue);
		colors.add(btnIndigo);
		colors.add(btnViolet);
		colors.add(btnPurple);
		
		btnRed.setBounds(45, 70, 50, 40);
		btnOrange.setBounds(100, 70, 50, 40);
		btnOrangeYellow.setBounds(155, 70, 50, 40);
		btnYellow.setBounds(210, 70, 50, 40);
		
		btnBrightYellow.setBounds(45, 115, 50, 40);
		btnYellowGreen.setBounds(100, 115, 50, 40);
		btnGreen.setBounds(155, 115, 50, 40);
		btnCyan.setBounds(210, 115, 50, 40);
		
		btnBlue.setBounds(45, 160, 50, 40);
		btnIndigo.setBounds(100, 160, 50, 40);
		btnViolet.setBounds(155, 160, 50, 40);
		btnPurple.setBounds(210, 160, 50, 40);
		
		btnRed.setBackground(new Color(254,0,0));
		btnOrange.setBackground(new Color(255, 121, 0));
		btnOrangeYellow.setBackground(new Color(255, 186, 0));
		btnYellow.setBackground(new Color(255, 222, 0));
		btnBrightYellow.setBackground(new Color(252, 255, 0));
		btnYellowGreen.setBackground(new Color(210, 255, 0));
		btnGreen.setBackground(new Color(5, 191, 0));
		btnCyan.setBackground(new Color(1, 192, 167));
		btnBlue.setBackground(new Color(6, 0, 255));
		btnIndigo.setBackground(new Color(103, 0, 191));
		btnViolet.setBackground(new Color(149, 0, 192));
		btnPurple.setBackground(new Color(191, 0, 153));
		
		dialog.add(btnRed);
		dialog.add(btnOrange);
		dialog.add(btnOrangeYellow);
		dialog.add(btnYellow);
		dialog.add(btnBrightYellow);
		dialog.add(btnYellowGreen);
		dialog.add(btnGreen);
		dialog.add(btnCyan);
		dialog.add(btnBlue);
		dialog.add(btnIndigo);
		dialog.add(btnViolet);
		dialog.add(btnPurple);
		
		btnNewColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnNewColor.isSelected()) {
					
					btnRed.setEnabled(true);
					btnOrange.setEnabled(true);
					btnOrangeYellow.setEnabled(true);
					btnYellow.setEnabled(true);
					btnBrightYellow.setEnabled(true);
					btnYellowGreen.setEnabled(true);
					btnGreen.setEnabled(true);
					btnCyan.setEnabled(true);
					btnBlue.setEnabled(true);
					btnIndigo.setEnabled(true);
					btnViolet.setEnabled(true);
					btnPurple.setEnabled(true);

				}
			}
		});
		
		btnPrevColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (btnPrevColor.isSelected()) {
					
					btnRed.setEnabled(false);
					btnOrange.setEnabled(false);
					btnOrangeYellow.setEnabled(false);
					btnYellow.setEnabled(false);
					btnBrightYellow.setEnabled(false);
					btnYellowGreen.setEnabled(false);
					btnGreen.setEnabled(false);
					btnCyan.setEnabled(false);
					btnBlue.setEnabled(false);
					btnIndigo.setEnabled(false);
					btnViolet.setEnabled(false);
					btnPurple.setEnabled(false);

				}
			}
		});
		
	}
}
