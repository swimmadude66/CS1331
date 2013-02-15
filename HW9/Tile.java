import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* Abstract class which provides some common methods and variables for all tile objects.
* @author Adam Yost
* @version 1
*/
public abstract class Tile extends DungeonElement{
	
	private boolean occ = false;
	private Creature cre;
/**
* Constructor for the Tile object. Passes on a dungeon to the super class DungeonElement.
* @param du Dungeon object
*/
	public Tile(Dungeon du){
		super(du);
	}
/**
* abstract update method for all sub concrete classes
*/
	public abstract void update();
/**
* Concrete draw mathod for subclasses
*/
	public void draw(){
	}
/**
* Sets the Occupied variable of the tile to the boolean value supplied.
* @param o Boolean representing whether or not the tile is occupied
*/	
	public void setOccupied(boolean o){
		occ = o;
		}
/**
* Returns the value of the Occupied variable of the tile object
* @return true if occupied, false if vacant
*/
	public boolean getOccupied(){
		return occ;
		}

/**
* Sets the Creature variable of the Tile to the creature object specified.
* @param c Creature object
*/
	public void setCreature(Creature c){
		cre = c;
	}
/**
* Returns the value of the Creature variable of the tile
* @return Creature object representing the last Creature to occupy that tile
*/
	public Creature getCreature(){
		return cre;
		}
		
	
	public static void main(String[] args){
	}
}
	