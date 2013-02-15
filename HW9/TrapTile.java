import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* Traptile is a subclass of floortile which has special function. When a creature steps onthe trap tile, it triggers,
* causing damage and disabling the trap.
* @author Adam Yost
* @version 1
*/
public class TrapTile extends FloorTile {

Image i = new ImageIcon("trap.png").getImage();
private int set = 0;

/**
* Constructor for the TrapTile that takes in a Dungeon Object and sets the image of the tile to the trap image.
* @param du Dungeon object
*/
	public TrapTile(Dungeon du){
		super(du);
		super.img =i;
		}
/**
* update method for the trap waits until a creature moves into the tile, then triggers on the creature, 
* causing damage.
*/
	public void update(){
	if(this.getOccupied() == true){
		trigger(this.getCreature());
		}
	}
	
/**
* triggers the trap on a creature. It checks if it has been triggered before, and if not, it causes 5 damage to
* whatever creature is on the tile. It then deactivates the trap and turns it into a normal floortile.
* @param c Creature object
*/
	public void trigger(Creature c){
		if (set == 0){		
		c.setHealth(c.getHealth() -5);
		System.out.println(c.getName() +" Has taken 5 damage");
		c.checkHealth(c);
		set+=1;
		super.img = new ImageIcon("floor.png").getImage();
		}
	}
	
	public static void main (String[] args){
	}
}