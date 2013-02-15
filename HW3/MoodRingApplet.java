import javax.swing.JApplet;
import java.util.*;
import java.awt.*;

/**
* This is Homework 3 problem 2. It creates an applet that generates a randomly sized and colored "mood ring"
* in the center of a square applet window. 
**/

//I completed this assignment by myself using only the resources from the textbook and materials

public class MoodRingApplet extends JApplet {
	public void paint (Graphics page) {
		
		Dimension appletSize = this.getSize();
		int h = appletSize.height;
		int w = appletSize.width;
		
		int m = Math.min(w,h);
		
		page.fillRect(0,0,w,h);
		
		Random rnd = new Random();
		int rad = rnd.nextInt(m/4)+(m/8); //generates a random radius within the window
		
		int r = rnd.nextInt(256);
		int g = rnd.nextInt(256);
		int b = rnd.nextInt(256);
		
		Color c = new Color(r,g,b); //new random color
		
		page.setColor(c);
		
		page.fillOval((w/2)-rad, (h/2)-rad , 2*rad, 2*rad); //draws a centered oval of random radius
		
		Color black = new Color(0,0,0);
		
		page.setColor(black);
		
		page.fillOval((w/2)-(rad-10), (h/2)-(rad-10) , 2*(rad-10), 2*(rad-10)); //creates internal circle to form ring
		
		
		}// end paint
		
	}// end class		
	