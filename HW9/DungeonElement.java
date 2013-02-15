import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* DungeonElement is an abstract superclass to all Creatures and Tiles. It contains all the shared methods and
* variables that the subclasses will use, so as to reduce the need for repeated methods, and maintain a consistent
* variable name across implementations.
* @author Adam Yost
* @version 1
*/
public abstract class DungeonElement{

	public Point loc;
	public Image img;
	public Dungeon d;
	
/**
* Constructor for the DungeonElement class. Requests a Dungeon object so that it can pass dungeon commands from its
* subclasses and allow interaction between elements in the same dungeon.
* @param du Dungeon object
*/
	public DungeonElement(Dungeon du){
		d = du;
	}
/**
* Abstract update method to be used in the concrete subclasses
*/
	public abstract void update();

/**
* Draws the DungeonElement on the graphics page supplied with the given width and height. It uses a graphics method
* called drawImage() which takes in an image, location, and width and height to draw the image of the element at the
* location stored by the element, using the supplied width and height.
* @param g Graphics object
* @param w Integer Object representing desired width of the image
* @param h Intger Object representing the desired height of the image
*/
	public void draw(Graphics g, int w, int h){
		g.drawImage(this.img, loc.x, loc.y, w, h, null);
	}
	
/**
* Returns the X coordinate of the elements location on the graphics page
* @return an integer representing the X coordinate of the elements location
*/
	public int getX(){
		return loc.x;
		}
/**
* Returns the Y coordinate of the elements location on the graphics page
* @return an integer representing the Y coordinate of the elements location
*/		
		public int getY(){
		return loc.y;
		}
	
	public static void main(String[] args){
	}
}