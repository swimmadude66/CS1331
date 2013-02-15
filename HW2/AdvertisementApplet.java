import javax.swing.JApplet;
import java.awt.*;

/**
*This is Homework 2 problem 2
*This creates an advertisement for a fictional product
*I completed this assignment by myself using only the resources from the textbook and materials
**/

public class AdvertisementApplet extends JApplet{
	public void paint (Graphics page){
		
		page.setColor(Color.yellow); //create yellow background
		page.fillRect(0,0,500,350);
		page.setColor(Color.black);
		page.fillRect(0,0,500,50); //stripes
		page.fillRect(0,100,500,50);
		page.fillRect(0,200,500,50);
		page.fillRect(0,300,500,50);
		
		Color front = new Color(100,100,100); //oval color
		page.setColor(front);
		page.fillOval(75,100,350,150);

		page.setColor(Color.white); // text color
		page.drawString("Georgia Tech Yellow Jacket Degrees", 150, 150);
		page.drawLine(150,151,351,151);
		page.drawString("STING 'EM!", 220, 200);
	} //end paint
}//end class