//I completed this assignment by myself using only the resources from the textbook and materials
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
* This class creates a functioning panel that takes in input via buttons and sends binary strings to the 
* BinaryCalculator methods for use to be operated upon, then returned as strings for display. The input/output
* box will always contain a binary string, while all operations are done in decimal
* @author Adam Yost
* @version 1.0
**/

public class CalculatorScreenPanel extends JPanel implements ActionListener{

/**
* saves the last operator as the state of the calculator
**/
private enum State {
WAITING, ADDING, SUBTRACTING, MULTIPLYING, DIVIDING, TYPING}


	private JButton one;
	private JButton zero;
	private JButton plus;
	private JButton minus;
	private JButton times;
	private JButton divide;
	private JButton equals;
	private JButton clear;
	
/**
* Import BinaryCalculator Object for the arithmetic calculations
**/	
	
	private BinaryCalculator bincalc;
	private JLabel output;
	
	private String lastNumber = "0";
	private String inOut = "0";
	private State current;
	private String solved = "0";
	private Dimension button = new Dimension(62, 125);
	
/**
* Constructor for the Panel object, initializes the variable and sets up the space planning of the panel
* establishes actionlisteners for each button, to assign the appropriate function
**/	
public CalculatorScreenPanel(){
	output = new JLabel("");
	output.setPreferredSize(new Dimension(250,50));
	output.setBackground(Color.WHITE);
	output.setOpaque(true);
	setPreferredSize(new Dimension(275,300));;
	current = State.WAITING;
	
	one = new JButton("1");
		one.setPreferredSize(button);
			one.addActionListener(
  				new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
						output.setText(type1());
  		 			}
 				}
		);	
		
	zero = new JButton("0");
		zero.setPreferredSize(button);
			zero.addActionListener(
  				new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
      				output.setText(type0());
  		 			}
 				}
		);	
		
	plus = new JButton("+");
		plus.setPreferredSize(button);
			plus.addActionListener(
  				new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
						plus();
						refresh();
  		 			}
 				}
		);
	
	minus = new JButton("-");
		minus.setPreferredSize(button);
			minus.addActionListener(
  				new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
						subtract();
						refresh();
  		 			}
 				}
		);
		
	times = new JButton("*");
		times.setPreferredSize(button);
			times.addActionListener(
  				new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
						multiply();
						refresh();
  		 			}
 				}
		);	
		
	divide = new JButton("/");
		divide.setPreferredSize(button);
			divide.addActionListener(
  				new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
						divide();
						refresh();
  		 			}
 				}
		);
	clear = new JButton("CA");
		clear.setPreferredSize(button);
			clear.addActionListener(
  				new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
						clear();
  		 			}
 				}
		);
		
		
	equals = new JButton("=");
		equals.setPreferredSize(button);
			equals.addActionListener(
  				new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
						refresh();
						equal();				
						
						
  		 			}
 				}
		);
	

add(output);

add(one);
add(zero);
add(plus);
add(minus);
add(times);
add(divide);
add(clear);
add(equals);
}

/**
* processes the input with the last operator. Changes function depending on the last operator used.
**/
public void refresh(){
	inOut = output.getText();
	switch(current){
	
	case ADDING:
		solved = BinaryCalculator.add(lastNumber, inOut);
		output.setText("");
		break;	
	case SUBTRACTING:
		solved = BinaryCalculator.subtract(lastNumber,inOut);
		output.setText("");
		break;
	case MULTIPLYING:
		solved = BinaryCalculator.multiply(lastNumber, inOut);
		output.setText("");
		
		break;
	case DIVIDING:
		solved = BinaryCalculator.divide(lastNumber, inOut);
		output.setText("");
		break;
	case WAITING:
		output.setText(solved);
		}
		
		
}
	
/**
* appends a 1 to the end of the binary string present in the input
* starts a new binary string if typed while the output of a previous operation is currently displayed
**/
public String type1(){
	if(current == State.WAITING){
		clear();
		current = State.TYPING;
		}
	else{
	}
		String a = output.getText();
		String b = (a+"1");
	return(b);
	}
/**
* appends a 0 to the end of the binary string present in the input
* starts a new binary string if typed while the output of a previous operation is currently displayed
**/
public String type0(){
	if(current == State.WAITING){
		clear();
		current = State.TYPING;
		}
	else{
	}
	String a = output.getText();
	String b =(a + "0");
	return(b);
	}
/**
* Takes in the number in front of the plus sign so that it can be added in the refresh function
* if there is already a number to be added from a prior operation, it uses that
**/

public void plus(){
	if (lastNumber == "0"){
		lastNumber = output.getText();
	}
	else{
		lastNumber = solved;
		}
	current = State.ADDING;
	}


/**
* Saves the number before the minus sign for use in the refresh function
* if there is already a number to be subtracted, it uses that
**/
public void subtract(){
	if (lastNumber == "0"){
		lastNumber = output.getText();
	}
	else{
		lastNumber = solved;
		}
	current = State.SUBTRACTING;
	}
	
/**
* Saves the number in front of the multiplication symbol for use in the refresh function
* if there is already a number saved from a prior operation, it uses that
**/	
	
public void multiply(){
	if (lastNumber == "0"){
		lastNumber = output.getText();
	}
	else{
		lastNumber = solved;
		}
	current = State.MULTIPLYING;
	}

/**
* Saves the number in front of the division symbol for use in the refresh function
* if there is already a number saved from a prior operation, it uses that
**/	
public void divide(){
	if (lastNumber == "0"){
		lastNumber = output.getText();
	}
	else{
		lastNumber = solved;
		}
	current = State.DIVIDING;
	}
	
/**
* displays the final output from the chain on operation input prior to pressing the equals button.
* requires refresh prior to call
**/
	
public void equal(){
	output.setText(solved);
	current= State.WAITING;
	}

/**
* clears all output and instance variables so that the calculator can return to default state
**/
	
public void clear(){
	output.setText("");
	lastNumber = "0";
	solved = "0";
	current= State.WAITING;
	
	}

public void actionPerformed(ActionEvent e){
}

public static void main (String[] args){
}
}