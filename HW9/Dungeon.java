import java.util.*;
import java.awt.*;

/**
* Dungeon uses a MapGenerator object to create a randomized dungeon fitting the constraints set forth by the
* MapGenerator class. This dungeon is then filled filled with Tiles and creatures, and is used as a location map 
* for the actions of the creatures and tiles.
* @author Adam Yost
* @version 1.0
*/

public class Dungeon{
	
	public Player p;
	public FirstEnemy fe;
	public SecondEnemy se;
	public static Tile[][] map = new Tile[21][21];
	private final Random rnd = new Random();
	
/**
* Constructor for the Dungeon object. Takes in a MapGenerator, and uses it to generate a 21 x 21 grid of Tile objects
* with the location and type id corresponding to the correct position dictated by the MapGenerator. It then uses
* this map to generate 3 random viable locations for the enemys and players to spawn.
* @param mg a MapGenerator object
*/
	public Dungeon (MapGenerator mg){
	p = new Player(this);
	fe = new FirstEnemy(this,p);
	se = new SecondEnemy(this,p);
	char[][] charmap = mg.generateMap(5,5,3,false,'+', '-', '#');
	
	for( int x =0; x<map.length; x++){
		for( int y = 0; y<map.length; y++){
			if(charmap[x][y]==('+')){
				map[x][y] = new WallTile(this);
				map[x][y].loc = new Point(x*25,y*25);
				}
			else if( charmap[x][y] ==('-')){
				map[x][y] = new FloorTile(this);
				map[x][y].loc = new Point(x*25,y*25);
				}
			else if (charmap[x][y] ==('E')){
				map[x][y] = new ExitTile(this);
				map[x][y].loc = new Point(x*25,y*25);
				}
			else{
				map[x][y] = new TrapTile(this);
				map[x][y].loc = new Point(x*25,y*25);
				}
			}
		} 
	int placed = 0;
	int startX = 0;
	int startY = 0;
	
	while(placed <3){
		if(map[startX][startY] instanceof FloorTile){
			if(map[startX][startY] instanceof TrapTile || map[startX][startY] instanceof ExitTile){
					startX = rnd.nextInt(20)+1;
					startY = rnd.nextInt(20)+1;
				}
			else{
			Tile t = map[startX][startY];
				if(t.getOccupied() == true){
					startX = rnd.nextInt(20)+1;
					startY = rnd.nextInt(20)+1;
					}
				else{
				if(placed ==0){
					p.loc = new Point(startX *25, startY *25);
					map[startX][startY].setOccupied(true);
					map[startX][startY].setCreature(p);
					placed +=1;
					}
				else if(placed ==1){
					fe.loc = new Point(startX *25, startY *25);
					map[startX][startY].setOccupied(true);
					map[startX][startY].setCreature(fe);
					placed +=1;
					}
				else if(placed == 2){
					se.loc = new Point(startX *25, startY *25);
					map[startX][startY].setOccupied(true);
					map[startX][startY].setCreature(se);
					placed +=1;
					}
				}
				
				}
			}
		else{
			startX = rnd.nextInt(20)+1;
			startY = rnd.nextInt(20)+1;
		}	
	}
	
}

/**
* returns the tile at the location specified. Worth noting that this is the position in the 2d array, not the actual
* pixel location, which can be found by multiplying x and y by 25.
* @param x Integer object representing x location
* @param y Integer object representing y location
* @return a Tile object stored in the specified location
*/
public Tile getTile(int x, int y){
	return map[x][y];
	}
	
	public static void main (String[] args){
	}
}