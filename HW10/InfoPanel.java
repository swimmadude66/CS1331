import java.util.*;
import javax.swing.*;
import java.awt.*;

//I completed this assignment by myself using only the resources from the textbook and materials

/**
* InfoPanel Class to display Tile and mine counts
* @author Adam Yost
* @version 1
*/

public class InfoPanel extends JPanel{

	private JLabel remain;
	private JLabel flags;
	
	private int rem = 0;
	private int fl = 0;
	
/**
* Constructor for the InfoPanel. Creates 2 new labels and adds in the corresponding data from the minefield
*/	
	
	public InfoPanel(){
		
		remain = new JLabel();
		flags = new JLabel();
		remain.setText(" " +rem+" ");
		flags.setText(" "+fl+" ");		
		add(remain);
		add(flags);
		
		setAlignmentY(Component.TOP_ALIGNMENT);
		
		}
/**
* Setter for the remaining mines
* @param a Integer object
*/
public void setRemain(int a){
	rem = a;
	remain.setText(" "+rem+" ");
	}
/**
* Setter for number of flags
* @param a Integer object
*/
public void setFlags(int a){
	fl = a;
	flags.setText(" "+fl+" ");
	}		
}

		