import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* The GameController class holds all source images for scenes and inventory items as well as all methods for
* switching the scenes and removing pickups. It also allows for interactive objects (Extra Credit) whic can open
* or break when clicked. The methods of this class power all the methods of every other object in the adventure.
* The constructor for this class does not initialize the variables, allowing different methods to call on a 
* GameController object and write to a static variable to keep a persistent scene
* @author Adam Yost
* @version 1.0
**/

public class GameController {
	enum Scene {
		SCENE0, SCENE0T, SCENE0O, SCENE1, SCENE1B, SCENE1T, SCENE2, SCENE2B, SCENE2T,SCENE3, SCENE3B, SCENE3T};
		
	enum State0 {
		DEFAULT, TAKEN, OPEN};
		
	enum State1{
		DEFAULT, BROKEN, TAKEN};
		
	enum State2{
		DEFAULT, BROKEN, TAKEN};
		
	enum State3 {
		DEFAULT, BROKEN, TAKEN};
		
	public static Scene current= Scene.SCENE0;
	public static State0 sc0= State0.DEFAULT;
	public static State1 sc1= State1.DEFAULT;
	public static State2 sc2= State2.DEFAULT;
	public static State3 sc3= State3.DEFAULT;
	public static boolean note = false;
	public static boolean kn = false;
	public static boolean sk = false;
	public static boolean ke = false;

 ImageIcon s0 = new ImageIcon("Scene0.png");
 ImageIcon s0t = new ImageIcon("Scene0taken.png");
 ImageIcon s0o = new ImageIcon("Scene0open.png");
 ImageIcon s1 = new ImageIcon("Scene1.png");
 ImageIcon s1b = new ImageIcon("Scene1broken.png");
 ImageIcon s1t = new ImageIcon("Scene1taken.png");
 ImageIcon s2 = new ImageIcon("Scene2.png");
 ImageIcon s2b = new ImageIcon("Scene2broken.png");
 ImageIcon s2t = new ImageIcon("Scene2taken.png");
 ImageIcon s3 = new ImageIcon("Scene3.png");
 ImageIcon s3b = new ImageIcon("Scene3broken.png");
 ImageIcon s3t = new ImageIcon("Scene3taken.png");
 
