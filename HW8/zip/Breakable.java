import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* Breakable creates a type of object necessary for the extra credit and the win condition. It uses a rectangle
* similar to the pickup and doors, to define where the interactive element will be. It then uses a predefined
* set of methods in the GameController class to change the scene to one in which the object (specified by the Place
* object) is broken or open.
* @author Adam yost
* @version 1.0
*/

public class Breakable {
	
	enum Place {
		WINDOW, POSTER, SAFE, DOOR, NONE};
		
	public GameController gc = new GameController();
	private Place p;
	Rectangle r;
	
/**
* constructor for the Breakable object. Uses a Rectangle object and one of the Place values to define where and what
* the breakable object is.
* @param rect Rectangle object representing the area of the Scene that will change when the object is broken
* @param pl Place object telling the object what GameController method to call when it is broken
*/	
public Breakable(Rectangle rect, Place pl){
		r= rect;
		p = pl;
		}
		
/**
* checks if a point falls within the rectangle defined in the constructor of the Breakable object. If it is, it 
*executes the method necessary based off the Place object
* @param x integer object representing the x coordinate of the point
* @param y integer object representing the y coordinate of the point
*/
	public void check(int x, int y){
		if(r.contains(x,y) == true){
		switch(p){
			case WINDOW:
				gc.breakWindow();
				break;
			case POSTER:
				if(gc.kn == true){
				gc.breakPoster();
				}
				else{
				break;
				}
				break;
			case SAFE:
				if(gc.sk == true){
				gc.breakSafe();
				}
				else{
				break;
				}
				break;
			case DOOR:
				if(gc.ke == true){
				gc.openDoor();
				}
				else{
				break;
				}
				break;
			}
			}
		}
	
public static void main(String[] args){
	}
}	