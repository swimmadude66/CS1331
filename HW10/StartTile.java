import java.util.*;
import javax.swing.*;
import java.awt.*;

//I completed this assignment by myself using only the resources from the textbook and materials

/**
* StartTile class which serves as a placeholder until a new field is generated
* @author Adam Yost
* @version 1
*/
public class StartTile extends Tile{
	
	private Minefield m;

/**
* constructor for the StartTile object. Does nothing but create a concrete version of a Tile.
* @param mf Minefield object
* @param x Integer object
* @param y Integer object
*/
public StartTile(Minefield mf, int x, int y){
		super(new Point(x,y));
		m = mf;
		}
/**
* executes upon click. Does nothing, allows mouseclick to remove starttile
*/ 	
	public void clicked(){
		}
	}