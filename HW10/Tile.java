import java.util.*;
import javax.swing.*;
import java.awt.*;

//I completed this assignment by myself using only the resources from the textbook and materials

/**
* Tile class to serve as superclass for all tile types, holding all shared variables and methods
* @author Adam Yost
* @version 1
*/

public abstract class Tile{

protected Image i;
protected Point loc;
protected boolean flagged;
protected boolean isClicked;
protected int neighbors;
protected Rectangle checker;
protected int s = 25;

protected Image unclicked = new ImageIcon("unclicked.png").getImage();
protected Image flag = new ImageIcon("flag.png").getImage();

/**
* Constructor for the Tile class, takes in a Point object and stores that as its location. Sets the image of the tile
* to the unclicked image by default, sets up a rectangle to check for clicks, and sets flagged to false
* @param p Oint object
*/

public Tile(Point p){
	i = unclicked;
	loc = p;
	checker = new Rectangle(loc.x*s,loc.y*s, s,s);
	flagged = false;
	}

/**
* Setter for the image of the tile
* @param img Image representing the desired image of the Tile
*/
public void setImage(Image img){
	i = img;
	}
/**
* Getter for the image of the tile
* @return Image object representing the picture assigned to the tile
*/

public Image getImage(){
	return i;
	}

/**
* Setter for the flag variable, determines if the tile has been flagged as a suspecred mine
* @param b Boolean value for if the tile has been flagged
*/
public void setFlag(boolean b){
	flagged = b;
		if (flagged == true){
			i = flag;
			}
		else{
			i = unclicked;
			}
	}
/**
* Getter for the flag variable of the tile
* @return flag variable representing if the Tile has been flagged
*/
public boolean getFlag(){
	return flagged;
	}

/**
* Setter for the location variable 
* @param p a Point variable representing the location
*/

public void setLocation(Point p){
	loc = p;
	}
/**
* Getter for the location variable of the tile
* @return location variable representing the tiles location
*/
	
public Point getLocation(){
	return loc;
	}

/**
* Setter of the neighbor variable
* @param n Integer representing the number of mines near a tile
*/
public void setNeighbors(int n){
	neighbors = n;
	}
/**
* Getter for the neighbor variable
* @return number of mines within the surrounding 8 tiles
*/
public int getNeighbors(){
	return neighbors;
	}

/**
* performs the clicked() function if a click was registered inside the Tiles Check rectangle
* @param p Point object representing the location of the click
*/
public void check(Point p){
	if (checker.contains(p)){
		clicked();
		}
	}
/**
* flags or unflags the tile if a rightclick was registered inside the Tiles Check rectangle
* @param p Point object representing the location of the click
*/
public void rightCheck(Point p){
	if (checker.contains(p)){
		boolean a = getFlag();
		if (a == false){
			setFlag(true);
			}
		else{
			setFlag(false);
			}
		}
	}
/**
* Getter for clicked variable
* @return true if tile has been clicked, false otherwise
*/
public boolean getClicked(){
	return(isClicked);
	}
/**
* draws the tile at the specified size and location
* @param g Graphics Object to be drawn on
*/
public void draw(Graphics g){
		g.drawImage(i, loc.x*s, loc.y*s, s, s, null);
	}
/**
* Abstact method to be executed upon a click, different for every tile type
*/
public abstract void clicked();

}