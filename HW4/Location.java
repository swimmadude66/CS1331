import java.util.*;
import java.lang.*;

/**
* This is Homework 4 problem 1. It performs a number of methods regarding a location object, composed of a city and
* state. 
*/

//I completed this assignment by myself using only the resources from the textbook and materials


public class Location{
	private String city;
	private String state;
	
	
/**
* creates a location object with the given city, state
* @param String city object
* @param String state object
**/	
public Location(String c, String s){
		city = c;
		state = s;
	}
	
/**
* Sets the city value of a location
* @param String
**/	

	private void setCity(String c){
		city = c;
	}
	
/**
* gets the city value of a location
* @return city
**/	
	
	private String getCity(){
		return (city);
	}
	
/**
* Sets the state value of a location
* @param String
**/	
	
	private void setState(String s){
		state = s;
	}
	
/**
* gets the state value of a location
* @return state
**/
	
	private String getState(){
		return(state);
	}
/**
* normalizes the city and state by capitalizing the first letter and lowering the rest
* @param Location 
* @return String object
**/

public static void normalize(Location pl){
		
		String c = pl.getCity();
		c = c.toLowerCase();
		c= c.substring(0,1).toUpperCase() + c.substring(1);
		pl.setCity(c);
		
		String s = pl.getState();
		s = s.toLowerCase();
		s = s.substring(0,1).toUpperCase() + s.substring(1);
		pl.setState(s);
		} //end normalize
		
		
/**
* Interprests the Location object as a string comprised of the city and state abbreviation
* @param Location
* @return string composed of the city value and the abbreviated form of the state
**/
		
public static String toString(Location pl){
	
		String c = pl.getCity();
		String s = pl.getState();
		
		int l = s.length();
		String abbrev = s.substring(0,1).toUpperCase() + s.substring(l-1).toUpperCase();
		
		return (c + ", " + abbrev);
		}//end toString

/**
* evaluates if two locations are in the same state
* @param location
* @param location
* @return boolean true if the state values of the two locations are the same
**/
public static boolean isSameState(Location pl, Location lc){
	String sone = pl.getState();
	String stwo = lc.getState();
	boolean same = sone.equalsIgnoreCase(stwo);
	
	return(same);
	}//end isSameState
	
public static void main (String[] args) {
	//----------------------------------------
	//I Used the main method to test each function
	//----------------------------------------
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter the name of a city:");
	String city = sc.next();
	System.out.println("Enter the name of a state:");
	String state = sc.next();
	
	Location lc = new Location(city, state);
	
	normalize(lc);
	String place = toString(lc);
	System.out.println(place);
	
	
	//----------------------------------------
	//isSameState test case
	//----------------------------------------
	Location pl = new Location("auGUsta", "geORGIA");
	boolean same = isSameState(lc,pl);
	System.out.println("Same state: "+same);
	
	
	
}// end main

}//end class
		