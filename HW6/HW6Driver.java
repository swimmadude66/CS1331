//I completed this assignment by myself using only the resources from the textbook and materials
import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* This program is the main-class for the Binary Calculator. It creates a frame, adds the necessary functions
* and panels, and presents them. This class essentially just pulls in an object from the other two classes and uses
* them in combination to create a functioning GUI
* @author Adam Yost
* @version 1.0
**/

public class HW6Driver{

/**
* The logic engine for all the mathematical calculations
**/
private static BinaryCalculator bincalc;
/**
* The panel contaiing all buttons, outputs, and actionlisteners
**/
private static CalculatorScreenPanel primary;

public static void main(String[] args){

/**
* JFrame object to hold the CalculatorScreenPanel Object
**/
JFrame sign = new JFrame("TI-1010010"); //Get it? it says TI - 82 in binary
		sign.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bincalc = new BinaryCalculator();
		primary = new CalculatorScreenPanel();
//add the panel
		sign.getContentPane().add(primary);
		sign.pack();
		sign.setVisible(true);
	}
}
