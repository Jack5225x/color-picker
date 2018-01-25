package com.jfeather.main;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

import javax.swing.JToggleButton;
import java.awt.Toolkit;

import com.jfeather.ColorSchemes.*;
import com.jfeather.Other.*;

public class GameWindow extends JFrame implements MouseListener {

	//TODO pick color schemes based on one selected color (idk how yet)
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JPanel contentPane = new JPanel();
	public static JPanel screenPane = new JPanel(new BorderLayout());
	public JTextField colorOutput;
	public static JMenuBar menuBar = new JMenuBar();
	public static GameWindow frame = new GameWindow();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setJMenuBar(menuBar);
					frame.setTitle("Color Picker");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	
	Robot bot;
	
	boolean lfColor = false;
		
	public JToggleButton btnSelectColor = new JToggleButton("Select Color");
	
	public JButton btnColorDisplay = new JButton(), btnSave = new JButton("<html>&#128190</>");;
	
	public JLabel image, rgbCode = new JLabel();
	
	Screenshot sc = new Screenshot();
	
	public GameWindow() {
				
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
			JMenuItem mnitmQuit = new JMenuItem("Quit");
			mnFile.add(mnitmQuit);
			
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
			JRadioButtonMenuItem mnitmDebug = new JRadioButtonMenuItem("Debug");
			mnEdit.add(mnitmDebug);
			
			JMenuItem mnitmScheme = new JMenuItem("Generate color scheme");
			mnEdit.add(mnitmScheme);
			
			JMenuItem mnitmTable = new JMenuItem("Saved colors");
			mnEdit.add(mnitmTable);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setPreferredSize(new Dimension(350, 120));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.requestFocus();
		//contentPane.addMouseListener(this);
		//contentPane.setBackground(new Color(255, 0, 0));
		sc.addMouseListener(this);
		pack();
		
		btnSelectColor.setBounds(25, 25, 120, 25);
		contentPane.add(btnSelectColor);
				
		btnSave.setBounds(300, 25, 40, 25);
		contentPane.add(btnSave);
		
		rgbCode.setBounds(1,1,20,20);
		contentPane.add(rgbCode);
		rgbCode.setVisible(false);
		
		btnColorDisplay.setBounds(25, 60, 265, 25);
		contentPane.add(btnColorDisplay);
		btnColorDisplay.setEnabled(false);
		btnColorDisplay.setForeground(new Color(0, 255, 0));
		btnColorDisplay.setBackground(new Color(0, 255, 0));
		
		colorOutput = new JTextField();
		colorOutput.setBounds(160, 25, 130, 25);
		contentPane.add(colorOutput);
		colorOutput.setColumns(10);
				
		pack();
		
		
		try {
			bot = new Robot();
		} catch (AWTException ex ) {
			ex.printStackTrace();
		}
		
		mnitmQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		ColorSchemePanel csp = new ColorSchemePanel();
		JPanel colorDialog = new JPanel();
		colorDialog.add(csp.dialog);
		
		ColorDisplay cd = new ColorDisplay();
		JPanel colorDisplayDialog = new JPanel();
		colorDisplayDialog.add(cd.dialog);
		
		ColorTable ct = new ColorTable();
		JPanel colorTableDisplay = new JPanel();
		colorTableDisplay.add(ct.dialog);
		
		pack();
		
		mnitmScheme.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ok = JOptionPane.showConfirmDialog(null, colorDialog, "Color Select", JOptionPane.PLAIN_MESSAGE);
				Color c = new Color(0, 0, 0);
				if (ok == JOptionPane.OK_OPTION) {
					if (csp.btnPrevColor.isSelected()) {
						c = GetRGB.parseRGB(rgbCode.getText());
					} else {
						if (csp.btnNewColor.isSelected()) {
							if (csp.btnRed.isSelected())
								c = csp.btnRed.getBackground();
							if (csp.btnOrange.isSelected())
								c = csp.btnOrange.getBackground();
							if (csp.btnOrangeYellow.isSelected())
								c = csp.btnOrangeYellow.getBackground();
							if (csp.btnYellow.isSelected())
								c = csp.btnYellow.getBackground();
							if (csp.btnBrightYellow.isSelected())
								c = csp.btnBrightYellow.getBackground();
							if (csp.btnYellowGreen.isSelected())
								c = csp.btnYellowGreen.getBackground();
							if (csp.btnGreen.isSelected())
								c = csp.btnGreen.getBackground();
							if (csp.btnCyan.isSelected())
								c = csp.btnCyan.getBackground();
							if (csp.btnBlue.isSelected())
								c = csp.btnBlue.getBackground();
							if (csp.btnIndigo.isSelected())
								c = csp.btnIndigo.getBackground();
							if (csp.btnViolet.isSelected())
								c = csp.btnViolet.getBackground();
							if (csp.btnPurple.isSelected())
								c = csp.btnPurple.getBackground();
						}
					}
					//System.out.println(c);
					
					Color[] scheme = ColorGen.monoGen(c);
					
					cd.color1.setBackground(c);
					cd.color2.setBackground(scheme[0]);
					cd.color3.setBackground(scheme[1]);
					cd.color4.setBackground(scheme[2]);
					cd.color5.setBackground(scheme[3]);
					cd.color6.setBackground(scheme[4]);
					
					JOptionPane.showMessageDialog(null, colorDisplayDialog, "Color Scheme", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		mnitmTable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, colorTableDisplay, "Saved Colors", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Enter a custom name: ");
				
				String[] data = {name, colorOutput.getText(), GetRGB.rgbToString(rgbCode.getText())};
				ct.data[ct.colorCount] = data;
				ct.colorCount++;
			}
		});
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		sc.contentPane.setPreferredSize(new Dimension((int)screenSize.getWidth(), (int)screenSize.getHeight()));
		sc.contentPane.requestFocus();
		pack();
				
		btnSelectColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!lfColor) {
					lfColor = true;
					btnSelectColor.setText("Selecting...");
					
					try {
						//TODO make sure this actually updates the picture

						Rectangle screenRect = new Rectangle(screenSize);
						
						//long systemTime = System.currentTimeMillis();
						String fileName = "image/screenshot" /*+ systemTime */+ ".png";
						File scs = new File(fileName);
						
						//Rectangle screenRect = new Rectangle(screenSize);
						//Rectangle screenRect = new Rectangle(new Dimension((int)screenSize.getWidth(), (int)screenSize.getHeight()));
						//The problem is most likely right here, with this not being redefined
						RenderedImage capture = bot.createScreenCapture(screenRect);
						ImageIO.write(capture, "png", scs);
						
						//ImageIcon testImage = new ImageIcon("image/test.jpg");
						ImageIcon img = new ImageIcon(fileName);

						JLabel image = new JLabel(img, JLabel.CENTER);
						//JLabel image = new JLabel(testImage, JLabel.CENTER);
						
						//System.out.println(screenRect.getSize());
						
						sc.contentPane.add(image);
						//sc.contentPane.setBackground(new Color(255, 0, 0));
						scs.deleteOnExit();
						
					} catch(Exception ex) {
						ex.printStackTrace();
					}
					
					sc.setVisible(true);
				}
			
			}
		});
				
		mnitmDebug.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (mnitmDebug.isSelected()) {
					contentPane.setPreferredSize(new Dimension(315, 250));
				} else {
					contentPane.setPreferredSize(new Dimension(315, 100));
				}
				pack();
			}
		});
				
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if (lfColor) {
			Color rgb = bot.getPixelColor(e.getX(), e.getY());
			String rgbHex = Long.toHexString(rgb.getRed()) + Long.toHexString(rgb.getGreen()) + Long.toHexString(rgb.getBlue()) ;
			//System.out.println(rgb);
			
			rgbCode.setText(rgb+"");
			colorOutput.setText(rgbHex);
			btnColorDisplay.setBackground(rgb);
			
			//Clear up some stuff so its reusable
			lfColor = false;
			btnSelectColor.setText("Select Color");
			btnSelectColor.setSelected(false);
			sc.dispose();
		}
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

