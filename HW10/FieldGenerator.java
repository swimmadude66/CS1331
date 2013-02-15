import java.util.*;
import javax.swing.*;
import java.awt.*;

//I completed this assignment by myself using only the resources from the textbook and materials

/**
* FieldGenerator object that creates a representation of a minefield in characters. The inputs supplied generate a
* full minefield, with the given width, height and character representations
* @author Adam Yost
* @version 1
*/


public class FieldGenerator{

private int sizeX;
private int sizeY;


private static char[][] charfield;
private static final Random rnd = new Random();

/**
* Getter for the character field
* @return a 2d Array filled with characters that represent a Tile Object
*/
public char[][] getCharField(){
	return charfield;
	}	
	
/**
* Generates a field with the given specifications. 
* @param x Integer object representing the width of the field
* @param y Integer object representing the height of the field
* @param minechar Character object used to represent a mine
* @param blank Character object used to represenr a blank tile
* @param nummine Integer object representing the max number of mines
* @param initialX Integer object representing the x coordinate of the first click
* @param initialY Integer object representing the y coordinate of the first click
*/
public static void generateField(int x, int y, char minechar, char blank, int nummine, int initialX, int initialY){
	int mines =0;
	charfield = new char[x][y];
	int mineCount = nummine;
	while(mines<mineCount){
		int xmine = rnd.nextInt(x);
		int ymine = rnd.nextInt(y);
		if(charfield[xmine][ymine] == minechar){
			}
		else if(xmine == initialX && ymine == initialY){
		}
		else{
			charfield[xmine][ymine] = minechar;
			mines+=1;
			}
		}
			
	
	for (int a = 0; a<charfield.length; a++){
		for(int b = 0; b<charfield[a].length; b++){
			int neighbors = 0;
			if(charfield[a][b] != minechar){
			if(a-1>=0 && b-1>=0){
				if(charfield[a-1][b-1] == minechar){
					neighbors+=1;
					}
				}
			if(b-1>=0){
				if(charfield[a][b-1] == minechar){
					neighbors +=1;
					}
				}
			if(a+1<charfield.length && b-1>=0){
				if(charfield[a+1][b-1] == minechar){
					neighbors +=1;
					}
				}
			if(a-1>=0){
				if(charfield[a-1][b] == minechar){
					neighbors +=1;
					}
				}
			if(a+1<charfield.length){
				if(charfield[a+1][b] == minechar){
					neighbors +=1;
					}
				}
			if(a-1>=0 && b+1<charfield[a].length){
				if(charfield[a-1][b+1] == minechar){
					neighbors +=1;
					}
				}
			if(b+1<charfield[a].length){
				if(charfield[a][b+1] == minechar){
					neighbors +=1;
					}
				}
			if(a+1<charfield.length && b+1 <charfield[a].length){
				if(charfield[a+1][b+1] == minechar){
					neighbors +=1;
					}
				}
			if(neighbors != 0){
				if (neighbors == 1){
					charfield[a][b] = '1';
					}
				if (neighbors == 2){
					charfield[a][b] = '2';
					}
				if (neighbors == 3){
					charfield[a][b] = '3';
					}
				if (neighbors == 4){
					charfield[a][b] = '4';
					}
				if (neighbors == 5){
					charfield[a][b] = '5';
					}
				if (neighbors == 6){
					charfield[a][b] = '6';
					}
				if (neighbors == 7){
					charfield[a][b] = '7';
					}
				if (neighbors == 8){
					charfield[a][b] = '8';
					}
				}
			else{
				charfield[a][b] = blank;
				}
			}
		}
	}
}

/**
* Test main, generates a char field that is 10 x 10 and uses # for the mines and ' ' for blank spaces, while using
* a click on 1,1. Prints out the field line by line.
*/	
public static void main (String[] args){
	generateField(10,10,'#',' ',10, 1,1);
	for(int b=0; b<charfield[0].length; b++){
		for(int a = 0; a<charfield.length; a++){
			System.out.print(charfield[a][b]);
			}
		System.out.println();
		}
	}
}
					
	
	
	
	
	
	