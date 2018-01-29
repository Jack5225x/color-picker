package com.jfeather.main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ColorTable extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JPanel dialog = new JPanel();
	
	public static final int MAX_COLORS = 100;
	
	Object[][] data = new Object[MAX_COLORS][3];
	
	String[] columns = {"Name: ", "Hex Code: ", "RGB Code: "};
	
    DefaultTableModel model = new DefaultTableModel();
	
	public JTable colorTable = new JTable(data, columns);
	
	public JButton btnReset = new JButton("Reset"), btnDelete = new JButton("Delete");
	
	public int colorCount = 1;
	
	public ColorTable() {
		dialog.setPreferredSize(new Dimension(280, 220));
		dialog.setLayout(null);
		
		
	    model.setDataVector(data, columns);
		colorTable.setBounds(0, 0, 280, 185);
		dialog.add(colorTable);
		data[0] = columns;
		
		btnReset.setBounds(30, 190, 100, 25);
		dialog.add(btnReset);
		
		btnDelete.setBounds(150, 190, 100, 25);
		dialog.add(btnDelete);
		
		try {
			FileReader fileReader = new FileReader("SavedColors.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			FileReader fileReader2 = new FileReader("ColorCount.txt");
			BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

			colorCount = Integer.parseInt(bufferedReader2.readLine());
			System.out.println(colorCount);
			int i = 1;
			while (i < MAX_COLORS) {
				String[] readIn = {bufferedReader.readLine(), bufferedReader.readLine(), bufferedReader.readLine()};
				data[i] = readIn;
				i++;
			}
			
			fileReader.close();			
			bufferedReader.close();
			bufferedReader2.close();
		} catch (IOException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "I/O Error!");
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Corrupt or invalid save file! \n Overwriting now...");
			
			try {
					
				FileWriter fileWriter = new FileWriter("ColorCount.txt", false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				
				bufferedWriter.write("0");
				
				bufferedWriter.close();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "I/O Error!");
			}

		}
		
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorCount = 1;
				//Arrays.fill(data, null);
				//data[0] = columns;
				//System.out.println(Arrays.toString(data));
				
				//Reset the text files
				try {
					FileWriter fileWriter = new FileWriter("SavedColors.txt", false);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					
					FileWriter fileWriter2 = new FileWriter("ColorCount.txt", false);
					BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
					
					FileReader fileReader = new FileReader("SavedColors.txt");
					BufferedReader bufferedReader = new BufferedReader(fileReader);
										
					while (bufferedReader.readLine() != null) {
						bufferedWriter.newLine();
					}
					
					bufferedWriter2.write("1");
					
					bufferedReader.close();
					bufferedWriter.close();
					bufferedWriter2.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
		});
	}
	
	public void saveColor(String[] data) {
		try {
			FileWriter fileWriter = new FileWriter("SavedColors.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(data[0]);
			bufferedWriter.newLine();
			bufferedWriter.write(data[1]);
			bufferedWriter.newLine();
			bufferedWriter.write(data[2]);
			bufferedWriter.newLine();
			
			saveColorCount();
			
			bufferedWriter.close();
		} catch (IOException e) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error trying to write data to SavedColors.txt!");
		}
	}
	
	public void saveColorCount() {
		try {
			FileWriter fileWriter = new FileWriter("ColorCount.txt", false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(""+(colorCount));
			
			bufferedWriter.close();
		} catch (IOException e) {
			
		}
	}
}
