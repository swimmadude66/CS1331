//I completed this assignment by myself using only the resources from the textbook and materials

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* This is Homework 5 part 2. It creates a PetPanel object which accepts a pet object and creates a GUI
* using the attributes from the pet object and updates them based off the buttons pressed
* @author Adam Yost
* @version 1
**/

public class PetPanel extends JPanel implements ActionListener{
	
	private Pet tam;
	private JLabel hun;
	private JLabel ico;
	private JButton feedButton;
	private JButton pokeButton;
	private JButton watchButton;
	private JButton killButton;
	
/**
* constructor for a pet panel that pulls in all necessary data from a given pet
* also adds action listener buttons using the methods from the pet class in an inner class, then refreshes
* the icon and hunger variable
* @param Pet
*/
	public PetPanel(Pet p){
		tam = p;
		setPreferredSize(new Dimension(220,300));
		hun = new JLabel("hunger: " + tam.getHunger());
		ico = new JLabel(tam.getCurrentIcon());
		feedButton = new JButton("feed");
			feedButton.addActionListener(
  				new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
      				tam.feed();
						refresh();
  		 			}
 				}
		);
		pokeButton = new JButton("poke");
			pokeButton.addActionListener(
  				new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
      				tam.poke();
						refresh();
  		 			}
 				}
		);		
		watchButton = new JButton("watch");
			watchButton.addActionListener(
  				new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
      				tam.watch();
						refresh();
  		 			}
 				}
		);
		killButton = new JButton("kill");
			killButton.addActionListener(
  				new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
      				tam.kill();
						refresh();
  		 			}
 				}
		);	
		
		add(hun);
		add(ico);
		add(feedButton);
		add(pokeButton);
		add(watchButton);
		add(killButton);
		}
		
/**
* refreshes the hunger variable in the JLabel
* refreshes the icon to match the cirrent state of the pet
*/
public void refresh(){
	hun.setText("hunger: "+tam.getHunger());
	ico.setIcon(tam.getCurrentIcon());
	}	
			
/**
* overrides the actionPerformed method
* Override actionPerformed
*/

public void actionPerformed(ActionEvent e){
}
			
public static void main (String[] args){
}
}
			
		
		