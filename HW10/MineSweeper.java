import java.util.*;
import javax.swing.*;
import java.awt.*;

//I completed this assignment by myself using only the resources from the textbook and materials


/**
* Compiles a DisplayPanel object and Minefield object in to a JFrame which can be displayed and used to play the game
* @author Adam Yost
* @version 1
*/

public class MineSweeper{

public static DisplayPanel primary;
public static Minefield mf;

	
/**
* Creates a new JFrame, sets the size, adds the display panel, and runs the game in its own window. Allows the game
* to be played by running this main.
*/
public static void main(String[] args){
	JFrame frame = new JFrame("Minesweeper");
	JPanel container = new JPanel();
	InfoPanel info = new InfoPanel();
	primary = new DisplayPanel(frame, info);
	mf  = primary.mf;
	JPanel buttons = new MenuPanel(primary);
	
	container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));				
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	container.add(buttons);
	container.add(info);
	container.add(primary);
	frame.getContentPane().add(container);
	frame.pack();
	frame.setVisible(true);
	}
}