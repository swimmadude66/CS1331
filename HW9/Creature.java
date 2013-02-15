import java.util.*;
import java.awt.*;


/**
* Superclass to all Enemys and Players. Subclass of DungeonElement. This assigns a name, damage, health, and Image to
* a DungeonElement object, making it a creature which can move and do damage or be damaged.
* @author Adam Yost
* @version 1
*/
public class Creature extends DungeonElement{

private String name;
private int health;
private int damage;

private Random rnd = new Random();

/**
* Constructor for the Creature object. Takes in a Dungeon object, a damage value and a health value, and sets
* the creature's health and damage respectively.
* @param du Dungeon object
* @param da Integer object representing damage done per attack
* @param h Integer object representing health of Creature
*/

	public Creature(Dungeon du, int da, int h){
	super(du);
	health = h;
	damage = da;
	}
/**
* Update method checks that the creature is still alive, and if not, moves it off screen.
*/	
	public void update(){
	if (health <= 0){
		this.loc = new Point(-100,-100);
		}
	}
/**
* Checks if the tile to the left of the creature is occupied or contains a wall. If it is occupied, the Creature
* attacks the occupant of the tile, and if the tile is a wall, it simply will not move in to that space.
*/	
	public void moveLeft(){
	Tile leftTile = d.map[(this.getX()-25)/25][(this.getY())/25];
		if(leftTile instanceof WallTile){
			}
		else if(leftTile.getOccupied()==true){
			this.attack(leftTile.getCreature());
			}
		else{	
			d.getTile(loc.x/25, loc.y/25).setOccupied(false);
			loc= new Point(loc.x -25, loc.y);
			d.getTile(loc.x/25, loc.y/25).setOccupied(true);
			d.getTile(loc.x/25, loc.y/25).setCreature(this);
		}
	}
/**
* Checks if the tile to the right of the creature is occupied or contains a wall. If it is occupied, the Creature
* attacks the occupant of the tile, and if the tile is a wall, it simply will not move in to that space.
*/	
	public void moveRight(){
	Tile rightTile = d.map[(this.getX()+25)/25][(this.getY())/25];
		if(rightTile instanceof WallTile){
			}
		else if(rightTile.getOccupied()==true){
			this.attack(rightTile.getCreature());
			}
		else{
			d.getTile(loc.x/25, loc.y/25).setOccupied(false);
			loc= new Point(loc.x +25, loc.y);
			d.getTile(loc.x/25, loc.y/25).setOccupied(true);
			d.getTile(loc.x/25, loc.y/25).setCreature(this);
		}
	}
/**
* Checks if the tile above the creature is occupied or contains a wall. If it is occupied, the Creature
* attacks the occupant of the tile, and if the tile is a wall, it simply will not move in to that space.
*/	
	public void moveUp(){
	Tile upTile = d.map[(this.getX())/25][(this.getY()-25)/25];
		if(upTile instanceof WallTile){
			}
		else if(upTile.getOccupied()==true){
			this.attack(upTile.getCreature());
			}
		else{
			d.getTile(loc.x/25, loc.y/25).setOccupied(false);
			loc = new Point(loc.x, loc.y-25);
			d.getTile(loc.x/25, loc.y/25).setOccupied(true);
			d.getTile(loc.x/25, loc.y/25).setCreature(this);
		}
	}
/**
* Checks if the tile below the creature is occupied or contains a wall. If it is occupied, the Creature
* attacks the occupant of the tile, and if the tile is a wall, it simply will not move in to that space.
*/		
	public void moveDown(){
	Tile downTile = d.map[(this.getX())/25][(this.getY()+25)/25];
		if(downTile instanceof WallTile){
			}
		else if(downTile.getOccupied()==true){
			this.attack(downTile.getCreature());
			}
		else{
			d.getTile(loc.x/25, loc.y/25).setOccupied(false);
			loc =new Point(loc.x, loc.y+25);
			d.getTile(loc.x/25, loc.y/25).setOccupied(true);
			d.getTile(loc.x/25, loc.y/25).setCreature(this);
		}
	}
/**
* Attacks a creature specified in the arguments. This attack will subtract the opponent's health by the value stored in
* the damage variable of the attacking creature, then checks the health of the opponent and either kills it, or prints
* the opponents remaining health. There is a 1/25 chance of missing and doing 0 damge.
* @param c Creature object representing the creature to be attacked
*/
	
	public void attack (Creature c){
		int nope = rnd.nextInt(25);
		if(nope != 15){
			c.health -= damage;
			System.out.println(this.name +" Attacked " + c.name + " for " + damage+" damage!");
			checkHealth(c);
			}
		else{
			System.out.println(this.name +" Has attacked " + c.name+ " and missed.");
			}
		}
/**
* Checks the health of a Creature, and either prints the remaining health in a standard format, or removes the creature
* from the dungeon and prints a message notifying the player that the creature has died.
* @param c Creature Object to be checked
*/ 
	public void checkHealth(Creature c){
		if(c.getHealth() >0){
			System.out.println(c.name +" Has " + c.health + " health remaining.");
			}
		else if(c.getHealth() <= 0){
			System.out.println(c.name + " Has Died!");
			Tile t = d.map[c.getX()/25][c.getY()/25];
			t.setOccupied(false);
		}
		}
/**
* Sets the health of the Creature to the supplied value
* @param h Integer object representing the deisred health value
*/
	public void setHealth(int h){
		health = h;
		}
/**
* Returns the current value of the health variable of the creature
* @return health value
*/
	public int getHealth(){
		return health;
		}
/**
* Returns the String stored in the name variable of the Creature
* @return name
*/
	public String getName(){
		return name;
		}
/**
* Sets the name variable to the supplied string
* @param s String value of the new name
*/
	public void setName(String s){
		name = s;
		}
	
	public static void main(String[] args){
	}
}