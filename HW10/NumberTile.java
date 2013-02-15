import java.util.*;
import javax.swing.*;
import java.awt.*;

//I completed this assignment by myself using only the resources from the textbook and materials

/**
* Number Tile class to handle all clicks that are not blank or mines. Clicking reveals a number representing the
* number of surrounding mines
* @author Adam Yost
* @version 1
*/

public class NumberTile extends Tile{
	
private Image one = new ImageIcon("1.png").getImage();
private Image two = new ImageIcon("2.png").getImage();
private Image three = new ImageIcon("3.png").getImage();
private Image four = new ImageIcon("4.png").getImage();
private Image five = new ImageIcon("5.png").getImage();
private Image six = new ImageIcon("6.png").getImage();
private Image seven = new ImageIcon("7.png").getImage();
private Image eight = new ImageIcon("8.png").getImage();

/**
* Constructor for the numbertile, sets location and number of neighboring mines
* @param mf Minefield object
* @param x Integer object representing x coordinate
* @param y Integer object representing y coordinate
* @param n Integer object representing neighboring mines
*/
public NumberTile(Minefield mf,int x, int y, int n){
	super(new Point(x,y));
	neighbors = n;
	}

/**
* function to be executed upon click, changes the image to a number representing the number of neighbors
*/
public void clicked(){
	isClicked = true;
	if(this.getNeighbors() == 1){
		i = one;
		}
	else if(this.getNeighbors() == 2){
		i = two;
		}
	else if(this.getNeighbors() == 3){
		i = three;
		}
	else if(this.getNeighbors() == 4){
		i = four;
		}
	else if(this.getNeighbors() == 5){
		i = five;
		}
	else if(this.getNeighbors() == 6){
		i = six;
		}
	else if(this.getNeighbors() == 7){
		i = seven;
		}
	else if(this.getNeighbors() == 8){
		i = eight;
		}
	}
	
}