import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* This is Homework 4 problem 3. It takes an input from the Location class and creats a WelcomeSign
* for the location
**/

//I completed this assignment by myself using only the resources from the textbook and materials

public class WelcomeSignGenerator{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a city:");
		String city = sc.next();
		System.out.println("Enter a state:");
		String state = sc.next();
		
/**
* Uses input to create a location object and format the input in to a string in the proper format for a Welcome Sign
**/		
		
		Location place = new Location(city,state);
		Location.normalize(place);
			
		WelcomeSign sign = new WelcomeSign(place);
		sign.showWelcomeSign();
		
	}//end main
}//end class