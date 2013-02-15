//I completed this assignment by myself using only the resources from the textbook and materials

import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* This is Homework 5 part 1. It creates a Pet object with attributes to be accessed by the PetPanel class
* @author Adam Yost
* @version 1
**/


public class Pet{
//imports the random generator for the watch function
	Random rnd = new Random();
//enum states list for the icons
	private enum State{
		SLEEPING, EATING, DEAD, LAUGHING, NORMAL
	}
	

	private int hunger = 10;
	private State current;
	private ImageIcon sleep;
	private ImageIcon eat;
	private ImageIcon dead;
	private ImageIcon laugh;
	private ImageIcon norm;
	private final int FULL = 10;
	
/**
* constructor for a new pet object
* establishes all icons, states, and a hunger variable
*/	
	public Pet(){
		sleep = new ImageIcon("sleeping.png");
		eat =new ImageIcon("eating.png");
		dead= new ImageIcon("dead.png");
		laugh = new ImageIcon("laughing.png");
		norm= new ImageIcon("normal.png");
		
		current = State.NORMAL;
		hunger = 10;
}
/**
* Sets the hunger variable to the number specified in the arguments
* @param integer
*/	
	
public void setHunger(int n){
	hunger = n;
}

/**
* returns the current hunger level as an integer
* @return integer
*/
public int getHunger(){
	return(hunger);
}

/**
* Returns an ImageIcon object containing the current icon based off the state of the pet
* @return Icon
*/ 

public ImageIcon getCurrentIcon(){
	
	if (current == State.SLEEPING){
		return(sleep);
		}
	else if (current == State.EATING){
		return (eat);
		}
	else if (current == State.DEAD){
		return(dead);
		}
	else if (current == State.LAUGHING){
		return(laugh);
		}		
	else {
		return(norm);
		}
}

// Button Functions


/**
* pokes the pet, deprecating its hunger and making it laugh
* if this starves the pet it kills it
* if the animal is dead it does nothing
*/
public void poke(){
	if (current == State.DEAD){
		}
	else{
		current = State.LAUGHING;
		hunger -=1;
	}
	checkForStarvation();
}
	
/**
* feeds the pet, restoring its hunger variable to maximum
* if the pet is already full, it kills the pet
* if the animal is dead it does nothing
*/
	
public void feed(){
	if (current == State.DEAD){
		}
	else if(hunger == FULL || current == State.EATING ){
		current = State.DEAD;
		}
	else{
	current = State.EATING;
	hunger = FULL;
	}
}

/**
* puts the pet to sleep, causing no effect to the hunger variable but changing the state and icon
* if the animal is dead it does nothing
*/
public void sleep(){
	if (current == State.DEAD){
		}
	else{
		current = State.SLEEPING;
		}
}

/**
* returns the pet to its normal state and lowers its hunger variable
* if this starves the pet, it kills the pet
* if the animal is dead it does nothing
*/

public void sit(){
	if (current == State.DEAD){
		}
	else{
		current = State.NORMAL;
		hunger -=1;
		}
	checkForStarvation();
}

/**
* randomly calls sleep, poke, or sit on the pet
*/

public void watch(){
	int st=rnd.nextInt(3);
	if (st == 0){
		poke();
		}
	else if (st==1){
		sleep();
		}
	else{
		sit();
		}
}
/**
* kills the pet, so no other action will be performed
*/

public void kill(){
	current=State.DEAD;
	}

/**
* evaluates if the hunger variable of the pet is set to zero
* if so, it kills the pet
*/
public void checkForStarvation(){
	if (hunger == 0){
		current = State.DEAD;
		}
	else{
	}
}
	
	
public static void main(String[] args){
	
		}
	}
	
