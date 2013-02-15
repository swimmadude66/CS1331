import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
* Creates a visual representation of a Dungeon using a graphics object, and drawing each element at the location 
* specified by the object's location variables. It also uses a KeyListener to pass commands on to the Dungeon object 
* so that the player and creatures can move around when an arrow key is pressed.
* @author Adam Yost
* @version 1
*/
public class DisplayPanel extends JPanel implements KeyListener{
 
 
public MapGenerator mg = new MapGenerator(); 
public Dungeon d = new Dungeon(mg);
public Player p = d.p;
public FirstEnemy fe = d.fe;
public SecondEnemy se = d.se;

/**
* Constructor for a DisplayPanel object. It adds a KeyListener and sets it as the focus, so that it can accept new
* input.
*/
public DisplayPanel(){
	super();
	addKeyListener(this);
	setFocusable(true);
	requestFocus();
	}

/**
* paint adds the objects in the dungeon to the graphics page at their corresponding locations. This gets called every 
* time the page is repainted, so it must update all the positions and healths of every object prior to drawing them
* so that they are placed correctly.
* @param g a Graphics object on which to draw the dungeon
*/
public void paint(Graphics g){
	super.paint(g);
	for(int x = 0; x<d.map.length; x++){
		for(int y =0; y<d.map[0].length; y++){
			Tile t = d.map[x][y];
			t.update();
			t.draw(g,25,25);
			}
		}
	p.update();
	fe.update();
	se.update();
	p.draw(g,25,25);
	fe.draw(g,25,25);
	se.draw(g,25,25);
	}

/**
* A KeyEvent trigger which was unused in this application, but must be included in order to implement KeyListener.
* @param e a Keyevent
*/
public void keyTyped(KeyEvent e){
}
/**
* A KeyListener method that checks for a pressed key and records the ID of that key. If the ID matches the ID of an arrow
* key, the corresponding movement is called for the player and enemies. The Graphics page must be repainted after each move to
* account for changed positions or tiles.
* @param e a KeyEvent
*/
public void keyPressed(KeyEvent e){
	int id = e.getKeyCode();
	if(p.getX()>0 && p.getY()>0){
		if (id == 37){  //left
			p.moveLeft();	
			fe.move();
			se.move();
			this.repaint();
		}
	else if (id == 38){ //up
		p.moveUp();
		fe.move();
		se.move();
		this.repaint();
	}
	else if (id == 39){ //right
		p.moveRight();
		fe.move();
		se.move();
		this.repaint();
	}
	else if (id == 40){ //down
		p.moveDown();
		fe.move();
		se.move();
		this.repaint();
	}
	else{
	}
}
}
/**
* A KeyEvent trigger which was unused in this application, but must be included in order to implement KeyListener.
* @param e a Keyevent
*/
public void keyReleased(KeyEvent e){
}


public static void main(String[] args){
	}
}


