import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* GamePanel pulls the Gamecontroller, Doors, Pickups, and Breakables together so that they can interact with the
* MouseListener implemented in this class. By placing all the classes which check the clicked point in one class
* which listens for a click, the objects can check if they were selected on every mouse click and react accordingly
* @author Adam Yost
* @version 1.0
*/

public class GamePanel extends JPanel implements MouseListener{
	
	private int x;
	private int y;
	
	private GameController gc;
	public Rectangle leftbox = new Rectangle(0,170,50,145);
	public Rectangle rightbox = new Rectangle(450,170,50,145);
	
	public Door dleft;
	public Door dright;

	JLabel sce;
	
	JLabel notebox = new JLabel("");
	JLabel knifebox = new JLabel("");
	JLabel skeybox = new JLabel("");
	JLabel keybox = new JLabel("");
	Dimension box = new Dimension(100,100);
	
	Breakable br;
	Pickup pu;

/**
* constructor for the GamePanel object. Uses a GameController to source its methods, allowing objects in the panel
* to change scenes or inventory values. It establishes an area for the game map and the inventory screens, adds
* labels to hold those images, then updates them as necessary when a click is made
* @param g GameController object
*/	
public GamePanel(GameController g) {
	gc = g;
	sce = new JLabel(gc.s0);
		sce.setPreferredSize(new Dimension(500,500));
	addMouseListener(this);
	
	notebox.setIcon(gc.inve);
		notebox.setPreferredSize(box);
	knifebox.setIcon(gc.inve);
		knifebox.setPreferredSize(box);
	skeybox.setIcon(gc.inve);
		skeybox.setPreferredSize(box);
	keybox.setIcon(gc.inve);
		skeybox.setPreferredSize(box);
		
	dleft = new Door(leftbox, Door.Side.LEFT);
	dright = new Door(rightbox, Door.Side.RIGHT);
	
	add(sce);
	add(notebox);
	add(knifebox);
	add(skeybox);
	add(keybox);
	}	
/**
* refreshes all images in the labels. This is used after a method that alters a Scene or State value in order to change
* the images to reflect their new conditions.
*/	
public void refresh(){
	sce.setIcon(gc.getScene());
	notebox.setIcon(gc.noteInv());
	knifebox.setIcon(gc.knifeInv());
	skeybox.setIcon(gc.skeyInv());
	keybox.setIcon(gc.keyInv());
	}

/**
* MouseClicked method from the MouseListener Interface. It triggers event e whenever the mouse is clicked.
* In this class, the event set 2 integer values of x and y to the location of the click. It then uses those
* x and y coordinates in combination with the current Scene and State of the Scene to determine if a door, pickup
* or breakable has been clicked. It then refreshes all images to reflect the changes made.
* @param e MouseEvent from which the coordinates are obtained
*/		
public void mouseClicked(MouseEvent e){
		x = e.getX();
		y = e.getY();
		dright.check(x,y);
		dleft.check(x,y);
	
		pu= new Pickup(new Rectangle(0,0,0,0), Pickup.Item.NONE);
		br = new Breakable(new Rectangle(0,0,0,0), Breakable.Place.NONE);
		
		if(gc.current == GameController.Scene.SCENE0 || gc.current == GameController.Scene.SCENE0T || gc.current == GameController.Scene.SCENE0O){
			pu = new Pickup (new Rectangle(29, 60, 91, 100), Pickup.Item.NOTE);
			br = new Breakable(new Rectangle(127,42,223,443), Breakable.Place.DOOR);
			}
		else if (gc.current == GameController.Scene.SCENE1 || gc.current == GameController.Scene.SCENE1T || gc.current == GameController.Scene.SCENE1B){
			if(gc.current == GameController.Scene.SCENE1){
				br = new Breakable(new Rectangle(201,204,103,103), Breakable.Place.WINDOW);
				}
			else if(gc.current == GameController.Scene.SCENE1B){
				pu = new Pickup (new Rectangle(207, 222, 45, 83), Pickup.Item.KNIFE);
				}
			else{
				}
			}
		else if (gc.current == GameController.Scene.SCENE2 || gc.current == GameController.Scene.SCENE2T || gc.current == GameController.Scene.SCENE2B){
			if(gc.current == GameController.Scene.SCENE2){
				br = new Breakable(new Rectangle(112, 101, 264, 267), Breakable.Place.POSTER);
				}
			else if(gc.current == GameController.Scene.SCENE2B){
				pu = new Pickup (new Rectangle(231,209,18,64), Pickup.Item.SKEY);
				}
			else{
				}
			}
		else if (gc.current == GameController.Scene.SCENE3 || gc.current == GameController.Scene.SCENE3T || gc.current == GameController.Scene.SCENE3B){
			if(gc.current == GameController.Scene.SCENE3){
				br = new Breakable(new Rectangle(150,345,168,106), Breakable.Place.SAFE);
				}
			else if (gc.current == GameController.Scene.SCENE3B){
				pu = new Pickup (new Rectangle(224, 418, 35, 29), Pickup.Item.DKEY);
				}
			else{
			}
			
			}
		
		pu.check(x,y);
		br.check(x,y);
		refresh();
	}

/**
* unused method from the MouseListener Interface, left null because it needs to be implemented, but has no use
* in this class.
*/
public void mouseEntered(MouseEvent e){
}
/**
* unused method from the MouseListener Interface, left null because it needs to be implemented, but has no use
* in this class.
*/
public void mouseExited(MouseEvent e){
}
/**
* unused method from the MouseListener Interface, left null because it needs to be implemented, but has no use
* in this class.
*/
public void mousePressed(MouseEvent e){
}
/**
* unused method from the MouseListener Interface, left null because it needs to be implemented, but has no use
* in this class.
*/
public void mouseReleased(MouseEvent e){
}

	public static void main (String[] args){
	}
}