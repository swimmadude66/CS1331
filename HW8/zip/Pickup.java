import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* Creates a class of objects known as pickups that can be taken from the scene and added to your inventory.
* Sinces these objects are in the scene images this class uses an enum to tell the object which item to look for
* and add to the inventory once the scene has changed
* @author Adam Yost
* @version 1.0
*/

public class Pickup {

enum Item {
	NOTE, KNIFE, SKEY, DKEY, NONE};
	
private Rectangle r;	
private Item i;
public GameController gc = new GameController();

/**
* Constructor for a pickup object. Takes in a rectangular area and the Item value and sets them in instance variables
* for use in methods below.
* @param rect Rectangle object representing the area of the object
* @param pick Item object representing the type of Item being created
*/
public Pickup (Rectangle rect, Item pick){
		r = rect;
		i = pick;

		}
				
/**
* Checks a point to see if it falls within the area defined by the pickup object, and if so, adds the object to
* inventory and removes it from the Scene
* @param x integer object representing the x coordinate of the checked point
* @param y integer object representing the y coordinate of the checked point
*/
				
	public void check(int x, int y){
		if(r.contains(x, y) == true){
			switch (i){
			case NOTE:
				gc.takeNote();
				gc.setNote(true);
				break;
			case KNIFE:
				gc.takeKnife();
				gc.setKnife(true);
				break;
			case SKEY:
				gc.takeSKey();
				gc.setSKey(true);
				break;
			case DKEY:
				gc.takeKey();
				gc.setKey(true);
				break;
			}
		}
}
public static void main(String[] args){
	}
}