 ImageIcon inve = new ImageIcon("inve.png");
 ImageIcon invno = new ImageIcon("invno.png");
 ImageIcon invkn = new ImageIcon("invkn.png");
 ImageIcon invsk = new ImageIcon("invsk.png");
 ImageIcon invdk = new ImageIcon("invdk.png");
 
/**
* Sets the inventory box for the note to empty or full based off if you possess the note
* @return inve - empty inventory box
* @return invno - note in inventory
*/
public ImageIcon noteInv(){
	if (note == true){
		return invno;
		}
	else{
		return inve;
		}
	}
/**
* Sets the inventory box for the knife to empty or full based off if you possess the knife
* @return inve - empty inventory box
* @return invkn - knife in inventory
*/
public ImageIcon knifeInv(){
	if (kn == true){
		return invkn;
		}
	else{
		return inve;
		}
	}	
/**
* Sets the inventory box for the safeKey to empty or full based off if you possess the safeKey
* @return inve - empty inventory box
* @return invsk - skey in inventory
*/	
	
public ImageIcon skeyInv(){
	if (sk == true){
		return invsk;
		}
	else{
		return inve;
		}
	}
/**
* Sets the inventory box for the door key to empty or full based off if you possess the key
* @return inve - empty inventory box
* @return invdk - key in inventory
*/

public ImageIcon keyInv(){
	if (ke == true){
		return invdk;
		}
	else{
		return inve;
		}
	}
	
/**
* returns the ImageIcon object representing the current Scene in the Scene object.
* @return s0 - Scene0 default	
* @return s0t - Scene0 without the note
* @return s0O - Scene0 with the door open
* @return s1 - Scene1 default
* @return s1t - Scene1 without the knife
* @return s1b - Scene1 with broken glass
* @return s2 - Scene2 default
* @return s2t - Scene2 withotakenut the key
* @return s2b - Scene2 with a ripped poster
* @return s3 - Scene3 default
* @return s3t - Scene3 without the keys 
* @return s3b - Scene3 with the safe open
*/
public ImageIcon getScene(){
	switch (current){
	case SCENE0:
		return s0;
		
	case SCENE0T:
		return s0t;
		
	case SCENE0O:
		return s0o;
		
	case SCENE1:
		return s1;
		
	case SCENE1B:
		return s1b;
		
	case SCENE1T:
		return s1t;
		
	case SCENE2:
		return s2;
		
	case SCENE2B:
		return s2b;
		
	case SCENE2T:
		return s2t;
		
	case SCENE3:
		return s3;
		
	case SCENE3B:
		return s3b;
		
	case SCENE3T:
		return s3t;
		
	default:
		return s0;
	}
}

/**
* returns the Scene object stored in current
* @return current - a Scene object representing the current Scene
*/
public static Scene getCurrent(){
	return current;
	}
	
/**
* sets the State0 object (the current state of Scene0) to a State0 value
* allows for persistent scenes when using doors
* @param s State0 value
*/	
public static void setState0(State0 s){
	sc0 = s;
	}
/**
* sets the State1 object (the current state of Scene1) to a State1 value
* allows for persistent scenes when using doors
* @param s State1 value
*/		
public static void setState1(State1 s){
	sc1 = s;
	}
/**
* sets the State2 object (the current state of Scene2) to a State2 value
* allows for persistent scenes when using doors
* @param s State2 value
*/	
public static void setState2(State2 s){
	sc2 = s;
	}
/**
* sets the State3 object (the current state of Scene3) to a State3 value
* allows for persistent scenes when using doors
* @param s State3 value
*/	
public static void setState3(State3 s){
	sc3 = s;
	}	
	
/**
* Sets the Scene variable current to the Scene value provided
* changes the background to adjust for changes
* @param s Scene value representing the desired background
*/
public void setScene(Scene s){
	current = s;
	}
	
/**
* sets the boolean value of note to the given value
* @param b boolean object
*/	
public static void setNote(boolean b){
	note = b;
	}
/**
* sets the boolean value of kn to the given value
* @param b boolean object
*/	
public static void setKnife(boolean b){
	kn = b;
	}
/**
* sets the boolean value of sk to the given value
* @param b boolean object
*/
public static void setSKey(boolean b){
	sk = b;
	}
/**
* sets the boolean value of ke to the given value
* @param b boolean object
*/
public static void setKey(boolean b){
	ke = b;
	}
//This one is a doozie, I'm so sorry...


/**
* This method enacts the changes of "turning right" which happens when the Door object on the right side of the
* screen is clicked. It changes the background to the Scene positioned to the right of the current Scene,
* but it first checks the State of the scene it will be changing to in order to keep persistent scenes.
*/

public static void right(){
	if(current == Scene.SCENE0 || current == Scene.SCENE0T || current == Scene.SCENE0O){
		switch (sc1){
			case DEFAULT:
				current = Scene.SCENE1;
				break;
			case BROKEN:
				current = Scene.SCENE1B;
				break;
			case TAKEN:
				current = Scene.SCENE1T;
				break;
			default:
				current = Scene.SCENE1;
				break;
			}
		}
	else if (current == Scene.SCENE1 || current == Scene.SCENE1T || current == Scene.SCENE1B){
		switch(sc2){
			case DEFAULT:
				current = Scene.SCENE2;
				break;
			case BROKEN:
				current = Scene.SCENE2B;
				break;
			case TAKEN:
				current = Scene.SCENE2T;
				break;
			default:
				current = Scene.SCENE2;
				break;
			}
		}
	
	else if (current == Scene.SCENE2 || current == Scene.SCENE2B|| current == Scene.SCENE2T){
		switch(sc3){
			case DEFAULT:
				current = Scene.SCENE3;
				break;
			case BROKEN:
				current = Scene.SCENE3B;
				break;
			case TAKEN:
				current = Scene.SCENE3T;
				break;
			default:
				current = Scene.SCENE3;
				break;
			}
		}
	else if (current == Scene.SCENE3 || current == Scene.SCENE3T || current == Scene.SCENE3B){
		switch(sc0){
			case DEFAULT:
				current = Scene.SCENE0;
				break;
			case OPEN:
				current = Scene.SCENE0O;
				break;
			case TAKEN:
				current = Scene.SCENE0T;
				break;
			default:
				current = Scene.SCENE0;
				break;
			}
		}
	}

/**
* This method enacts the changes of "turning right" which happens when the Door object on the right side of the
* screen is clicked. It changes the background to the Scene positioned to the right of the current Scene,
* but it first checks the State of the scene it will be changing to in order to keep persistent scenes.
*/
	
public static void left(){
	if(current == Scene.SCENE0 || current == Scene.SCENE0T || current == Scene.SCENE0O){
		switch(sc3){
			case DEFAULT:
				current = Scene.SCENE3;
				break;
			case BROKEN:
				current = Scene.SCENE3B;
				break;
			case TAKEN:
				current = Scene.SCENE3T;
				break;
			default:
				current = Scene.SCENE3;
				break;
			}
				}
	else if (current == Scene.SCENE1 ||  current == Scene.SCENE1T || current == Scene.SCENE1B){
		switch(sc0){
			case DEFAULT:
				current = Scene.SCENE0;
				break;
			case OPEN:
				current = Scene.SCENE0O;
				break;
			case TAKEN:
				current = Scene.SCENE0T;
				break;
			default:
				current = Scene.SCENE2;
				break;
			}
		}
	
	else if (current == Scene.SCENE2 || current == Scene.SCENE2B|| current == Scene.SCENE2T){
		switch (sc1){
			case DEFAULT:
				current = Scene.SCENE1;
				break;
			case BROKEN:
				current = Scene.SCENE1B;
				break;
			case TAKEN:
				current = Scene.SCENE1T;
				break;
			default:
				current = Scene.SCENE1;
				break;
			}
		}
	else if (current == Scene.SCENE3 || current == Scene.SCENE3T || current == Scene.SCENE3B){
		switch(sc2){
			case DEFAULT:
				current = Scene.SCENE2;
				break;
			case BROKEN:
				current = Scene.SCENE2B;
				break;
			case TAKEN:
				current = Scene.SCENE2T;
				break;
			default:
				current = Scene.SCENE2;
				break;
			}
		}
	}
	

/**
* takes the note from the scene and adds it to your inventory, while changing the boolean to reflect the pickup
*/
public void takeNote(){
	sc0 = State0.TAKEN;
	current= Scene.SCENE0T;
	}
/**
* takes the knife from the scene and adds it to your inventory, while changing the boolean to reflect the pickup
*/
public void takeKnife(){
	sc1 = State1.TAKEN;
	current= Scene.SCENE1T;
	}
/**
* takes the safe key from the scene and adds it to your inventory, while changing the boolean to reflect the pickup
*/
public void takeSKey(){
	sc2 = State2.TAKEN;
	current= Scene.SCENE2T;
	}
/**
* takes the door key from the scene and adds it to your inventory, while changing the boolean to reflect the pickup
*/
public void takeKey(){
	sc3 = State3.TAKEN;
	current= Scene.SCENE3T;
	}
	
/**
* Breaks the window and changes the background to reflect this new situation. 
* Changes the state to ensure persistent scenes
*/
public void breakWindow(){
	sc1 = State1.BROKEN;
	current= Scene.SCENE1B;
	}
/**
* Breaks the poster and changes the background to reflect this new situation. 
* Changes the state to ensure persistent scenes
*/
public void breakPoster(){
	sc2 = State2.BROKEN;
	current= Scene.SCENE2B;
	}
/**
* opens (named break for consistency) the safe and changes the background to reflect this new situation. 
* Changes the state to ensure persistent scenes
*/
public void breakSafe(){
	sc3 = State3.BROKEN;
	current= Scene.SCENE3B;
	}
/**
* Opens the door and changes the background to reflect this new situation. 
* Changes the state to ensure persistent scenes
*/
public void openDoor(){
	sc0 = State0.OPEN;
	current= Scene.SCENE0O;
	}

public static void main(String[] args){
	}
}