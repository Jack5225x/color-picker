package com.jfeather.ColorSchemes;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

public class ColorGen {

	public static Random rand = new Random();
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(monoGen(new Color(150, 150, 0))));
	}
	
	public static Color[] monoGen(Color c) {
		
		Color[] colorScheme = new Color[5];
		
		boolean dark = false;
		//Decide whether to go light or dark
		int lightOrDark = rand.nextInt(2);
		if (lightOrDark == 0)
			dark = true;
		//The number of colors in the same family as the original
		int numPrimary = rand.nextInt(3) + 2;
		
		//The number of complementary colors (gray, white, black, etc.)
		int numComplementary = 5 - numPrimary;
		
		String base = getBaseColor(c);
		
		if (dark) {
			int shade = 0;
			for (int i = 0; i < numComplementary; i++) {
				shade = rand.nextInt(150);
				colorScheme[i] = new Color (shade, shade, shade);
			}
			
			switch (base) {
			
				case "Red":
					for (int j = numComplementary; j < 5; j++) { //Minus 1 because the original color counts as one
						colorScheme[j] = new Color(rand.nextInt(155)+100, rand.nextInt(70), rand.nextInt(70));
					}
					break;

				case "Blue":
					for (int j = numComplementary; j < 5; j++) { //Minus 1 because the original color counts as one
						colorScheme[j] = new Color(rand.nextInt(70), rand.nextInt(70), rand.nextInt(155)+100);
					}
					break;

				case "Green":
					for (int j = numComplementary; j < 5; j++) { //Minus 1 because the original color counts as one
						colorScheme[j] = new Color(rand.nextInt(70), rand.nextInt(155)+100, rand.nextInt(70));
					}
					break;

				case "Neutral":
					for (int j = numComplementary; j < 5; j++) { //Minus 1 because the original color counts as one
						colorScheme[j] = new Color(rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
					}
					break;

				
			}
			
		} else {
			int shade = 0;
			for (int i = 0; i < numComplementary; i++) {
				shade = rand.nextInt(100)+155;
				colorScheme[i] = new Color (shade, shade, shade);
			}
			
			switch (base) {
			
				case "Red":
					for (int j = numComplementary; j < 5; j++) { //Minus 1 because the original color counts as one
						colorScheme[j] = new Color(rand.nextInt(155)+100, rand.nextInt(70), rand.nextInt(70));
					}
					break;

				case "Blue":
					for (int j = numComplementary; j < 5; j++) { //Minus 1 because the original color counts as one
						colorScheme[j] = new Color(rand.nextInt(70), rand.nextInt(70), rand.nextInt(155)+100);
					}
					break;

				case "Green":
					for (int j = numComplementary; j < 5; j++) { //Minus 1 because the original color counts as one
						colorScheme[j] = new Color(rand.nextInt(70), rand.nextInt(155)+100, rand.nextInt(70));
					}
					break;

				case "Neutral":
					for (int j = numComplementary; j < 5; j++) { //Minus 1 because the original color counts as one
						colorScheme[j] = new Color(rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));
					}
					break;

				
			}

		}
		
		return colorScheme;
		
	}
	
	public static String getBaseColor(Color c) {
		/*
		 * Returns:
		 * Red
		 * Blue
		 * Green
		 * Neutral
		 */
		
		if (c.getRed() > c.getBlue() && c.getRed() > c.getGreen())
			return "Red";
		if (c.getGreen() > c.getBlue() && c.getGreen() > c.getRed())
			return "Green";
		if (c.getBlue() > c.getRed() && c.getBlue() > c.getGreen())
			return "Blue";
		return "Neutral";
	}
}
