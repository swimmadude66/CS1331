import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* The Door class creates an object which checks represents a rectangle with a Side object. This is used in the 
* GamePanel object to detect when you need a scene change.
* @author Adam Yost
* @version 1.0
*/

public class Door{
	public enum Side {
		LEFT, RIGHT};
	private Side s;
	private Rectangle r;
	public GameController gc = new GameController();
		
/**
* contructor for the Door Object that takes in a rectangle and Side and establishes that area as a Door
* @param rect a Rectangle object representing the area of the door
* @param si a Side object representing which direction the door takes you
*/		
		
public Door(Rectangle rect, Side si){
		r=rect;
		s = si;
		}
		
/**
* Checks if a given point falls within the Rectangle established by the constructor, and if so, it sends the 
* command to the GameController to change the scene in the direction corresponding to the Side parameter
* @param x integer value of the x coordinate of the checked point
* @param y integer value of the y coordinate of the checked point
*/
	public void check(int x, int y){
		if(r.contains(x,y) == true){
		switch(s){
			case LEFT:
				gc.left();
				break;
			case RIGHT:
				gc.right();
				break;
			}
			}
		}
		
		
	public static void main(String[] args){
		}
	}
				