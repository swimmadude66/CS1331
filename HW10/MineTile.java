import java.util.*;
import javax.swing.*;
import java.awt.*;

//I completed this assignment by myself using only the resources from the textbook and materials

/**
* MineTile class to represent mines in the field and cause a lose-situation if clicked
* @author Adam Yost
* @version 1
*/

public class MineTile extends Tile{
	private Minefield field;
	private Tile[][] map;
	private Image mi = new ImageIcon("mine.png").getImage();
	private Image mir = new ImageIcon("mineclicked.png").getImage();
	
/**
* Constructor for the Minetile which takes in a Minefield to pass commands, an x, and a y coordinate of the mine
* @param mf Minefield object
* @param x Integer object
* @param y Integer object
*/	
	
public MineTile(Minefield mf, int x, int y){
		super(new Point(x,y));
		field = mf;
		map = field.grid;
		}
/**
* function to execute upon a click, loses game, reveals mines, and sets clicked mine to red.
*/	
	public void clicked(){
		isClicked = true;
		for (int a = 0; a<map.length; a++){
			for(int b = 0; b<map[a].length; b++){
				if (map[a][b] instanceof MineTile){
					map[a][b].setImage(mi);
					}
				}
			}
		i = mir;
		field.setOver(true);
		}
	
}