package com.jfeather.Other;

import java.awt.Color;

public class GetRGB {

	public static void main(String[] args) {
		System.out.println(parseRGB("java.awt.Color[r=0,g=255,b=0]"));
	}
	
	public static Color parseRGB(String str) {
		int r = 0, g = 0, b = 0; 
		int index = 0;
		int index2 = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i+1).equals("=")) {
				index = i;
				break;
			}
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i+1).equals(",")) {
				index2 = i;
				r = Integer.parseInt(str.substring(index + 1, i));
				break;
			}
		}
		
		for (int i = index + 1; i < str.length(); i++) {
			if (str.substring(i, i+1).equals("=")) {
				index = i;
				break;
			}
		}
		for (int i = index2 + 1; i < str.length(); i++) {
			if (str.substring(i, i+1).equals(",")) {
				index2 = i;
				g = Integer.parseInt(str.substring(index + 1, i));
				break;
			}
		}
		
		for (int i = index + 1; i < str.length(); i++) {
			if (str.substring(i, i+1).equals("=")) {
				index = i;
				break;
			}
		}
		
		for (int i = index2 + 1; i < str.length(); i++) {
			if (str.substring(i, i+1).equals(",")) {
				g = Integer.parseInt(str.substring(index + 1, i));
				break;
			}
		}

		return new Color(r, g, b);
	}
	
	public static String rgbToString(String str) {
		int r = 0, g = 0, b = 0; 
		int index = 0;
		int index2 = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i+1).equals("=")) {
				index = i;
				break;
			}
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i+1).equals(",")) {
				index2 = i;
				r = Integer.parseInt(str.substring(index + 1, i));
				break;
			}
		}
		
		for (int i = index + 1; i < str.length(); i++) {
			if (str.substring(i, i+1).equals("=")) {
				index = i;
				break;
			}
		}
		for (int i = index2 + 1; i < str.length(); i++) {
			if (str.substring(i, i+1).equals(",")) {
				index2 = i;
				g = Integer.parseInt(str.substring(index + 1, i));
				break;
			}
		}
		
		for (int i = index + 1; i < str.length(); i++) {
			if (str.substring(i, i+1).equals("=")) {
				index = i;
				break;
			}
		}
		
		for (int i = index2 + 1; i < str.length(); i++) {
			if (str.substring(i, i+1).equals(",")) {
				g = Integer.parseInt(str.substring(index + 1, i));
				break;
			}
		}

		return "("+r+", "+g+", "+b+")";
	}

}

	
