import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* Player object is a subclass of Creature which creates a controllable Creature.
* @author Adam Yost
* @version 1
*/
public class Player extends Creature{

/**
* Constructor for the Player object that takes in a Dungeon object and sets the damage and health of the creature
* and sets the name to hero. It also initializes the picture to the picture of the samurai.
* @param du Dungeon object
*/
public Player(Dungeon du){
	super(du,5, 50);
	super.setName("Hero");
	this.img = new ImageIcon("player.png").getImage();
	}


public static void main(String[] args){
	}
}