import java.util.*;
import javax.swing.*;
import java.awt.*;


/**
* Adventure class pulls in a GamePanel Object and a GameController to run it and packs the panel in to a frame so
* that the game can be played.
* @author Adam Yost
* @version 1.0
*/
public class Adventure{
	
	public static GameController gc;
	public static GamePanel gp;
	
/**
* Main method for the adventure class, which allows the Game objects created in the other classes to be packed in to
* a runnable application and executed. It sets the frame size to one slightly larger than the game panel, and adds
* the necessary code to make a frame function.
*/	
	public static void main(String[] args){
	JFrame sign = new JFrame("Escape the Garage");
		sign.setPreferredSize(new Dimension(515, 650));
	gc = new GameController();
	gp = new GamePanel(gc);
	
		sign.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sign.getContentPane().add(gp);
		sign.pack();
		sign.setVisible(true);
		}
	}