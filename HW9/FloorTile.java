import java.util.*;
import javax.swing.*;
import java.awt.*;

/**to 
* This class is a type of Tile which permits movement and is suitable for Creatures to fight upon.
* @author Adam Yost
* @version 1
*/
public class FloorTile extends Tile {

private static Image i = new ImageIcon("floor.png").getImage();

/**
* Constructor for the floortile object. Sets the image to the floor image, and passes a dungeon object to its Superclass
* @param du Dungeon object
*/
	public FloorTile(Dungeon du){
		super(du);
		this.img = i;
		}
/**
* Update method to be passed down to subclasses
*/
	public void update(){
	}
	public static void main (String[] args){
	}
}