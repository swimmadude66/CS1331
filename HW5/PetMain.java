//I completed this assignment by myself using only the resources from the textbook and materials

import java.util.*;
import javax.swing.*;
import java.awt.*;


/**
* This is Homework 5 part 3. It brings together the petpanel in a JFrame such that the GUI pops up and can be 
* manipulated
* @author Adam Yost
* @version 1
**/
public class PetMain{

	private static Pet p;
	private static PetPanel primary;
	
/**
* main function
* creates a JFrame, and fills it with a PetPanel created according to a pet object
*/
	public static void main(String[] args){
		JFrame sign = new JFrame("My Pet");
		sign.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new Pet();
		primary = new PetPanel(p);
		sign.getContentPane().add(primary);
		sign.pack();
		sign.setVisible(true);
		
	}
}