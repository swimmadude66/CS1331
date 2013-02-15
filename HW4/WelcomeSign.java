import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* This is Homework 4 problem 2. It creates a welcome sign object in the form of a Jframe with a panel for the
* String version of the location object from problem 1
**/

//I completed this assignment by myself using only the resources from the textbook and materials


public class WelcomeSign{
/**
* Location object
**/
	private Location place;
/**
* JFrame Object to store the data for the welcome sign
**/
	private static JFrame sign = new JFrame("Welcome");
	
/**
* Constructor for a welcomeSign object that accepts a location and parses for the City and abbreviated state
* @param Location
**/

public WelcomeSign(Location pl){
	sign.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JPanel primary = new JPanel();
	
	JLabel label1 = new JLabel("Welcome to...");
	String txt = Location.toString(pl);
	JLabel label2 = new JLabel(txt);
	
	primary.add(label1);
	primary.add(label2);
	
	label1.setFont(new Font("Arial", Font.ITALIC, 15));
	label2.setFont(new Font("Times New Roman", Font.BOLD, 25));
	primary.setBorder(BorderFactory.createLineBorder(Color.red, 5));
	
	primary.setPreferredSize(new Dimension(200,75));
		
	sign.getContentPane().add(primary);
	sign.pack();
	sign.setVisible(false);
}//end constructor

/**
* gets the JFrame variable from the Welcome sign object to be used in the visibility setting function
* @return JFrame
**/

public JFrame getJframe(){
	return(sign);
}

/**
* shows the sign made by the constructor
**/

public static void showWelcomeSign(){
	sign.setVisible(true);
}
	 
public static void main(String[] args){
	//----------------------------------------
	//I Used the main method to test each function
	//----------------------------------------
	Location pl = new Location("atlanta","gEORgia");
	WelcomeSign test = new WelcomeSign(pl);
	showWelcomeSign();
	
}//end main
}//end class