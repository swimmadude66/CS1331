import java.util.*;
import javax.swing.*;
import java.awt.*;

//I completed this assignment by myself using only the resources from the textbook and materials

/**
* BlankTile class to fill in tiles which have no mines in the surrounding 8 tiles
* @author Adam Yost
* @version 1
*/

public class BlankTile extends Tile{

private Image empty = new ImageIcon("blank.png").getImage();
private Minefield field;
private Tile[][] map;

/**
* Constructor for the BlankTile
* @param mf Minefield object
* @param x Integer object
* @param y Integer object
*/
public BlankTile(Minefield mf, int x, int y){
	super(new Point(x,y));
	map = mf.grid;
	neighbors = 0;
	}

/**
* function to be executed on click. Changes the image to the blank image, and executes the clicked() function on all
* surrounding tiles, creating a recursive expansion on surrounding blank tiles
*
* I'm pretty proud of this one...
*
*/
public void clicked(){
	i = empty;
	isClicked = true;
	int x = getLocation().x;
	int y = getLocation().y;
	
	if(y-1>=0){
		Tile top = map[x][y-1];
			if (top.isClicked == false){
			top.clicked();
			}
		}
	if(x-1>=0 && y-1 >=0){
		Tile topleft = map[x-1][y-1];
		if (topleft.isClicked == false){
			topleft.clicked();
			}
		}
	if(x+1 <map.length && y-1 >=0){
		Tile topright = map[x+1][y-1];
		if (topright.isClicked == false){
			topright.clicked();
			}
		}
	if(x-1>=0){
		Tile left = map[x-1][y];
		if (left.isClicked == false){
			left.clicked();
			}
		}
	if(x+1 <map.length){
		Tile right = map[x+1][y];
		if (right.isClicked == false){
			right.clicked();
			}
		}
	if(y+1<map[x].length){
		Tile bottom = map[x][y+1];
			if (bottom.isClicked == false){
				bottom.clicked();
				}
		}
	if(x-1>=0 && y+1<map[x].length){
		Tile bottomleft = map[x-1][y+1];
			if (bottomleft.isClicked == false){
				bottomleft.clicked();
				}
		}
	if(x+1<map.length && y+1<map[x].length){
		Tile bottomright = map[x+1][y+1];
			if (bottomright.isClicked == false){
				bottomright.clicked();
			}
		}
	else{
		}
	}
}
	
	