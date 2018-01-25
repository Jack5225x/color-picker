package com.jfeather.Other;

import java.awt.Color;

public class HexToRGB {

	public static Color hexToRgb(String colorStr) {
	    return new Color(
	            colorStr.substring( 1, 3 ),
	            colorStr.substring( 3, 5 ),
	            colorStr.substring( 5, 7 ));
	}

	
}
