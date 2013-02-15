import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* Compiles a DisplayPanel object and Dungeon object in to a JFrame which can be displayed and used to play the game
* @author Adam Yost
* @version 1
*/

public class DungeonMain{

public static DisplayPanel primary = new DisplayPanel();
public static MapGenerator mg;
public static Dungeon d = primary.d;

	
/**
* Creates a new JFrame, sets the size, adds the display panel, and runs the game in its own window. Allows the game
* to be played by running this main.
*/
public static void main(String[] args){
	JFrame frame = new JFrame("Dungeon Crawler 1.0");
		frame.setPreferredSize(new Dimension(540,560));
	primary = new DisplayPanel();
		primary.setPreferredSize(new Dimension(525,525));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(primary);
	frame.pack();
	frame.setVisible(true);
	}
}