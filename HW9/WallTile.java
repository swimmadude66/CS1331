import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* Class of Tile which blocks movement and spawning. Will not allow Creatures or traps to exist in its location.
* @author Adam Yost
* @version 1
*/

public class WallTile extends Tile {

private static Image i = new ImageIcon("wall.png").getImage();

/**
* Constructor for the WallTile object. Initializes the image as the wall image and passes a Dungeon to its super class
* @param du Dungeon object
*/
	public WallTile(Dungeon du){
		super(du);
		this.img = i;
		}
/**
* update method inherited from superclasses
*/
	public void update(){
	}
	public static void main (String[] args){
	}
}