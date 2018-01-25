package com.jfeather.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Screenshot extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public static Screenshot frame = new Screenshot();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 **/
	
	public Screenshot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setUndecorated(true);
	    addMouseListener(this);
	    //contentPane.setOpaque(false);
	    contentPane.setBackground(new Color(0, 0, 0, 0));
	    
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		contentPane.setPreferredSize(new Dimension((int)screenSize.getWidth(), (int)screenSize.getHeight()));
		contentPane.requestFocus();
		pack();
				
		Robot bot;
		
		/*
		try {
			
			bot = new Robot();
			
			String fileName = "image/screenshot-"+ System.currentTimeMillis() +".png";
			File scs = new File(fileName);
			
			//TODO: For some reason this isn't getting the proper image, just repeating an old one
			//Rectangle screenRect = new Rectangle(screenSize);
			Rectangle screenRect = new Rectangle(new Dimension((int)screenSize.getWidth(), (int)screenSize.getHeight()));
			BufferedImage capture = bot.createScreenCapture(screenRect);
			ImageIO.write(capture, "png", scs);
			
			ImageIcon img = new ImageIcon(fileName);
			
			JLabel image = new JLabel(img, JLabel.CENTER);
			
			System.out.println(screenRect.getSize());
			
			contentPane.add(image);
			//contentPane.setBackground(new Color(255, 0, 0));
			scs.deleteOnExit();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//frame.dispose();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
