import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* FloorTile subclass which adds a win condition to the game. If the player navigates to an instance of this object, 
* the game is won, and a console print statement notifies the player of such
* @author Adam Yost
* @version 1
*/

public class ExitTile extends FloorTile {


private static Image i = new ImageIcon("exit.png").getImage();

/**
* Constructor for the ExitTile class, which sets the image and passes a dungeon to its superclass
* @param du Dungeon object
*/
	public ExitTile(Dungeon du){
		super(du);
		super.img = i;
		}
/**
* Checks if the ExitTile contains a player, and if so, prints the Win statement
*/
	public void update(){
		if (this.getOccupied() == true){
			if (getCreature() instanceof Player){
				System.out.println("You Win!");
				}
			}
	}
	public static void main (String[] args){
	}
}