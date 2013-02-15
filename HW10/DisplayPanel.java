import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//I completed this assignment by myself using only the resources from the textbook and materials

/**
* DisplayPanel class to show the game and listen for clicks and right clicks
* @author Adam Yost
* @version 1
*/


public class DisplayPanel extends JPanel implements MouseListener{


private FieldGenerator fg;
public Minefield mf;
private InfoPanel ip;
private Tile[][] map;
public int s = 25;
private int clickCount = 0;
private JFrame frame;


private Image i = new ImageIcon("unclicked.png").getImage();

private int w;
private int h;
private int mines;

private int total;
private int done = 0;
private int flags = 0;

/**
* Constructor for the Display panel, which triggers functions in a minefield and passed on commands to a supplied
* infopanel and JFrame by listening for mouse Events.
* @param jf JFrame object
* @param in InfoPanel object
*/
public DisplayPanel(JFrame jf, InfoPanel in){
	frame = jf;
	ip = in;
	newGame();	
	addMouseListener(this);
	}
/**
* prompts the user to supply a width via swing pop up, then stores the supplied input as a width variable
*/
public void promptWidth(){
	int wi = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tiles wide"));
	setWi(wi);
	}
/**
* prompts the user to supply a height via swing pop up, then stores the supplied input as a height variable
*/	
public void promptHeight(){
	int he = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tiles tall"));
	setHe(he);
	}
/**
* prompts the user to supply a number of mines via swing pop up, then stores the supplied input in the mines variable
*/
public void promptMines(){
	int mi = Integer.parseInt(JOptionPane.showInputDialog("Enter number of mines"));
	mines = mi;
	}
/**
* Getter for the height
* @return the height of the grid
*/
public int getHe(){
	return h;
	}
/**
* Settter for the height
* @param a the height of the grid
*/
public void setHe(int a){
	h = a;
	}
/**
* Getter for the width
* @return the width of the grid
*/
public int getWi(){
	return w;
	}
/**
* Setter for the width
* @param a the width of the grid
*/
public void setWi(int a){
	w = a;
	}	
/**
* creates a new game by prompting for the variables, setting the sizes of frames and panels resets all variables
*/
public void newGame(){
	promptWidth();
	promptHeight();
	promptMines();
	
	
	this.setPreferredSize(new Dimension(w*s,h*s));
	this.setMinimumSize(new Dimension(w*s,h*s));
	this.setMaximumSize(new Dimension(w*s,h*s));
	
	ip.setPreferredSize(new Dimension(w*s,25));
	ip.setMinimumSize(new Dimension(225,25));
	ip.setMaximumSize(ip.getPreferredSize());
	

	//frame.setResizable(false);
	
	clickCount =0;
	fg= new FieldGenerator();
	mf = new Minefield(fg, w, h);
	mf.setOver(false);
	mf.setMines(mines);
	total = (w*h) - mines;
	ip.setRemain(total);
	ip.setFlags(mines);
	
	frame.setPreferredSize(new Dimension((Math.max(w*s+ 25,225)),h*s+ 100));
	frame.setMinimumSize(new Dimension((Math.max(w*s+ 25,225)),h*s+ 100));
	frame.setMaximumSize(frame.getPreferredSize());
	
	setAlignmentY(Component.TOP_ALIGNMENT);
	}
/**
* paints the Graphics component by executing the draw function of each tile at the location corresponding to the
* tiles location
* @param g Graphics object
*/	
public void paint(Graphics g){
	super.paint(g);
	flags = 0;
	for(int x = 0; x<w; x++){
		for(int y =0; y<h; y++){
			Tile t = mf.getTile(x,y);
			if(mf.getTile(x,y).getFlag() == true){
				flags +=1;
			}
			t.draw(g);
			}
		}
	ip.setFlags(mines - flags);
	}

/**
* Sets the clickcount
* @param a Integer for the number of clicks
*/
public void setClickCount(int a){
	clickCount =a;
	}

/**
* Establishes what happens when a mouse click is registered. Takes the point of mouseclick and checks if the click
* was on any of the tiles, and executes clicked() on whichever one was clicked.
* @param e MouseEvent
*/
public void mouseClicked(MouseEvent e){
	Point p = e.getPoint();
	if (mf.getOver() == false){
		if(clickCount ==0){
			mf.fillIn(p.x/s,p.y/s);
			}
			if(e.isMetaDown()){
				for(int a = 0; a<mf.grid.length; a++){
					for(int b =0; b<mf.grid[a].length; b++){
						mf.getTile(a,b).rightCheck(p);
							}
						}
				}
			else{
				done = 0;
				for(int a = 0; a<mf.grid.length; a++){
					for(int b =0; b<mf.grid[a].length; b++){
						mf.getTile(a,b).check(p);
						if(mf.getTile(a,b).getClicked() == true){
							done+= 1;
							}
						}
					}
				ip.setRemain(total - done);
				}
clickCount+=1;
repaint();

if(mf.getTile(p.x/s, p.y/s) instanceof MineTile){
	if(e.isMetaDown()){
	}
	else{
	int n =JOptionPane.showConfirmDialog(null, "You Lose, Play Again?", "Failure", JOptionPane.YES_NO_OPTION);
	
	if(n == 0){
		newGame();
		repaint();
		}	
	}
}
if(done == total){
	mf.setOver(true);
	int n =JOptionPane.showConfirmDialog(null, "YOU WIN! Play Again?", "Victory!",JOptionPane.YES_NO_OPTION );
	
	if(n == 0){
		newGame();
		repaint();
	}
	
	}

}
}
/**
* flags an unflagged mine for the player
*/
public void hint(){
	if(mf.getOver() == false){
	boolean found = false;
	for (int a = 0; a<mf.grid.length; a++){
		for (int b = 0; b<mf.grid[a].length; b++){
			if (found == false){
				if (mf.getTile(a,b) instanceof MineTile){
					if(mf.getTile(a,b).flagged == false){
						mf.getTile(a,b).setFlag(true);
						found = true;
						}
					}
				}
			}
		}
	}
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
}

