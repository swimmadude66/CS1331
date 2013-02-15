import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* The first enemy class that will follow the player around and try to attack. This enemy is a dragon, which does
* 10 damage and has 10 health.
* @author Adam Yost
* @version 1
*/

public class FirstEnemy extends Creature{
	
	private Image i = new ImageIcon("first.png").getImage();
	private Player p;
	
/**
* Constructor for the FirstEnemy class. Takes in a Dungeon and a Player Object. Passes commands to the dungeon object
* and follows the player. Sets the name to Dragon, and the image to the enemy picture.
* @param du Dungeon object
* @param pl Player object
*/
	public FirstEnemy(Dungeon du, Player pl){
		super(du, 10, 10);
		super.img = i;
		super.setName("Dragon");
		p = pl;
		}
	
/**
* Move uses the findX() and findY() functions to determine whic direction will bring the enemy close to the player,
* then executes a move in that direction.
*/
	public void move(){
	if(getHealth() >0){
		int xm = findX();
		int ym = findY();
		
		if(xm<0){
			if(ym<0){
				if(xm>ym){
					moveUp();
					}
				else if(ym>xm){
					moveLeft();
					}
				}
			else if(ym>0){
				if(-1*xm>ym){
					moveLeft();
					}
				else if(-1*xm<ym){
					moveDown();
					}
				}
			}
		else if(xm>0){
			if(ym<0){
				if(xm>-1*ym){
					moveRight();
					}
				else if(xm<-1*ym){
					moveUp();
					}
				}
			else if(ym>0){
				if(xm>ym){
					moveRight();
					}
				else if(xm<ym){
					moveDown();
					}
				}
			}
		else if(xm==0){
			if(ym>0){
				moveDown();
				}
			else if(ym<0){
				moveUp();
				}
			}
			
		else if(ym==0){
			if(xm>0){
				moveRight();
				}
			else if(xm<0){
				moveLeft();
				}
			}
		}
	}
					
				
/**
* Finds the distance on the x axis between the player and the enemy.
* @return an integer representing the x-distance between the 2 objects
*/
	public int findX(){
		int xp = p.getX();  
		int xe = this.getX();
		return xp-xe;                  //positive = move right
		}
/**
* Finds the distance on the y axis between the player and the enemy.
* @return an integer representing the y-distance between the 2 objects
*/		
	public int findY(){
		int yp = p.getY();
		int ye = this.getY();
		
		return yp-ye;                  //positive = move down
		}
	
public static void main(String[] args){
	}
}
	
	
		
		
		