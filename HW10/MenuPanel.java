import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//I completed this assignment by myself using only the resources from the textbook and materials

/**
* MenuPanel class to show the buttons for creating a new game and hinting at a mine
* @author Adam Yost
* @version 1
*/
public class MenuPanel extends JPanel implements ActionListener{
	
	private DisplayPanel dp;
	private Minefield mf;
	
/**
* constructor for the MenuPanel object, which holds two buttons, one for a new game, and another for hint
* @param d DisplayPanel object to pass comands to
*/
public MenuPanel(DisplayPanel d){
	dp = d;
	mf = dp.mf;
		JButton newGame = new JButton("New Game");
			newGame.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dp.newGame();
						dp.repaint();
						}
				}
			);
		JButton hint = new JButton("Hint");
			hint.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						dp.hint();
						dp.repaint();
						}
					}
				);

add(newGame);
add(hint);

setPreferredSize(new Dimension(dp.getWi()*dp.s,75));
setMinimumSize(new Dimension(dp.getWi()*dp.s,25));
//setMaximumSize(new Dimension(dp.getWi()*dp.s,75));

			}
			
public void actionPerformed(ActionEvent e){
}			
			
			
}
						
		