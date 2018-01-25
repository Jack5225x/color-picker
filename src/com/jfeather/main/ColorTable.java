package com.jfeather.main;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTable;

public class ColorTable extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JPanel dialog = new JPanel();
	
	public static final int MAX_COLORS = 100;
	
	Object[][] data = new Object[MAX_COLORS][3];
	
	String[] columns = {"Name: ", "Hex Code: ", "RGB Code: "};
	
	public JTable colorTable = new JTable(data, columns);
	
	public int colorCount = 1;
	
	public ColorTable() {
		dialog.setPreferredSize(new Dimension(280, 220));
		dialog.setLayout(null);
		
		colorTable.setBounds(0, 0, 280, 220);
		dialog.add(colorTable);
		data[0] = columns;
	}
}
